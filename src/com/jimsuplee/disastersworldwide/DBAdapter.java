/**Copyright (C) 2013 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.jimsuplee.disastersworldwide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DBAdapter {
	static final String TAG = "DBAdapter";
	static final String DATABASE_NAME = "emdata";
	static final String DATABASE_TABLE = "emdata";
	static final int DATABASE_VERSION = 1;
    static final String Affected = "Affected";
    static final String Cost = "Cost";
    static final String Country = "Country";
    static final String End = "End";
    static final String Id = "Id";
    static final String Killed = "Killed";
    static final String Location = "Location";
    static final String Name = "Name";
    static final String Startmonthday = "Startmonthday";
    static final String Startyear = "Startyear";
    static final String Sub_Type = "Sub_Type";
    static final String Type = "Type";
	static final String DATABASE_CREATE = "CREATE TABLE emdata (Startmonthday text default null, Startyear text default null, End text default null, Country text default null, Location text default null, Type text default null, Sub_Type text default null, Name text default null, Killed text default null, Cost text default null, Affected text default null, Id text default null);";
	
	final Context context;

	DatabaseHelper DBHelper;
	SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			//Log.w(TAG, "Upgrading database from version " + oldVersion + " to "+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			onCreate(db);
		}
	}

	// ---opens the database---
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	// ---closes the database---
	public void close() {
		DBHelper.close();
	}

	public Cursor getByLocation(String locationParam) throws SQLException {
		String[] columns = new String[] {Affected,Cost,Country,End,Id,Killed,Location,Name,Startmonthday,Startyear,Sub_Type,Type};				
		String selection;
		if (Disasters.pagerCounterTotal == 0) {
		    //selection = "Country=?";
			//selection = "Country=? LIMIT 100";
			selection = "Country=? ORDER BY Startyear LIMIT 100";
		    //Log.w(TAG, "In DBAdapter.getByLocation(), searching Location for: " + locationParam); 
		} else {
			//WORKS:
			selection = "Country=? ORDER BY Startyear LIMIT " + Integer.toString(Disasters.pagerCounterTotal) + ",100";
			//selection = "Country=? LIMIT " + Integer.toString(Disasters.pagerCounterTotal) + ",100";
		}
		
		    
		String[] selectionArgs = new String[] { locationParam };
		String orderBy = Startyear;
		//Log.w(TAG, "In DBAdapter.getByLocation(), About to make Cursor, c, with db.query()");
		//WORKS: unsorted:
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//NOT WORK: fails because this doesn't work in SQLite:
		// sqlite> SELECT Startyear from emdata WHERE Country="Afghanistan" LIMIT 5 ORDER BY Startyear;
		// Error: near "ORDER": syntax error
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, orderBy);
		//The LIMIT in db.query is the last (and apparently optional) argument.  Its a String:
		//String limit = "100";
		// ...but we will have a problem because we will have to manage the paging in the LIMIT argument. 
		// We will have to set it next to """ String limit = "200,100" """...and so on. 
		// Managing the LIMIT string won't be too difficult because we are already managing it by tracking 
		// the pagerCounterTotal.  But that is an integer and easy to increment.  Even so, the way to 
		// do paging is by managing the limit String in the db.query().
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, orderBy, limit);
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, orderBy);
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByLocation(String location), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByLocation(String location), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG, "In DBAdapter.getByLocation(String location), about to return cursor, c");
		return mCursor;
	}	
	
	public Cursor getByType(String typeParam) throws SQLException {
		String[] columns = new String[] {Affected,Cost,Country,End,Id,Killed,Location,Name,Startmonthday,Startyear,Sub_Type,Type};				
		String selection;
		//selection = "type LIKE ?";
		//selection = "type LIKE ?";		
		//selection = "Type=?";
		//This works when only using the Type column
		//selection = "Type=?";
		//WORKS without pager system:
		//selection = "Type=? AND Sub_Type=?";
		if (Disasters.pagerCounterTotal == 0) {
		    selection = "Type=? AND Sub_Type=? ORDER BY Startyear LIMIT 100";
		} else {
			selection = "Type=? AND Sub_Type=? ORDER BY Startyear LIMIT " + Integer.toString(Disasters.pagerCounterTotal) + ",100";
		}
		//typeParam = typeParam + "%";
		//Now that typeParam give us "Type|Sub_Type", we need to parse out the 
		// vertical pipe and use the two units
		//Log.w(TAG, "In DBAdapter.getByType(), searching Type for: " + typeParam);
		//String[] selectionArgs = new String[] { typeParam };
		//Here we try to create a two element array of strings where the first 
		// element is the value in the column "Type" and the second is the value 
		// in column "Sub_Type".  Sometimes the typeParam value fed to this method 
		// will have an empty Sub_Type component and will have a value for typeParam 
		// of, for example, "Epidemic|".  For this case the split method's second 
		// argument is negative, which indicates that we still want the empty value 
		// instead of the default of no value. 
		String[] typeSubtypePair = typeParam.split("\\|",-1);
		String[] selectionArgs = new String[] { typeSubtypePair[0], typeSubtypePair[1] };
		//Log.w(TAG, "In DBAdapter.getByType(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByType(String type), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByType(String type), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG, "In DBAdapter.getByType(String type), about to return cursor, c");
		return mCursor;
	}	
	
	public Cursor getByYear(String yearParam) throws SQLException {
		String[] columns = new String[] {Affected,Cost,Country,End,Id,Killed,Location,Name,Startmonthday,Startyear,Sub_Type,Type};				
		String selection;
		//selection = "year LIKE ?";
		//selection = "year LIKE ?";		
		//selection = "Year=?";
		//selection = "LENGTH(Year)=?";
		selection = "Startyear=?";
		//yearParam = yearParam + "%";
		//Log.w(TAG, "In DBAdapter.getByYear(), searching Year for: " + yearParam);
		String[] selectionArgs = new String[] { yearParam };
		//Log.w(TAG, "In DBAdapter.getByYear(), About to make Cursor, c, with db.query()");
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByYear(String year), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByYear(String year), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG, "In DBAdapter.getByYear(String year), about to return cursor, c");
		return mCursor;
	}	
	public Cursor getByKilledHundredThousand(String killedParam) throws SQLException {
		String[] columns = new String[] {Affected,Cost,Country,End,Id,Killed,Location,Name,Startmonthday,Startyear,Sub_Type,Type};				
		String selection;
		selection = Killed+"<"+1000000+" AND "+Killed+">"+100000;
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, null, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByKilledHundredThousand(String killed), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByKilledHundredThousand(String killed), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG, "In DBAdapter.getByKilledHundredThousand(String killed), about to return cursor, c");
		return mCursor;
	}
	public Cursor getByKilledTenThousand(String killedParam) throws SQLException {
		String[] columns = new String[] {Affected,Cost,Country,End,Id,Killed,Location,Name,Startmonthday,Startyear,Sub_Type,Type};				
		String selection;
		selection = Killed+"<"+100000+" AND "+Killed+">"+10000;
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, null, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByKilledTenThousand(String killed), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByKilledTenThousand(String killed), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG, "In DBAdapter.getByKilledTenThousand(String killed), about to return cursor, c");
		return mCursor;
	}
	public Cursor getByKilled(String killedParam) throws SQLException {
		String[] columns = new String[] {Affected,Cost,Country,End,Id,Killed,Location,Name,Startmonthday,Startyear,Sub_Type,Type};				
		String selection;
		//selection = "killed LIKE ?";
		//selection = "killed LIKE ?";		
		//selection = "Killed=?";
		//The SQLite3 LENGTH() function can tell how many characters long it is
		// and so in this case, greater than 6 chars long would mean over 1,000,000 killed
		// But these LENGTH() functions don't seem to work: hmmm.
		//selection = "LENGTH(Killed)>?";
		//selection = "LENGTH(Killed)=?";
		//selection = "Killed>? AND Killed !=?";
		//selection = "Killed!=? AND Killed>?";
		//selection = "Killed>? AND Killed !=''";
		//selection = "Killed>? AND Killed!=``";
		//selection = "Killed>? AND Killed!=\"\"";
		//selection = "Killed>? AND Killed!=''";
		//selection = "Killed>? AND Killed<?";
		//selection = "Killed=?";
		//selection = "Killed<?";
		//selection = "Killed<? AND Killed>?";
		//selection = "Killed>? AND Killed<?";
		//selection = "Killed=?";
		//selection = Killed+"=5000000";
		//selection = Killed+"="+5000000;
		//WORKS:
		//selection = Killed+"<"+5000001+" AND "+Killed+">"+3000000;
		selection = Killed+">"+1000000;
		//After LOTS of fighting sqlite which thinks null or empty Killed (integer affinity) column 
		// values were >5000000 or infinity, I set them all to 0, with sql like this in sqlite3:
		// sqlite> UPDATE emdata SET Killed=0 WHERE Killed > 5000000;
		// ...and then replaced the database in assets folder in android project directory.
		// ...and deleted AVD and RunConfig and made new ones, since they remember. 
		// ...while we're at it, the Cost field (integer affinity) also has empties
		// ...and so we fix again like this:
		// sqlite> UPDATE emdata SET Cost=0 WHERE Cost > 300000000;

		//killedParam = killedParam + "%";
		killedParam="480";
		//This killedParamTwo is for the Killed!=? part of the selection query.  Without it, then 
		// all of the results without a specified (i.e. null) value for Killed column will be 
		// returned.  By adding the AND Killed!=?, we get AND Killed!="", which removes records 
		// with an empty Killed column value from the results. 
		//String killedParamTwo="";
		//String killedParamTwo="''";
		//String killedParamTwo=null;
		//String killedParamTwo="\"\"";
		//String killedParamTwo="";
		//The very highest record in the database was 5 million
		String killedParamTwo="500";
		//PROBLEM 100113__The type (affinity, they say) of sqlite3 db emdata.Killed is integer...but 
		// it seems to be difficult to search by integer.  This searches by string:
		// selection = "Killed>? AND Killed<?";
		// killedParam="480";
		// String killedParamTwo="500";
		// ...and shows me all of the records with Killed STRINGS inside the query parameters.  For 
		// example, I get records where Killed=4892 and Killed=481 and Killed=49...like in ASCII order.
		// It seems like the database is getting the query as-a-string and choosing to convert the 
		// stored type/affinity from integer to the presumably comparable string.  But we want to 
		// do the opposite, we want to search by integer.  We want the system to convert our __>"480"__
		// to __>480__ and leave the database values with their native (integer) affinity.  But this 
		// db.query mechanism here wants the selectionArgs to be an array of String.  
		//Log.w(TAG, "In DBAdapter.getByKilled(), searching Killed for >: " + killedParam +" and < " + killedParamTwo);
		//String[] selectionArgs = new String[] { killedParam, killedParamTwo };
		//String[] selectionArgs = new String[] { killedParamTwo, killedParam };
		//String[] selectionArgs = new String[] { killedParam };
		//String[] selectionArgs = new String[] { killedParam, killedParamTwo };
		//String[] selectionArgs = new String[] { killedParam };
		//String[] selectionArgs = new String[] { killedParam, killedParamTwo };
		//String[] selectionArgs = new String[] { killedParam, killedParamTwo };
		//String[] selectionArgs = new String[] { killedParam };
		//String[] selectionArgs = null;
		String[] selectionArgs = null;

		
		////Log.w(TAG, "In DBAdapter.getByKilled(), values: " + selection + " " + selectionArgs[0] + " " + selectionArgs[1] + " " + killedParam + " " + killedParamTwo  + " END");
		////Log.w(TAG, "In DBAdapter.getByKilled(), values: " + selection + " " + selectionArgs[0] + " " + killedParam + " " + killedParamTwo  + " END");
		//Log.w(TAG, "In DBAdapter.getByKilled(), About to make Cursor, c, with db.query()");
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, null, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByKilled(String killed), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByKilled(String killed), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG, "In DBAdapter.getByKilled(String killed), about to return cursor, c");
		return mCursor;
	}
}
