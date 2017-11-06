package com.example.dawn.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;
import static android.widget.Spinner.*;

public class MainActivity extends AppCompatActivity {
    double costOfMeal;
    double percent;
    double totalTip;
    int indexSpinner;
    String txtPercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Read user input
        final EditText cost = (EditText)findViewById(R.id.numMealCost);
        final Spinner group = (Spinner)findViewById(R.id.txtTipGrp);

        Button tip = (Button)findViewById(R.id.btnPercent);


        tip.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.txtResults));

            @Override
            public void onClick(View view) {
                //Retrieve Spinner text to display in results
                txtPercent = group.getSelectedItem().toString();

                //Retrieve the spinner index to determine percent to use in calculation
                indexSpinner = group.getSelectedItemPosition();

                switch (indexSpinner) {
                    case 0:
                        percent = .05;
                        break;
                    case 1:
                        percent = .1;
                        break;
                    case 2:
                        percent = .15;
                        break;
                    case 3:
                        percent = .20;
                        break;
                    case 4:
                        percent = .25;
                        break;
                }

                costOfMeal = Double.parseDouble(cost.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                //Calculate tip amount
                totalTip = costOfMeal * percent;
                //Display results
                result.setText("A " + txtPercent + " tip is " + currency.format(totalTip));
            }
        });
    }
}
