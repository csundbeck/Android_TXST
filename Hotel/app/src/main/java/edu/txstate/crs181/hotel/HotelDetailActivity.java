package edu.txstate.crs181.hotel;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class HotelDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);

        final TextView hotelDetails = findViewById(R.id.hotelDetails);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(HotelDetailActivity.this);

        final int intId = pref.getInt(MainActivity.KEY_HOTEL_ID, 0);
        final String strName = pref.getString(MainActivity.KEY_HOTEL_NAME, "");
        final String strCity = pref.getString(MainActivity.KEY_HOTEL_CITY, "");
        final int intStarRating = pref.getInt(MainActivity.KEY_STAR_RATING, 0);

        hotelDetails.setText("ID: " + intId + "\nName: " + strName + "\nCity: " + strCity + "\nRating: " + intStarRating + " Star");

        if (intStarRating < 3) {
            Toast.makeText(this, "This hotel is not recommended.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "We hope you enjoy your stay!", Toast.LENGTH_SHORT).show();
        }

    }
}
