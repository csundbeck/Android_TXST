package edu.txstate.crs181.electriccar;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView paymentAmount = findViewById(R.id.txtPaymentAmount);
        //get data from database
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(PaymentActivity.this);
        //Keys must be the same as they are in the put methods on MainActivity
        //the value is set to a default of zero (if arbitrary input)
        int intYear = pref.getInt(MainActivity.KEY_NUMBER_OF_YEARS, 0);
        int intLoan = pref.getInt(MainActivity.KEY_LOAN_AMOUNT, 0);
        float fltInterest = pref.getFloat(MainActivity.KEY_INTEREST_RATE, 0);

        //Calculate the Monthly Payment
        double dblMonthlyPayment;
        dblMonthlyPayment = (intLoan * (1 + (intYear * fltInterest))) / (12 * intYear);

        //Format the output
        DecimalFormat formatter = new DecimalFormat("$###,###.##");
        String strMonthlyPayment = formatter.format(dblMonthlyPayment);
        paymentAmount.setText(strMonthlyPayment);

    }
}
