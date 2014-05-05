package com.jimsuplee.disastersworldwide;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.net.Uri;
import android.widget.TextView;
import android.widget.Button;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.DatePicker;
import android.widget.Toast;
import java.util.Date;
import java.text.SimpleDateFormat;
import android.widget.ImageView;
import java.util.HashMap;
import java.util.Map;

public class Disasters extends Activity {
	DBAdapter db;
	static final String TAG = "DISASTERS";
	//Disasters.country String will be set to the chosen country.  It is 
	// static because it will be written to by other classes.  This global 
	// is NOT good but convenient.  It is used to select the image to display. 
	static String country = "";
	HashMap<String,Integer> photoMap = new HashMap<String,Integer>();
	static int pagerCounter = 0;
	static int pagerCounterTotal = 0;
	static String locationChoice = "";
	static String descriptionChoice = "";
	static String locationType = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		photoMap.put("Afghanistan", R.drawable.afghanistan);
	    photoMap.put("Albania", R.drawable.albania);
	    photoMap.put("Algeria", R.drawable.algeria);
	    photoMap.put("Angola", R.drawable.angola);
	    photoMap.put("Anguilla", R.drawable.anguilla);
	    photoMap.put("Argentina", R.drawable.argentina);
	    photoMap.put("Armenia", R.drawable.armenia);
	    photoMap.put("Australia", R.drawable.australia);
	    photoMap.put("Austria", R.drawable.austria);
	    photoMap.put("Bahamas", R.drawable.bahamas);
	    photoMap.put("Bahrain", R.drawable.bahrain);
	    photoMap.put("Bangladesh", R.drawable.bangladesh);
	    photoMap.put("Barbados", R.drawable.barbados);
	    photoMap.put("Belarus", R.drawable.belarus);
	    photoMap.put("Belgium", R.drawable.belgium);
	    photoMap.put("Belize", R.drawable.belize);
	    photoMap.put("Benin", R.drawable.benin);
	    photoMap.put("Bermuda", R.drawable.bermuda);
	    photoMap.put("Bhutan", R.drawable.bhutan);
	    photoMap.put("Botswana", R.drawable.botswana);
	    photoMap.put("Brazil", R.drawable.brazil);
	    photoMap.put("Bulgaria", R.drawable.bulgaria);
	    photoMap.put("Burundi", R.drawable.burundi);
	    photoMap.put("Cambodia", R.drawable.cambodia);
	    photoMap.put("Cameroon", R.drawable.cameroon);
	    photoMap.put("Canada", R.drawable.canada);
	    photoMap.put("Chad", R.drawable.chad);
	    photoMap.put("Chile", R.drawable.chile);
	    photoMap.put("Colombia", R.drawable.colombia);
	    photoMap.put("Comoros", R.drawable.comoros);
	    photoMap.put("Congo", R.drawable.congo);
	    photoMap.put("Croatia", R.drawable.croatia);
	    photoMap.put("Cuba", R.drawable.cuba);
	    photoMap.put("Cyprus", R.drawable.cyprus);
	    photoMap.put("Denmark", R.drawable.denmark);
	    photoMap.put("Djibouti", R.drawable.djibouti);
	    photoMap.put("Dominica", R.drawable.dominica);
	    photoMap.put("Ecuador", R.drawable.ecuador);
	    photoMap.put("Egypt", R.drawable.egypt);
	    photoMap.put("Eritrea", R.drawable.eritrea);
	    photoMap.put("Estonia", R.drawable.estonia);
	    photoMap.put("Ethiopia", R.drawable.ethiopia);
	    photoMap.put("Fiji", R.drawable.fiji);
	    photoMap.put("Finland", R.drawable.finland);
	    photoMap.put("France", R.drawable.france);
	    photoMap.put("Gabon", R.drawable.gabon);
	    photoMap.put("Georgia", R.drawable.georgia);
	    photoMap.put("Germany", R.drawable.germany);
	    photoMap.put("Ghana", R.drawable.ghana);
	    photoMap.put("Greece", R.drawable.greece);
	    photoMap.put("Grenada", R.drawable.grenada);
	    photoMap.put("Guam", R.drawable.guam);
	    photoMap.put("Guatemala", R.drawable.guatemala);
	    photoMap.put("Guinea", R.drawable.guinea);
	    photoMap.put("Guyana", R.drawable.guyana);
	    photoMap.put("Haiti", R.drawable.haiti);
	    photoMap.put("Honduras", R.drawable.honduras);
	    photoMap.put("Hungary", R.drawable.hungary);
	    photoMap.put("Iceland", R.drawable.iceland);
	    photoMap.put("India", R.drawable.india);
	    photoMap.put("Indonesia", R.drawable.indonesia);
	    photoMap.put("Iraq", R.drawable.iraq);
	    photoMap.put("Ireland", R.drawable.ireland);
	    photoMap.put("Israel", R.drawable.israel);
	    photoMap.put("Italy", R.drawable.italy);
	    photoMap.put("Jamaica", R.drawable.jamaica);
	    photoMap.put("Japan", R.drawable.japan);
	    photoMap.put("Jordan", R.drawable.jordan);
	    photoMap.put("Kazakhstan", R.drawable.kazakhstan);
	    photoMap.put("Kenya", R.drawable.kenya);
	    photoMap.put("Kiribati", R.drawable.kiribati);
	    photoMap.put("Kuwait", R.drawable.kuwait);
	    photoMap.put("Kyrgyzstan", R.drawable.kyrgyzstan);
	    photoMap.put("Latvia", R.drawable.latvia);
	    photoMap.put("Lebanon", R.drawable.lebanon);
	    photoMap.put("Lesotho", R.drawable.lesotho);
	    photoMap.put("Liberia", R.drawable.liberia);
	    photoMap.put("Lithuania", R.drawable.lithuania);
	    photoMap.put("Luxembourg", R.drawable.luxembourg);
	    photoMap.put("Madagascar", R.drawable.madagascar);
	    photoMap.put("Malawi", R.drawable.malawi);
	    photoMap.put("Malaysia", R.drawable.malaysia);
	    photoMap.put("Maldives", R.drawable.maldives);
	    photoMap.put("Mali", R.drawable.mali);
	    photoMap.put("Malta", R.drawable.malta);
	    photoMap.put("Martinique", R.drawable.martinique);
	    photoMap.put("Mauritania", R.drawable.mauritania);
	    photoMap.put("Mauritius", R.drawable.mauritius);
	    photoMap.put("Mayotte", R.drawable.mayotte);
	    photoMap.put("Mexico", R.drawable.mexico);
	    photoMap.put("Mongolia", R.drawable.mongolia);
	    photoMap.put("Montenegro", R.drawable.montenegro);
	    photoMap.put("Montserrat", R.drawable.montserrat);
	    photoMap.put("Morocco", R.drawable.morocco);
	    photoMap.put("Mozambique", R.drawable.mozambique);
	    photoMap.put("Namibia", R.drawable.namibia);
	    photoMap.put("Nepal", R.drawable.nepal);
	    photoMap.put("Netherlands", R.drawable.netherlands);
	    photoMap.put("Nicaragua", R.drawable.nicaragua);
	    photoMap.put("Nigeria", R.drawable.nigeria);
	    photoMap.put("Niger", R.drawable.niger);
	    photoMap.put("Niue", R.drawable.niue);
	    photoMap.put("Norway", R.drawable.norway);
	    photoMap.put("Oman", R.drawable.oman);
	    photoMap.put("Pakistan", R.drawable.pakistan);
	    photoMap.put("Palau", R.drawable.palau);
	    photoMap.put("Panama", R.drawable.panama);
	    photoMap.put("Paraguay", R.drawable.paraguay);
	    photoMap.put("Philippines", R.drawable.philippines);
	    photoMap.put("Poland", R.drawable.poland);
	    photoMap.put("Portugal", R.drawable.portugal);
	    photoMap.put("Romania", R.drawable.romania);
	    photoMap.put("Rwanda", R.drawable.rwanda);
	    photoMap.put("Samoa", R.drawable.samoa);
	    photoMap.put("Senegal", R.drawable.senegal);
	    photoMap.put("Serbia", R.drawable.serbia);
	    photoMap.put("Seychelles", R.drawable.seychelles);
	    photoMap.put("Singapore", R.drawable.singapore);
	    photoMap.put("Slovakia", R.drawable.slovakia);
	    photoMap.put("Slovenia", R.drawable.slovenia);
	    photoMap.put("Somalia", R.drawable.somalia);
	    photoMap.put("Spain", R.drawable.spain);
	    photoMap.put("Sudan", R.drawable.sudan);
	    photoMap.put("Suriname", R.drawable.suriname);
	    photoMap.put("Swaziland", R.drawable.swaziland);
	    photoMap.put("Sweden", R.drawable.sweden);
	    photoMap.put("Switzerland", R.drawable.switzerland);
	    photoMap.put("Tajikistan", R.drawable.tajikistan);
	    photoMap.put("Thailand", R.drawable.thailand);
	    photoMap.put("Togo", R.drawable.togo);
	    photoMap.put("Tonga", R.drawable.tonga);
	    photoMap.put("Tunisia", R.drawable.tunisia);
	    photoMap.put("Turkey", R.drawable.turkey);
	    photoMap.put("Turkmenistan", R.drawable.turkmenistan);
	    photoMap.put("Tuvalu", R.drawable.tuvalu);
	    photoMap.put("Uganda", R.drawable.uganda);
	    photoMap.put("Ukraine", R.drawable.ukraine);
	    photoMap.put("Uruguay", R.drawable.uruguay);
	    photoMap.put("Uzbekistan", R.drawable.uzbekistan);
	    photoMap.put("Vanuatu", R.drawable.vanuatu);
	    photoMap.put("Yemen", R.drawable.yemen);
	    photoMap.put("Zambia", R.drawable.zambia);
	    photoMap.put("Zimbabwe", R.drawable.zimbabwe);
	    photoMap.put("American Samoa", R.drawable.americansamoa);
	    photoMap.put("Antigua and Barbuda", R.drawable.antiguaandbarbuda);
	    photoMap.put("Brunei Darussalam", R.drawable.bruneidarussalam);
	    photoMap.put("Burkina Faso", R.drawable.burkinafaso);
	    photoMap.put("Cayman Islands", R.drawable.caymanislands);
	    photoMap.put("Costa Rica", R.drawable.costarica);
	    photoMap.put("El Salvador", R.drawable.elsalvador);
	    photoMap.put("Equatorial Guinea", R.drawable.equatorialguinea);
	    photoMap.put("French Polynesia", R.drawable.frenchpolynesia);
	    photoMap.put("New Zealand", R.drawable.newzealand);
	    photoMap.put("Papua New Guinea", R.drawable.papuanewguinea);
	    photoMap.put("Puerto Rico", R.drawable.puertorico);
	    photoMap.put("Saudi Arabia", R.drawable.saudiarabia);
	    photoMap.put("Sierra Leone", R.drawable.sierraleone);
	    photoMap.put("South Africa", R.drawable.southafrica);
	    photoMap.put("Sri Lanka", R.drawable.srilanka);
	    photoMap.put("Timor-Leste", R.drawable.timorleste);
	    photoMap.put("Trinidad and Tobago", R.drawable.trinidadandtobago);
	    photoMap.put("United Arab Emirates", R.drawable.unitedarabemirates);
	    photoMap.put("United States", R.drawable.unitedstates);
	    photoMap.put("Viet Nam", R.drawable.vietnam);
	    photoMap.put("China P Rep", R.drawable.china);
	    photoMap.put("Korea Dem P Rep", R.drawable.northkorea);
	    photoMap.put("Korea Rep", R.drawable.koreademprep);
	    photoMap.put("Russia", R.drawable.russia);
	    photoMap.put("Soviet Union", R.drawable.russia);
	    
		setContentView(R.layout.activity_disasters);
		try {
			String destPath = "/data/data/" + getPackageName() + "/databases";
			File f = new File(destPath);
			if (!f.exists()) {
				f.mkdirs();
				f.createNewFile();
				Toast.makeText(this, "Please Wait...Database Being Created",
						Toast.LENGTH_LONG).show();
				CopyDB(getBaseContext().getAssets().open("emdata"),
						new FileOutputStream(destPath + "/emdata"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Now that we (hopefully) have an SQLiteDatabase available, lets make
		// an adapter and put it
		// into our global variable.
		db = new DBAdapter(this);
	}
	
	public void CopyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		// copy 1024 bytes at a time
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}
	
	public void onClickLocation(View view) {
		//Log.w(TAG, "In Disasters.onClickLocation()");
		locationChoice = "";
		locationType = "";
		descriptionChoice = "";
		pagerCounter = 0;
		pagerCounterTotal = 0;
		Intent iLocation = new Intent("com.jimsuplee.disastersworldwide.Location");
		startActivityForResult(iLocation, 0);
	}
	
	public void onClickLocationMore(View view) {
		//Log.w(TAG, "In Disasters.onClickLocationMore()");
		Intent iLocation = new Intent("com.jimsuplee.disastersworldwide.Location");
		startActivityForResult(iLocation, 0);
	}
	
	public void onClickType(View view) {
		//Log.w(TAG, "In Disasters.onClickType()");
		locationChoice = "";
		locationType = "";
		descriptionChoice = "";
		pagerCounter = 0;
		pagerCounterTotal = 0;
		Intent iType = new Intent("com.jimsuplee.disastersworldwide.Type");
		startActivityForResult(iType, 1);
	}
	
	public void onClickTypeMore(View view) {
		//Log.w(TAG, "In Disasters.onClickTypeMore()");
		Intent iType = new Intent("com.jimsuplee.disastersworldwide.Type");
		startActivityForResult(iType, 1);
	}
	
	public void onClickYear(View view) {
		//Log.w(TAG, "In Disasters.onClickYear()");
		Intent iYear = new Intent("com.jimsuplee.disastersworldwide.Year");
		startActivityForResult(iYear, 4);
	}
	
	public void onClickKilled(View view) {
		//Log.w(TAG, "In Disasters.onClickKilled()");
		db.open();
		Cursor c = db.getByKilled("5");
		//Log.w(TAG, "In Disasters.onClickKilled(), db.getByKilled(killed) returned with cursor");
		
		String results = "";
		if (c != null) {
			//Log.w(TAG, "In Disasters.onClickKilled(), cursor is not null");
		}
		int counterResults = 0;
		if (c.moveToFirst()) {
			//Log.w(TAG, "In Disasters.onClickKilled(), cursor.moveToFirst() is true, about to loop through results");
			do {
				counterResults++;
				//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Location: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
	 		    results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
			} while (c.moveToNext());
			//Log.w(TAG, "In Disasters.onClickKilled(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
		} else {
			//Log.w(TAG, "In Disasters.onClickKilled(), cursor.moveToFirst() is NOT TRUE!");
		}
		//Log.w(TAG, "In Disasters.onClickKilled(), done looping, about to make Results intent, iResults");
		Intent iResults = new Intent("com.jimsuplee.disastersworldwide.Results");
		iResults.putExtra("results", results);
		//Log.w(TAG, "In Disasters.onClickKilled(), about to startActivityForResult(iResults, 3)");
		startActivityForResult(iResults, 3);
		//Log.w(TAG, "In Disasters.onClickKilled(), iResults started, about to db.close()");
		db.close();
	}
	
	public void onClickKilledHundredThousand(View view) {
		//Log.w(TAG, "In Disasters.onClickKilledHundredThousand()");
		db.open();
		Cursor c = db.getByKilledHundredThousand("6");
		//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), db.getByKilledHundredThousand(killed) returned with cursor");
		
		String results = "";
		if (c != null) {
			//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), cursor is not null");
		}
		int counterResults = 0;
		if (c.moveToFirst()) {
			//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), cursor.moveToFirst() is true, about to loop through results");
			do {
				counterResults++;
				//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Location: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
	 		    results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
			} while (c.moveToNext());
			//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
		} else {
			//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), cursor.moveToFirst() is NOT TRUE!");
		}
		//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), done looping, about to make Results intent, iResults");
		Intent iResults = new Intent("com.jimsuplee.disastersworldwide.Results");
		iResults.putExtra("results", results);
		//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), about to startActivityForResult(iResults, 3)");
		startActivityForResult(iResults, 3);
		//Log.w(TAG, "In Disasters.onClickKilledHundredThousand(), iResults started, about to db.close()");
		db.close();
	}
	
	public void onClickKilledTenThousand(View view) {
		//Log.w(TAG, "In Disasters.onClickKilledTenThousand()");
		db.open();
		Cursor c = db.getByKilledTenThousand("6");
		//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), db.getByKilledTenThousand(killed) returned with cursor");
		
		String results = "";
		if (c != null) {
			//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), cursor is not null");
		}
		int counterResults = 0;
		if (c.moveToFirst()) {
			//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), cursor.moveToFirst() is true, about to loop through results");
			do {
				counterResults++;
				//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Location: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
	 		    results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
			} while (c.moveToNext());
			//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
		} else {
			//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), cursor.moveToFirst() is NOT TRUE!");
		}
		//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), done looping, about to make Results intent, iResults");
		Intent iResults = new Intent("com.jimsuplee.disastersworldwide.Results");
		iResults.putExtra("results", results);
		//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), about to startActivityForResult(iResults, 3)");
		startActivityForResult(iResults, 3);
		//Log.w(TAG, "In Disasters.onClickKilledTenThousand(), iResults started, about to db.close()");
		db.close();
	}
	
	public void onClickHelp(View view) {
		//Log.w(TAG, "In Disasters.onClickHelp()");
		//String disasterData = Html.fromHtml(data.getData().toString()).toString();
		String disasterData = "Disasters wordwide from 1900-2008\n\nA comprehensive listing of of over 17,000 disasters, natural and otherwise, from around the globe.\n    \nSince 1988 the WHO Collaborating Centre for Research on the Epidemiology of Disasters (CRED) has been maintaining an Emergency Events Database EM-DAT. EM-DAT was created with the initial support of the WHO and the Belgian Government.\n\nThe main objective of the database is to serve the purposes of humanitarian action at national and international levels. It is an initiative aimed to rationalise decision making for disaster preparedness, as well as providing an objective base for vulnerability assessment and priority setting. For example, it allows on to decide whether floods in a given country are more significant in terms of its human impact than earthquakes or whether a country is more vulnerable than another for computing resources is.\n\nEM-DAT contains essential core data on the occurrence and effects of over 16,000 mass disasters in the world from 1900 to present. The database is compiled from various sources, including UN agencies, non-governmental organisations, insurance companies, research institutes and press agencies.\n    \nThis is only public domain natural disaster database around (two other global sources are private: Sigma from Swiss Re and NatCat from Munich Re).\n    \nLICENSE:\n    \nThe EM-DAT database is protected by the law of 30 June 1994 on copyright and the law of 31 August 1998 on the legal protection of databases.\n    \nEM-DAT was created in 1988 at the Université Catholique de Louvain by researchers at the Centre de Recherche sur l’Epidemiologie des Desastres – Centre for Research on the Epidemiology of Disasters (CRED). The database was set up with the support of the WHO and the Belgian government. Since 1999, CRED has received support from the Office of Foreign Disaster Assistance (OFDA) of the US Agency for International Development (USAID). The Université Catholique de Louvain holds the copyright for the database.\nThe EM-DAT database has been made available for unrestricted access free of charge by UCL so that anyone with a query can obtain information.\nThe reproduction and communication of the information obtained using the EM-DAT is authorised by any means and in all forms, provided that the source is mentioned clearly as follows: \n    EM-DAT: The OFDA/CRED International Disaster Database – www.emdat.be – Université Catholique de Louvain – Brussels – Belgium.\nwww.emdat.be\nhttp://www.emdat.be/\n    \nDisaster Criteria:\n\nFor a disaster to be entered into the database at least one of the following criteria must be fulfilled:\n      \n      • Ten (10) or more people reported killed.\n      • Hundred (100) or more people reported affected.\n      • Declaration of a state of emergency.\n      • Call for international assistance.\n      \nDisaster Classification:\n      \n      EM-DAT distinguishes two generic categories for disasters (natural and technological),\n      the natural disaster category being divided into 5 sub-groups, which in turn cover 12\n      disaster types and more than 30 sub-types.\n      \n      Geophysical => Events originating from solid earth 	ie: Earthquake,Volcano,Mass Movement (dry)\n      \n      Meteorological => Events caused by short-lived/small to meso scale atmospheric processes\n                        (in the spectrum from minutes to days)  ie: Storm\n                        \n      Hydrological =>	Events caused by deviations in the normal water cycle and/or overflow of bodies\n                      of water caused by wind set-up 	ie: Flood,Mass Movement (wet)\n      \n      Climatological => Events caused by long-lived/meso to macro scale processes (in the spectrum from\n                        intra-seasonal to multi-decadal climate variability)\n                        ie: Extreme Temperature,Drought,Wildfire\n                        \n      Biological => Disaster caused by the exposure of living organisms to germs and toxic substances\n                    ie: Epidemic,Insect infestation,Animal Stampede\n      \n      \n      Fields:\n      \n      Start:          The date which the disaster began.\n      End:            The date which the disaster ended.\n      Country:        Country(ies) in which the disaster has occurred.\n      Location:       A sub-location classification if available.\n      Type:           The type of disaster according to pre-defined classification.\n      Sub_Type:       Further classification of the type of disaster.\n      Name:           The name of the disaster if available.\n      Killed:         Persons confirmed as dead and persons missing and presumed dead\n                      (official figures when available).\n      Affected:       Total of people injured, homeless, and affected. Where\n                      affected means people requiring immediate assistance during a period\n                      of emergency;it can also include displaced or evacuated people\n      Cost:           Several institutions have developed methodologies to quantify\n                      these losses in their specific domain. However, there is no standard\n                      procedure to determine a global figure for economic impact. Estimated\n                      damage are given (000’)\n      Id:             A unique identifier for the disaster.\n\n\nCREDITS:\n\nEM-DAT: The OFDA/CRED International Disaster Database – www.emdat.be – Université Catholique de Louvain – Brussels – Belgium. www.emdat.be\n\nGanglion Jacob Perkins\n\nen.wikipedia.org/wiki/ISO_3166-1_alpha-2\n\nwww.nordicfactory.com\n\nDisaster Responders Everywhere\n";
		TextView tv = (TextView) findViewById(R.id.txt_Disasterdata);
		tv.setVisibility(View.VISIBLE);
		tv.setText(disasterData);
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// ---check if the request code is 0 1 2 3 4 5---
		//Log.w(TAG, "In Disasters.onActivityResult(), checking reqCod");
		// onClickLocation startActivityForResult section
		if (requestCode == 0) {
			//Log.w(TAG, "In Disasters.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String location = data.getData().toString();
				//Log.w(TAG, "In Disasters.onActivityResult(), location is: " + location);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to db.getByLocation()");
				
				Cursor c = db.getByLocation(location);
				//Log.w(TAG, "In Disasters.onActivityResult(), db.getByLocation returned with cursor");
				
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						pagerCounter++;
						counterResults++;						
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Location: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
					} while (c.moveToNext());
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}
				
				
				
				if (pagerCounter == 100) {
					pagerCounterTotal += 100;
					pagerCounter = 0;
					locationType = "locationCity";
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounter is 100: "+ Integer.toString(pagerCounter));
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
					//Log.w(TAG,"In Disasters.onActivityResult(), locationChoice is: "+ locationChoice);
					//Log.w(TAG,"In Disasters.onActivityResult(), locationType is: "+ locationType);
					//Log.w(TAG,"In Disasters.onActivityResult(), descriptionChoice is: "+ descriptionChoice);
					// results+=Integer.toString(pagerCounterTotal);
				} else {
					// results+=Integer.toString(pagerCounter);
					pagerCounterTotal = 0;
					pagerCounter = 0;
					locationChoice = "";
					locationType = "";
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounter is NOT 100: "+ Integer.toString(pagerCounter));
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
					//Log.w(TAG,"In Disasters.onActivityResult(), locationChoice is: "+ locationChoice);
					//Log.w(TAG,"In Disasters.onActivityResult(), locationType is: "+ locationType);

				}
				
				
				
				
				
				
				//Log.w(TAG, "In Disasters.onActivityResult(), done looping, about to make Results intent, iResults");
				Intent iResults = new Intent("com.jimsuplee.disastersworldwide.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Disasters.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
		
		if (requestCode == 1) {
			//Log.w(TAG, "In Disasters.onActivityResult(int-reqCode=1,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String killed = data.getData().toString();
				//Log.w(TAG, "In Disasters.onActivityResult(), killed is: " + killed);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to db.getByType()");
				
				Cursor c = db.getByType(killed);
				//Log.w(TAG, "In Disasters.onActivityResult(), db.getByType(killed) returned with cursor");
				
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						counterResults++;
						pagerCounter++;
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Location: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
					} while (c.moveToNext());
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}
				if (pagerCounter == 100) {
					pagerCounterTotal += 100;
					pagerCounter = 0;
					//locationType = "locationCity";
					//Disasters.descriptionChoice was set in Type.java
					//descriptionChoice = descriptionParam;
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounter is 100: "+ Integer.toString(pagerCounter));
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
					//Log.w(TAG,"In Disasters.onActivityResult(), locationChoice is: "+ locationChoice);
					//Log.w(TAG,"In Disasters.onActivityResult(), locationType is: "+ locationType);
					// results+=Integer.toString(pagerCounterTotal);
				} else {
					// results+=Integer.toString(pagerCounter);
					pagerCounterTotal = 0;
					pagerCounter = 0;
					locationChoice = "";
					locationType = "";
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounter is NOT 100: "+ Integer.toString(pagerCounter));
					//Log.w(TAG,"In Disasters.onActivityResult(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
					//Log.w(TAG,"In Disasters.onActivityResult(), locationChoice is: "+ locationChoice);
					//Log.w(TAG,"In Disasters.onActivityResult(), locationType is: "+ locationType);

				}
				//Log.w(TAG, "In Disasters.onActivityResult(), done looping, about to make Results intent, iResults");
				Intent iResults = new Intent("com.jimsuplee.disastersworldwide.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Disasters.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
		
		if (requestCode == 2) {
			//Log.w(TAG, "In Disasters.onActivityResult(int-reqCode=2,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String killed = data.getData().toString();
				//Log.w(TAG, "In Disasters.onActivityResult(), killed is: " + killed);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to db.getByKilled()");
				
				Cursor c = db.getByKilled(killed);
				//Log.w(TAG, "In Disasters.onActivityResult(), db.getByKilled(killed) returned with cursor");
				
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						counterResults++;
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Location: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    //results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
						//results += "\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +  "\nEnd: " + c.getString(3) + "\nId: " + c.getString(4) + "\nKilled: " + c.getString(5) + "\nLocation: " + c.getString(6) + "\nName: " + c.getString(7) + "\nStartmonthday: " + c.getString(8) + "\nStartyear: " + c.getString(9) + "\nSub_Type: " + c.getString(10) + "\nType: " + c.getString(11) + "___";
						results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
			 		    } while (c.moveToNext());
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}
				//Log.w(TAG, "In Disasters.onActivityResult(), done looping, about to make Results intent, iResults");
				Intent iResults = new Intent("com.jimsuplee.disastersworldwide.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Disasters.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
		if (requestCode == 4) {
			//Log.w(TAG, "In Disasters.onActivityResult(int-reqCode=4,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				db.open();
				String year = data.getData().toString();
				//Log.w(TAG, "In Disasters.onActivityResult(), year is: " + year);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to db.getByYear()");
				
				Cursor c = db.getByYear(year);
				//Log.w(TAG, "In Disasters.onActivityResult(), db.getByYear(year) returned with cursor");
				
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						pagerCounter++;
						counterResults++;
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Location: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nLocation: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
					} while (c.moveToNext());
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Disasters.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}
				
				
				

				
				
				
				
				
				
				
				//Log.w(TAG, "In Disasters.onActivityResult(), done looping, about to make Results intent, iResults");
				Intent iResults = new Intent("com.jimsuplee.disastersworldwide.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Disasters.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Disasters.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
		
		if (requestCode == 3) {
			//Log.w(TAG, "In Disasters.onActivityResult(int-reqCode=3,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				//Log.w(TAG, "In Disasters.onActivityResult(3) RESULT_OK, about to set TextView");
				//String disasterData = Html.fromHtml(data.getData().toString()).toString();
				// The next if/else lines decide whether there are more (than
				// the last 10) records
				// If so, then make-visible the proper 10-more-records button in
				// activity_ufosightings.xml
				// Decide and set visibility of the LocationPager
				Button pagerButton = (Button) findViewById(R.id.btn_LocationPager);
				if (pagerCounterTotal > 0 && locationType == "locationCity") {
					pagerButton.setVisibility(View.VISIBLE);
				} else {
					pagerButton.setVisibility(View.INVISIBLE);
				}
				pagerButton = (Button) findViewById(R.id.btn_TypePager);
				if (pagerCounterTotal > 0 && descriptionChoice != "") {
					pagerButton.setVisibility(View.VISIBLE);
				} else {
					pagerButton.setVisibility(View.INVISIBLE);
				}
				String disasterData = data.getData().toString();
				TextView tv = (TextView) findViewById(R.id.txt_Disasterdata);
				tv.setVisibility(View.VISIBLE);
				tv.setText(disasterData);
				ImageView iv = (ImageView) findViewById(R.id.imagedetail);
            	if(photoMap.get(Disasters.country) != null) {
            		//Log.w(TAG, "In Disasters.onActivityResult(3) photoMap ok, about to set ImageView to"+Disasters.country);
            	    //iv.setImageResource(photoMap.get(Disasters.country));
            		iv.setImageResource(photoMap.get(country));
            	    //iv.setVisibility(View.VISIBLE);
            	} else {
            		//Log.w(TAG, "In Disasters.onActivityResult(3) photoMap empty, about to set ImageView to"+Disasters.country);
            	    //iv.setImageResource(photoMap.get(Disasters.country));
            		iv.setImageResource(R.drawable.disasters);
            	    //iv.setVisibility(View.VISIBLE);
            	}
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.disasters, menu);
		return true;
	}

}
