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

import android.app.ListActivity;
import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.net.Uri;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.util.Log;

public class Type extends ListActivity {
	static final String TAG = "DISASTERS";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Disasters.descriptionChoice == "") {
 	        displayListView();
		} else {
			//Log.w(TAG,"In Type.onCreate(), Disasters.descriptionChoice!=emptyString, setting descriptionChoice to Disasters.descriptionChoice and calling finish()");
			Intent i = new Intent("");
			String descriptionChoice = Disasters.descriptionChoice;
			i.setData(Uri.parse(descriptionChoice));
			setResult(RESULT_OK, i);
			finish();
		}
	}


	private void displayListView() {
		List<String> typeList = new ArrayList<String>();
	    //typeList.add("Complex Disasters");
	    //typeList.add("Drought");
	    //typeList.add("Earthquake (seismic activity)");
	    //typeList.add("Epidemic");
	    //typeList.add("Extreme temperature");
	    //typeList.add("Flood");
	    //typeList.add("Industrial Accident");
	    //typeList.add("Insect infestation");
	    //typeList.add("Mass Movement Dry");
	    //typeList.add("Mass Movement Wet");
	    //typeList.add("Mass movement dry");
	    //typeList.add("Mass movement wet");
	    //typeList.add("Miscellaneous accident");
	    //typeList.add("Storm");
	    //typeList.add("Transport Accident");
	    //typeList.add("Transport accident");
	    //typeList.add("Volcano");
	    //typeList.add("Wildfire");
        //The more general "Type" column will return MANY results!  Better to 
		// specify the more specific (FEWER RESULTS) Sub_Type:
		// These come, with vertical pipes, directly from sqlite3 like this:
		// sqlite> select DISTINCT Type, Sub_Type FROM emdata ORDER BY Type, Sub_Type;
		// And so must deal with the vertical-pipe, as in Type|Sub_Type:
		// Notice that many times a record will specify (have) a Type value but not a 
		// Sub_Type value.  For example:
		// sqlite> select count(*) FROM emdata WHERE Type='Epidemic' AND Sub_Type="";
		// 140
		typeList.add("Complex Disasters|");
        typeList.add("Complex Disasters|Famine");
        typeList.add("Drought|Drought");
        typeList.add("Earthquake (seismic activity)|");
        typeList.add("Earthquake (seismic activity)|Earthquake (ground shaking)");
        typeList.add("Earthquake (seismic activity)|Tsunami");
        typeList.add("Epidemic|");
        typeList.add("Epidemic|Bacterial Infectious Diseases");
        typeList.add("Epidemic|Parasitic Infectious Diseases");
        typeList.add("Epidemic|Viral Infectious Diseases");
        typeList.add("Extreme temperature|Cold Wave");
        typeList.add("Extreme temperature|Cold wave");
        typeList.add("Extreme temperature|Extreme winter conditions");
        typeList.add("Extreme temperature|Heat wave");
        typeList.add("Flood|");
        typeList.add("Flood|Flash Flood");
        typeList.add("Flood|Flash flood");
        typeList.add("Flood|General Flood");
        typeList.add("Flood|General flood");
        typeList.add("Flood|General flood/Mudslide");
        typeList.add("Flood|Storm surge/coastal Flood");
        typeList.add("Flood|Storm surge/coastal flood");
        typeList.add("Industrial Accident|Chemical Spill");
        typeList.add("Industrial Accident|Collapse");
        typeList.add("Industrial Accident|Explosion");
        typeList.add("Industrial Accident|Fire");
        typeList.add("Industrial Accident|Gas Leak");
        typeList.add("Industrial Accident|Oil Spill");
        typeList.add("Industrial Accident|Other");
        typeList.add("Industrial Accident|Poisoning");
        typeList.add("Industrial Accident|Radiation");
        typeList.add("Insect infestation|");
        typeList.add("Insect infestation|Grasshopper");
        typeList.add("Insect infestation|Grasshopper/Locust");
        typeList.add("Insect infestation|Locust");
        typeList.add("Mass Movement Dry|");
        typeList.add("Mass Movement Dry|Landslide");
        typeList.add("Mass Movement Dry|Rockfall");
        typeList.add("Mass Movement Wet|Avalanche");
        typeList.add("Mass Movement Wet|Landslide");
        typeList.add("Mass movement dry|Avalanche");
        typeList.add("Mass movement dry|Debris flow");
        typeList.add("Mass movement dry|Landslide");
        typeList.add("Mass movement dry|Rockfall");
        typeList.add("Mass movement dry|Subsidence");
        typeList.add("Mass movement wet|Avalanche");
        typeList.add("Mass movement wet|Debris flow");
        typeList.add("Mass movement wet|Landslide");
        typeList.add("Mass movement wet|Subsidence");
        typeList.add("Miscellaneous accident|Collapse");
        typeList.add("Miscellaneous accident|Explosion");
        typeList.add("Miscellaneous accident|Fire");
        typeList.add("Miscellaneous accident|Other");
        typeList.add("Storm|");
        typeList.add("Storm|Extratropical cyclone");
        typeList.add("Storm|Extratropical cyclone (winter storm)");
        typeList.add("Storm|Local storm");
        typeList.add("Storm|Tropical cyclone");
        typeList.add("Transport Accident|Air");
        typeList.add("Transport Accident|Rail");
        typeList.add("Transport Accident|Road");
        typeList.add("Transport Accident|Water");
        typeList.add("Transport accident|");
        typeList.add("Transport accident|Air");
        typeList.add("Transport accident|Rail");
        typeList.add("Transport accident|Road");
        typeList.add("Transport accident|Water");
        typeList.add("Volcano|Volcanic eruption");
        typeList.add("Wildfire|");
        typeList.add("Wildfire|Bush/Brush fire");
        typeList.add("Wildfire|Forest fire");
        typeList.add("Wildfire|Scrub/grassland fire");

		// create ArrayAdaptar from String Array
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, typeList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		// enables filtering ListView
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				String typeChoice = ((TextView) view).getText().toString();
				Disasters.descriptionChoice = typeChoice;
				i.setData(Uri.parse(typeChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}
