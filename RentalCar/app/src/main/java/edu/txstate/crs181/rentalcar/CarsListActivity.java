package edu.txstate.crs181.rentalcar;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CarsListActivity extends ListActivity {

    //Keys used to store data; these are defined as constants with the 'static final' key words and should be defined in all CAPS
    public static final String KEY_CAR_ID = "a";
    public static final String KEY_CAR_NAME = "b";
    public static final String KEY_CAR_BRAND = "c";
    public static final String KEY_CAR_COLOR = "d";
    public static final String KEY_COST_PER_DAY = "e";
    public static final String KEY_CAR_URL = "f";

    public static final Integer[] images = { R.drawable.f150,
            R.drawable.mustang, R.drawable.camero, R.drawable.charger, R.drawable.corvette };

    //ArrayList created using the Car.java class
    static List<Car> carsList = new ArrayList<Car>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Insert items in a custom the carsList ArrayList using properties in the Cars.java class
        carsList.add(new Car(1,"F-150","Ford","White",65.00,"http://www.ford.com/trucks/f150/?gnav=header-all-vehicles", images[0]));
        carsList.add(new Car(2,"Mustang","Ford","Red",80.00,"http://www.ford.com/performance/gt350/?gnav=header-all-vehicles", images[1]));
        carsList.add(new Car(3,"Camero","Chevy","Black",100.00,"http://www.chevrolet.com/performance/camaro-sports-car" ,images[2]));
        carsList.add(new Car(4,"Charger","Dodge","Blue",110.00,"http://www.dodge.com/charger.html", images[3]));
        carsList.add(new Car(5,"Corvette","Chevy","Green",120.00,"http://www.chevrolet.com/performance/corvette-z06-sports-car", images[4]));

        //Array Adapter constructor
        setListAdapter(new ArrayAdapter<Car>(
                CarsListActivity.this,
                R.layout.activity_cars_list,
                R.id.carsList,
                carsList));
    }

    //When a list item is clicked, run the following methods...
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //Variable used to define how we will persist data
        final SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(CarsListActivity.this);
        SharedPreferences.Editor editor = preference.edit();

        //KEYS and GET methods (from Cars class) to write the data to memory
        editor.putInt((CarsListActivity.KEY_CAR_ID), carsList.get(position).getCarId());
        editor.putString(CarsListActivity.KEY_CAR_NAME, carsList.get(position).getName());
        editor.putString(CarsListActivity.KEY_CAR_BRAND, carsList.get(position).getBrand());
        editor.putString(CarsListActivity.KEY_CAR_COLOR, carsList.get(position).getCarColor());
        editor.putFloat(CarsListActivity.KEY_COST_PER_DAY, (float) carsList.get(position).getRentalCostPerDay());
        editor.putString(CarsListActivity.KEY_CAR_URL, carsList.get(position).getUrl());

        //This statement commits the data to memory to be used in other activities
        editor.commit();

        //When an item is clicked, this statement will redirect the app to another actvity (CarDetail.class)
        startActivity(new Intent(CarsListActivity.this, CarDetail.class));
    }
}
