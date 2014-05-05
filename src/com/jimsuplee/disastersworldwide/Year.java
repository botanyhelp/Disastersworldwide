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

public class Year extends ListActivity {
	static final String TAG = "DISASTERS";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    displayListView();
	}


	private void displayListView() {
		List<String> yearList = new ArrayList<String>();
        yearList.add("2008");
        yearList.add("2007");
        yearList.add("2006");
        yearList.add("2005");
        yearList.add("2004");
        yearList.add("2003");
        yearList.add("2002");
        yearList.add("2001");
        yearList.add("2000");
        yearList.add("1999");
        yearList.add("1998");
        yearList.add("1997");
        yearList.add("1996");
        yearList.add("1995");
        yearList.add("1994");
        yearList.add("1993");
        yearList.add("1992");
        yearList.add("1991");
        yearList.add("1990");
        yearList.add("1989");
        yearList.add("1988");
        yearList.add("1987");
        yearList.add("1986");
        yearList.add("1985");
        yearList.add("1984");
        yearList.add("1983");
        yearList.add("1982");
        yearList.add("1981");
        yearList.add("1980");
        yearList.add("1979");
        yearList.add("1978");
        yearList.add("1977");
        yearList.add("1976");
        yearList.add("1975");
        yearList.add("1974");
        yearList.add("1973");
        yearList.add("1972");
        yearList.add("1971");
        yearList.add("1970");
        yearList.add("1969");
        yearList.add("1968");
        yearList.add("1967");
        yearList.add("1966");
        yearList.add("1965");
        yearList.add("1964");
        yearList.add("1963");
        yearList.add("1962");
        yearList.add("1961");
        yearList.add("1960");
        yearList.add("1959");
        yearList.add("1958");
        yearList.add("1957");
        yearList.add("1956");
        yearList.add("1955");
        yearList.add("1954");
        yearList.add("1953");
        yearList.add("1952");
        yearList.add("1951");
        yearList.add("1950");
        yearList.add("1949");
        yearList.add("1948");
        yearList.add("1947");
        yearList.add("1946");
        yearList.add("1945");
        yearList.add("1944");
        yearList.add("1943");
        yearList.add("1942");
        yearList.add("1941");
        yearList.add("1940");
        yearList.add("1939");
        yearList.add("1938");
        yearList.add("1937");
        yearList.add("1936");
        yearList.add("1935");
        yearList.add("1934");
        yearList.add("1933");
        yearList.add("1932");
        yearList.add("1931");
        yearList.add("1930");
        yearList.add("1929");
        yearList.add("1928");
        yearList.add("1927");
        yearList.add("1926");
        yearList.add("1925");
        yearList.add("1924");
        yearList.add("1923");
        yearList.add("1922");
        yearList.add("1921");
        yearList.add("1920");
        yearList.add("1919");
        yearList.add("1918");
        yearList.add("1917");
        yearList.add("1916");
        yearList.add("1915");
        yearList.add("1914");
        yearList.add("1913");
        yearList.add("1912");
        yearList.add("1911");
        yearList.add("1910");
        yearList.add("1909");
        yearList.add("1908");
        yearList.add("1907");
        yearList.add("1906");
        yearList.add("1905");
        yearList.add("1904");
        yearList.add("1903");
        yearList.add("1902");
        yearList.add("1901");
        yearList.add("1900");
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, yearList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				String yearChoice = ((TextView) view).getText().toString();
				i.setData(Uri.parse(yearChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}
