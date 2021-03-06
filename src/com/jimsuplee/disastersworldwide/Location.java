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

public class Location extends ListActivity {
	static final String TAG = "DISASTERS";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Disasters.locationChoice == "") {
	        displayListView();
		} else {
			//Log.w(TAG,"In Location.onCreate(), Disasters.locationChoice!=emptyString, setting locationChoice to Disasters.locationChoice and calling finish()");
			Intent i = new Intent("");
			String locationChoice = Disasters.locationChoice;
			i.setData(Uri.parse(locationChoice));
			setResult(RESULT_OK, i);
			finish();
		}
	}


	private void displayListView() {
		List<String> locationList = new ArrayList<String>();
        locationList.add("Afghanistan");
        locationList.add("Albania");
        locationList.add("Algeria");
        locationList.add("American Samoa");
        locationList.add("Angola");
        locationList.add("Anguilla");
        locationList.add("Antigua and Barbuda");
        locationList.add("Argentina");
        locationList.add("Armenia");
        locationList.add("Australia");
        locationList.add("Austria");
        locationList.add("Azerbaijan");
        locationList.add("Azores");
        locationList.add("Bahamas");
        locationList.add("Bahrain");
        locationList.add("Bangladesh");
        locationList.add("Barbados");
        locationList.add("Belarus");
        locationList.add("Belgium");
        locationList.add("Belize");
        locationList.add("Benin");
        locationList.add("Bermuda");
        locationList.add("Bhutan");
        locationList.add("Bolivia");
        locationList.add("Bosnia-Hercegovenia");
        locationList.add("Botswana");
        locationList.add("Brazil");
        locationList.add("Brunei Darussalam");
        locationList.add("Bulgaria");
        locationList.add("Burkina Faso");
        locationList.add("Burundi");
        locationList.add("Cambodia");
        locationList.add("Cameroon");
        locationList.add("Canada");
        locationList.add("Canary Is");
        locationList.add("Cape Verde Is");
        locationList.add("Cayman Islands");
        locationList.add("Central African Rep");
        locationList.add("Chad");
        locationList.add("Chile");
        locationList.add("China P Rep");
        locationList.add("Colombia");
        locationList.add("Comoros");
        locationList.add("Congo");
        locationList.add("Cook Is");
        locationList.add("Costa Rica");
        locationList.add("Cote d_Ivoire");
        locationList.add("Croatia");
        locationList.add("Cuba");
        locationList.add("Cyprus");
        locationList.add("Czech Rep");
        locationList.add("Czechoslovakia");
        locationList.add("Denmark");
        locationList.add("Djibouti");
        locationList.add("Dominica");
        locationList.add("Dominican Rep");
        locationList.add("East Timor");
        locationList.add("Ecuador");
        locationList.add("Egypt");
        locationList.add("El Salvador");
        locationList.add("Equatorial Guinea");
        locationList.add("Eritrea");
        locationList.add("Estonia");
        locationList.add("Ethiopia");
        locationList.add("Fiji");
        locationList.add("Finland");
        locationList.add("France");
        locationList.add("French Guiana");
        locationList.add("French Polynesia");
        locationList.add("Gabon");
        locationList.add("Gambia The");
        locationList.add("Georgia");
        locationList.add("Germany");
        locationList.add("Germany Dem Rep");
        locationList.add("Germany Fed Rep");
        locationList.add("Ghana");
        locationList.add("Greece");
        locationList.add("Grenada");
        locationList.add("Guadeloupe");
        locationList.add("Guam");
        locationList.add("Guatemala");
        locationList.add("Guinea");
        locationList.add("Guinea Bissau");
        locationList.add("Guyana");
        locationList.add("Haiti");
        locationList.add("Honduras");
        locationList.add("Hong Kong (China)");
        locationList.add("Hungary");
        locationList.add("Iceland");
        locationList.add("India");
        locationList.add("Indonesia");
        locationList.add("Iran Islam Rep");
        locationList.add("Iraq");
        locationList.add("Ireland");
        locationList.add("Israel");
        locationList.add("Italy");
        locationList.add("Jamaica");
        locationList.add("Japan");
        locationList.add("Jordan");
        locationList.add("Kazakhstan");
        locationList.add("Kenya");
        locationList.add("Kiribati");
        locationList.add("Korea Dem P Rep");
        locationList.add("Korea Rep");
        locationList.add("Kuwait");
        locationList.add("Kyrgyzstan");
        locationList.add("Lao P Dem Rep");
        locationList.add("Latvia");
        locationList.add("Lebanon");
        locationList.add("Lesotho");
        locationList.add("Liberia");
        locationList.add("Libyan Arab Jamah");
        locationList.add("Lithuania");
        locationList.add("Luxembourg");
        locationList.add("Macau");
        locationList.add("Macedonia FRY");
        locationList.add("Madagascar");
        locationList.add("Malawi");
        locationList.add("Malaysia");
        locationList.add("Maldives");
        locationList.add("Mali");
        locationList.add("Malta");
        locationList.add("Marshall Is");
        locationList.add("Martinique");
        locationList.add("Mauritania");
        locationList.add("Mauritius");
        locationList.add("Mayotte");
        locationList.add("Mexico");
        locationList.add("Micronesia Fed States");
        locationList.add("Moldova Rep");
        locationList.add("Mongolia");
        locationList.add("Montenegro");
        locationList.add("Montserrat");
        locationList.add("Morocco");
        locationList.add("Mozambique");
        locationList.add("Myanmar");
        locationList.add("Namibia");
        locationList.add("Nepal");
        locationList.add("Netherlands");
        locationList.add("Netherlands Antilles");
        locationList.add("New Caledonia");
        locationList.add("New Zealand");
        locationList.add("Nicaragua");
        locationList.add("Niger");
        locationList.add("Nigeria");
        locationList.add("Niue");
        locationList.add("Northern Mariana Is");
        locationList.add("Norway");
        locationList.add("Oman");
        locationList.add("Pakistan");
        locationList.add("Palau");
        locationList.add("Palestine (West Bank)");
        locationList.add("Panama");
        locationList.add("Papua New Guinea");
        locationList.add("Paraguay");
        locationList.add("Peru");
        locationList.add("Philippines");
        locationList.add("Poland");
        locationList.add("Portugal");
        locationList.add("Puerto Rico");
        locationList.add("Reunion");
        locationList.add("Romania");
        locationList.add("Russia");
        locationList.add("Rwanda");
        locationList.add("Samoa");
        locationList.add("Sao Tome et Principe");
        locationList.add("Saudi Arabia");
        locationList.add("Senegal");
        locationList.add("Serbia");
        locationList.add("Serbia Montenegro");
        locationList.add("Seychelles");
        locationList.add("Sierra Leone");
        locationList.add("Singapore");
        locationList.add("Slovakia");
        locationList.add("Slovenia");
        locationList.add("Solomon Is");
        locationList.add("Somalia");
        locationList.add("South Africa");
        locationList.add("Soviet Union");
        locationList.add("Spain");
        locationList.add("Sri Lanka");
        locationList.add("St Helena");
        locationList.add("St Kitts and Nevis");
        locationList.add("St Lucia");
        locationList.add("St Vincent and The Grenadines");
        locationList.add("St Vincent and the Grenadines");
        locationList.add("Sudan");
        locationList.add("Suriname");
        locationList.add("Swaziland");
        locationList.add("Sweden");
        locationList.add("Switzerland");
        locationList.add("Syrian Arab Rep");
        locationList.add("Taiwan (China)");
        locationList.add("Tajikistan");
        locationList.add("Tanzania Uni Rep");
        locationList.add("Thailand");
        locationList.add("Timor-Leste");
        locationList.add("Togo");
        locationList.add("Tokelau");
        locationList.add("Tonga");
        locationList.add("Trinidad and Tobago");
        locationList.add("Tunisia");
        locationList.add("Turkey");
        locationList.add("Turkmenistan");
        locationList.add("Turks and Caicos Is");
        locationList.add("Tuvalu");
        locationList.add("Uganda");
        locationList.add("Ukraine");
        locationList.add("United Arab Emirates");
        locationList.add("United Kingdom");
        locationList.add("United States");
        locationList.add("Uruguay");
        locationList.add("Uzbekistan");
        locationList.add("Vanuatu");
        locationList.add("Venezuela");
        locationList.add("Viet Nam");
        locationList.add("Virgin Is (UK)");
        locationList.add("Virgin Is (US)");
        locationList.add("Wallis ");
        locationList.add("Wallis and Futuna Is");
        locationList.add("Yemen");
        locationList.add("Yemen Arab Rep");
        locationList.add("Yemen P Dem Rep");
        locationList.add("Yugoslavia");
        locationList.add("Zaire/Congo Dem Rep");
        locationList.add("Zambia");
        locationList.add("Zimbabwe");
		// create an ArrayAdaptar from String Array
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, locationList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		//filtering  ListView
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				String locationChoice = ((TextView) view).getText().toString();
				Disasters.locationChoice = locationChoice;				
				i.setData(Uri.parse(locationChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}
