package edu.txstate.crs181.cityguide;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {

    //Fixed Array (Cannot be altered later in the code)
    //String[] attraction = {"Art Institute of Chicago", "Magnificent Mile", "Willis Tower",
    //        "Navy Pier", "Water Tower"};

    //This type of array is not fixed (ArrayList)
    //List<String> attraction = new ArrayList<String>();

    //This type or Array has Key Value pairs (Map (Like an Object in Javascript))
    Map<String, String> attractionMap = new HashMap<String, String>();

    //Creating a CustomList from a defined class (Attraction.java)
    List<Attraction> attractionList = new ArrayList<Attraction>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Comment out the line below when creating custom layouts with XML.
        //setContentView(R.layout.activity_main);

        //Inserting items in the ArrayList
//        attraction.add("Art Institute of Chicago");
//        attraction.add("Magnificent Mile");
//        attraction.add("Willis Tower");
//        attraction.add("Navy Pier");
//        attraction.add("Water Tower");

        //Inserting items in the Map
        attractionMap.put("Art Institute of Chicago", "http://artic.edu");
        attractionMap.put("Magnificent Mile", "http://themagnificentmile.com");
        attractionMap.put("Willis Tower", "http://google.com");

        //Inserting items in the ArrayList using the Attraction class
        attractionList.add(new Attraction(1, "Art Institute of Chicago", "123-456-7890", "123 Crest Dr., Chicago, IL",
                20.00, 0, "http://artic.edu"));
        attractionList.add(new Attraction(2, "Magnificent Mile", "123-912-7766", "124 West Dr., Chicago, IL",
                10.00, 1, "http://themagnificentmile.com"));
        attractionList.add(new Attraction(3, "Willis Tower", "123-665-2561", "500 Willis St., Chicago, IL",
                15.00, 2, "http://google.com"));
        attractionList.add(new Attraction(4, "Navy Pier", "123-773-1652", "621 Lake Ave., Chicago, IL",
                50.00, 2, "http://google.com"));
        attractionList.add(new Attraction(5, "Water Tower", "123-324-8861", "223 East Dr., Chicago, IL",
                14.00, 2, "http://google.com"));


        //Custom layout has 3 parameters
//        setListAdapter(new ArrayAdapter<String> //data type for the ArrayAdapter
//                (MainActivity.this, // specify which activity (MainActivity.this),
//                        android.R.layout.simple_list_item_1, // layout (screen) configuration,
//                        attraction)); // data source (in this case, an array, attraction).

        //Designing the layout with a class
//        setListAdapter(new ArrayAdapter<Attraction> //data type for the ArrayAdapter
//                (MainActivity.this, // specify which activity (MainActivity.this),
//                        android.R.layout.simple_list_item_1, // layout (screen) configuration,
//                        attractionList)); // data source (in this case, an ArrayList, attractionList).

        //Overloaded ArrayAdapter constructor method
        setListAdapter(new ArrayAdapter<Attraction> //data type for the ArrayAdapter
                (MainActivity.this, // specify which activity (MainActivity.this), Model
                        R.layout.activity_main, // layout (screen) configuration, View
                        R.id.travel,
                        attractionList)); // data source (in this case, an ArrayList, attractionList). Controller
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);

        //Displays a message that reads the array and displays the appropriate index with fixed array
        //Toast.makeText(this, attraction[position], Toast.LENGTH_SHORT).show();

        //Displays a message that reads the array and displays the appropriate index with array list
        //Toast.makeText(this, attractionList.get(position) + ".", Toast.LENGTH_LONG).show();

        //Displays a message that reads the array and displays the appropriate index with array list and each item's name
          Toast.makeText(this, attractionList.get(position).getName() + ".", Toast.LENGTH_LONG).show();

//        String key = attraction.get(position);
//        String value = attractionMap.get(key);
//        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(value)));
          startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(attractionList.get(position).getUrl())));

//        if (position == 0) {
//            //Switching to the specified activity (Redirection the activity to a URL with Uri.parse())
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://artic.edu")));
//        }else if (position == 1) {
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://themagnificentmile.com")));
//        }else if (position == 2) {
//            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com")));
//        }else if (position == 3) {
//
//        }else if (position == 4) {
//
//        } else {
//
//        }


        
    }
}

