package edu.txstate.crs181.tipcalculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double excellentTip = 1.3;
    double averageTip = 1.2;
    double poorTip = 1.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText billAmount = findViewById(R.id.txtBillAmount);
        final RadioButton dineIn = findViewById(R.id.radDineIn);
        final RadioButton toGo = findViewById(R.id.radToGo);
        final Spinner service = findViewById(R.id.spnService);
        final Button calculate = findViewById(R.id.btnCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strBillAmount = billAmount.getText().toString();
                double dblBillAmount = Double.parseDouble(strBillAmount);
                double dblTotalTip;
                String strService = service.getSelectedItem().toString();

                if (strService.equalsIgnoreCase("Excellent")) {
                    dblTotalTip = dblBillAmount * excellentTip;
                } else if (strService.equalsIgnoreCase("Average")) {
                    dblTotalTip = dblBillAmount * averageTip;
                } else {
                    dblTotalTip = dblBillAmount * poorTip;
                }

                if (toGo.isChecked()) {
                    dblTotalTip = 0.0;
                } else {
                    dblTotalTip = dblTotalTip;
                }
                DecimalFormat formatter = new DecimalFormat("$###,###.##");
                Toast.makeText(MainActivity.this, "Quality of Service: " + strService + ", Tip Amount: " +
                        (formatter.format(dblTotalTip)), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
