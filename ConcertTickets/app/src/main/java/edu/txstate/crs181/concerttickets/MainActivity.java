package edu.txstate.crs181.concerttickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double costPerTicket = 79.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numberOfTickets = findViewById(R.id.txtNumberOfTickets);
        final TextView results = findViewById(R.id.txtResults);
        final Spinner concertType = findViewById(R.id.spnConcerts);

        Button findCost = findViewById(R.id.btnFindCost);
        findCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Start
                //Getting the text value of the strNumberOfTickets variable
                String strNumberOfTickets = numberOfTickets.getText().toString();
                //Converting text type to an integer data type
                int intNumberOfTickets = Integer.parseInt(strNumberOfTickets);
                //Calculating the Total Cost
                double dblTotalCost = 0;
                //Declaring strConcertType as a String variable
                String strConcertType = concertType.getSelectedItem().toString();

                //Some concerts may have an additional cost
                if (strConcertType.equalsIgnoreCase("Kendrick Lamar")) {
                    dblTotalCost = intNumberOfTickets * (costPerTicket + 20.00);
                } else if (strConcertType.equalsIgnoreCase("Zac Brown Band")) {
                    dblTotalCost = intNumberOfTickets * (costPerTicket + 10.00);
                } else {
                    dblTotalCost = costPerTicket;
                }

                //Defining the format we want to use for the output of the calculation
                DecimalFormat format = new DecimalFormat("$#,###,###.##"); //$1,234,567.89
                //Applies format to dblTotalCost
                String strTotalCost = format.format(dblTotalCost);
                //Displaying the result of the calculation and displaying the name of the item selected in the spinner
                results.setText(strTotalCost + " for the " + concertType.getSelectedItem().toString() + " Concert");
                //End
            }
        });
    }
}
