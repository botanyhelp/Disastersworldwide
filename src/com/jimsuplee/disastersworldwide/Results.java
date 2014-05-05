package com.jimsuplee.disastersworldwide;

import android.app.ListActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.view.Gravity;


public class Results extends ListActivity {
	static final String TAG = "DISASTERS";
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    String results = getIntent().getStringExtra("results");
	    //Log.w(TAG, "In Results.onCreate(), about to displayListView(results)");
	    displayListView(results);
    }
	
	private void displayListView(String results) {
		//Log.w(TAG, "In Results.displayListView(results)");
		List<String> resultsList = new ArrayList<String>(Arrays.asList(results.split("___")));
		// create an ArrayAdaptar from String Array
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, resultsList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		// filter listView
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				String resultChoice = ((TextView) view).getText().toString();
				String[] countryOne = resultChoice.split("Country: ");
				//String[] countryTwo = countryOne[1].split("\nEnd");
				String[] countryTwo = countryOne[1].split("\nLocation:");
				Disasters.country = countryTwo[0];
				//Log.w(TAG, "In Results.displayListView(results), setting Disasters.country to: "+countryTwo[0]);
				i.setData(Uri.parse(resultChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
    }
}
