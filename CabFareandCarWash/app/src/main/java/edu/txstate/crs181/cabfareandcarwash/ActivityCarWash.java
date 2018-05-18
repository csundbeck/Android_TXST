package edu.txstate.crs181.cabfareandcarwash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ActivityCarWash extends AppCompatActivity {

    double dblExteriorDiscountPrice = 8.99;
    double dblExteriorAndInteriorDiscountPrice = 12.99;

    double dblExteriorPrice = 10.99;
    double dblExteriorAndInteriorPrice = 15.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_wash);

        final EditText numberOfCarWashes = findViewById(R.id.txtNumberOfCarWashes);
        final RadioButton exteriorOnly = findViewById(R.id.radExteriorOnly);
        final RadioButton exteriorAndInterior = findViewById(R.id.radExteriorAndInterior);
        final TextView result = findViewById(R.id.txtResults);

        Button calculatePackage = findViewById(R.id.btnCalculatePackage);
        calculatePackage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double dblResult = 0;
                String strNumberOfCarWashes = numberOfCarWashes.getText().toString();
                int intNumberOfCarWashes = Integer.parseInt(strNumberOfCarWashes);

                if (exteriorOnly.isChecked( )) {
                    if (intNumberOfCarWashes >= 12) {
                        dblResult = intNumberOfCarWashes * dblExteriorDiscountPrice;

                    } else if (intNumberOfCarWashes < 12){
                        dblResult = intNumberOfCarWashes * dblExteriorPrice;

                    } else {
                        Toast.makeText(ActivityCarWash.this, "Error: Please enter an acceptable number of car washes.", Toast.LENGTH_SHORT).show();
                    }

                } else if (exteriorAndInterior.isChecked( )) {

                    if (intNumberOfCarWashes >= 12) {
                        dblResult = intNumberOfCarWashes * dblExteriorAndInteriorDiscountPrice;

                    } else if (intNumberOfCarWashes < 12){
                        dblResult = intNumberOfCarWashes * dblExteriorAndInteriorPrice;

                    } else {
                        Toast.makeText(ActivityCarWash.this, "Error: Please enter an acceptable number of car washes.", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(ActivityCarWash.this, "Error: Please select a car wash type.", Toast.LENGTH_SHORT).show();
                }

                DecimalFormat formatter = new DecimalFormat("$###.##");
                result.setText(formatter.format(dblResult));

            }
        });
    }
}