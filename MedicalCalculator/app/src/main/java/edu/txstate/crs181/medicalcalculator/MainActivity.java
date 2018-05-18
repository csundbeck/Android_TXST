package edu.txstate.crs181.medicalcalculator;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double conversionRate = 2.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText patientWeight = findViewById(R.id.txtPatientWeight);
        final TextView results = findViewById(R.id.txtResults);

        final RadioButton poundsToKilo = findViewById(R.id.radPoundsToKilo);
        final RadioButton kiloToPounds = findViewById(R.id.radKiloToPounds);

        Button convertWeight = findViewById(R.id.btnConvertWeight);
        convertWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double dblResults = 0;
                //Converting a String input to a Double type
                double dblWeight = Double.parseDouble(patientWeight.getText().toString());
                //Checking which radio button is selected
                if (poundsToKilo.isChecked()) {
                    if (dblWeight > 300 || dblWeight < 0) {
                        //Error message
                        Toast.makeText(MainActivity.this, "The amount of weight entered is not acceptable.", Toast.LENGTH_SHORT).show();
                    } else {
                        dblResults = dblWeight/conversionRate;
                    }

                } else if (kiloToPounds.isChecked()) {
                    dblResults = dblWeight*conversionRate;
                } else {
                    //Error message
                    Toast.makeText(MainActivity.this, "Error: Please select a conversion type.", Toast.LENGTH_SHORT).show();
                }

                DecimalFormat formatter = new DecimalFormat("#.#");
                results.setText(formatter.format(dblResults));

            }
        });

    }
}
