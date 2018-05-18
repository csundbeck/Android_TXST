package edu.txstate.crs181.hotel;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    public static final String KEY_HOTEL_ID = "a";
    public static final String KEY_HOTEL_NAME = "b";
    public static final String KEY_HOTEL_CITY = "c";
    public static final String KEY_STAR_RATING = "d";

    List<Hotel> hotelList = new ArrayList<Hotel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hotelList.add(new Hotel(1,"The Bowery","New York, NY",5));
        hotelList.add(new Hotel(2,"Holiday Inn","Los Angeles, CA",2));
        hotelList.add(new Hotel(3,"Motel 6","Phoenix, AZ",1));
        hotelList.add(new Hotel(4,"Embassy Suites","Austin, TX",4));
        hotelList.add(new Hotel(5,"Double Tree","Chicago, IL",3));

        setListAdapter(new ArrayAdapter<Hotel>
                (MainActivity.this,
                        R.layout.activity_main,
                        R.id.hotel,
                        hotelList));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        final SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        SharedPreferences.Editor editor = preference.edit();

        editor.putInt((MainActivity.KEY_HOTEL_ID),hotelList.get(position).getId());
        editor.putString((MainActivity.KEY_HOTEL_NAME),hotelList.get(position).getName());
        editor.putString((MainActivity.KEY_HOTEL_CITY),hotelList.get(position).getCity());
        editor.putInt((MainActivity.KEY_STAR_RATING),hotelList.get(position).getStarRating());

        editor.commit();

        startActivity(new Intent(MainActivity.this, HotelDetailActivity.class));
    }
}
