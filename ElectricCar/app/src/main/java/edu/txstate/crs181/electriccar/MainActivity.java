package edu.txstate.crs181.electriccar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Keys are constants and should be defined in all CAPS
    public static final String KEY_NUMBER_OF_YEARS = "a";
    public static final String KEY_LOAN_AMOUNT = "b";
    public static final String KEY_INTEREST_RATE = "c";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberOfYears = findViewById(R.id.txtNumberOfYears);
        final EditText carLoanAmount = findViewById(R.id.txtCarLoanAmount);
        final EditText interestRate = findViewById(R.id.txtInterestRate);
        //Database connection variable
        final SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);

        Button calculatePayment = findViewById(R.id.btnCarPayment);
        calculatePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //START: Receive the input
                    //User interaction
                //END: Receive the input

                //START: Convert the input data to be numbers
                    int intNumberOfYears = Integer.parseInt(numberOfYears.getText().toString());
                    int intCarLoanAmount = Integer.parseInt(carLoanAmount.getText().toString());
                    double dblInterestRate = Double.parseDouble(interestRate.getText().toString());
                    SharedPreferences.Editor editor = preference.edit();
                //END: Convert the input data to be numbers

                //START: Save the numeric data into data storage (database)
                    editor.putInt("keyYears", intNumberOfYears);
                    editor.putInt("keyLoanAmount", intCarLoanAmount);
                    editor.putFloat("keyInterestRate", (float) dblInterestRate);

                    //Commits to the database
                    editor.commit();
                //END:Save the numeric data into data storage (database)

                //START: Start the next activity
                    Toast.makeText(MainActivity.this, "Calculating...", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, PaymentActivity.class));
                //END: Start the next activity

            }
        });
    }
}
