package edu.txstate.crs181.rentalcar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CarDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        final EditText numberOfDays = findViewById(R.id.txtNumberOfDays);
        TextView carSpecs = findViewById(R.id.txtCarInfo);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(CarDetail.this);

        //Data is read from the SharedPreference Manager in the CarsListActivity, and assigned to new variables in the CarDetail activity
        //KEYS MUST CORRESPOND WITH KEYS IN CarsListActivity; SET DEFAULT VALUES TO AN EMPTY VALUE (0, 0.00f, "", etc.)
        final int intCarId = pref.getInt(CarsListActivity.KEY_CAR_ID, 0);
        final String strName = pref.getString(CarsListActivity.KEY_CAR_NAME, "");
        final String strBrand = pref.getString(CarsListActivity.KEY_CAR_BRAND, "");
        final String strCarColor = pref.getString(CarsListActivity.KEY_CAR_COLOR, "");
        final float fltRentalCostPerDay = pref.getFloat(String.valueOf(CarsListActivity.KEY_COST_PER_DAY), 0.00f);
        final String strUrl = pref.getString(CarsListActivity.KEY_CAR_URL, "");

        //Setting text in the TextView to display the saved data from the SharedPreference Manager
        carSpecs.setText("ID: " + intCarId + ", Car: " +  strBrand + " " + strName + ", Color: " + strCarColor + ", Cost: $" + fltRentalCostPerDay);

        Button calculateTotalCost = findViewById(R.id.btnCalculateTotalCost);
        calculateTotalCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Turn EditText value into Integers
                int intNumberOfDays = Integer.parseInt(numberOfDays.getText().toString());

                double dblTotalCost;

                //If inNumberOfDays is less that 30, calculate the total cost. if otherwise, write a message that tells the user to call a phone number
                if (intNumberOfDays < 30) {
                    dblTotalCost = intNumberOfDays * fltRentalCostPerDay;
                    DecimalFormat formatter = new DecimalFormat("$###,###.##");
                    String strTotalCost = formatter.format(dblTotalCost);
                    Toast.makeText(CarDetail.this, strTotalCost, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CarDetail.this, "Please call 512-777-2222 for pricing.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button getCarInfo = findViewById(R.id.btnCarInfo);
        getCarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //This button redirects the app to the url that was defined in the CarsListActivity
                //strUrl is defined above using the KEY_CAR_URL that was created in the CarsLIstActivity
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(strUrl)));

            }
        });
    }
}
