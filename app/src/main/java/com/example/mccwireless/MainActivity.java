package com.example.mccwireless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    boolean applyDiscount = false;
    double price1 = 29.99,
        price2 = 39.99,
        price3 = 19.99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton rbOffer1 = findViewById(R.id.rbOffer1),
                rbOffer2 = findViewById(R.id.rbOffer2),
                rbOffer3 = findViewById(R.id.rbOffer3);


        RadioGroup rg1 = findViewById(R.id.rg1),
                rg2 = findViewById(R.id.rg2),
                rg3 = findViewById(R.id.rg3);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                CalculateCosts(rbOffer1, rbOffer2, rbOffer3);
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                CalculateCosts(rbOffer1, rbOffer2, rbOffer3);
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                CalculateCosts(rbOffer1, rbOffer2, rbOffer3);
            }
        });




    }
    void CalculateCosts(RadioButton rb1, RadioButton rb2, RadioButton rb3){
        double totalCost = 0;
        String totalCostString;
        TextView txtResult = findViewById(R.id.txtResult);
        if(rb1.isChecked()){
            //Add the cost of rb to total
            totalCost += price1;
            //check if the discount applies
            // print total
        }
        if(rb2.isChecked()){
            totalCost += price2;
        }
        if(rb3.isChecked()){
            totalCost += price3;
        }
        totalCostString = Double.toString(totalCost);
        txtResult.setText(totalCostString);
    }

    double ApplyOffer(RadioButton rb){
        Toast.makeText(MainActivity.this, rb.getText().toString() + " was DEselected",Toast.LENGTH_LONG).show();
        return 0;
    }
}
