package edu.txstate.crs181.cabfareandcarwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ActivityCabFare extends AppCompatActivity {

    double costPerMile = 3.25;
    double flatRate = 3.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_fare);

        final EditText numberOfMiles = findViewById(R.id.txtNumberOfMiles);
        final TextView result = findViewById(R.id.txtTotalFare);
        Button calculateFare = findViewById(R.id.btnCalculateFare);


        calculateFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strNumberOfMiles = numberOfMiles.getText().toString();
                double dblNumberOfMiles = Double.parseDouble(strNumberOfMiles);
                double dblTotalCost = flatRate + (costPerMile * dblNumberOfMiles);

                DecimalFormat format = new DecimalFormat("$#,###.##");
                String strTotalFare = format.format(dblTotalCost);

                //***OUTPUT***
                result.setText(strTotalFare);

            }
        });
    }
}
