package com.example.mccwireless;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    boolean applyDiscount = false;
    double discountPercentage = 0.10;
    double price1 = 29.99,
        price2 = 39.99,
        price3 = 19.99;

    DecimalFormat df = new DecimalFormat("#.##");

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

        Button btnPurchase = findViewById(R.id.btnPurchase);
        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!rbOffer1.isChecked() && !rbOffer2.isChecked() && !rbOffer3.isChecked()){
                    Toast.makeText(MainActivity.this, "You must select at least one offer",Toast.LENGTH_LONG).show();
                }
                else {
                    startActivity(new Intent(MainActivity.this, CongratesMessage.class));
                }
            }
        });
    }

    void CalculateCosts(RadioButton rb1, RadioButton rb2, RadioButton rb3){
        double totalCost = 0;
        String totalCostString;
        TextView txtResult = findViewById(R.id.txtResult);
        if(rb1.isChecked()){
            totalCost += price1;
            applyDiscount = ApplyDiscount(rb2, rb3);
        }
        if(rb2.isChecked()){
            totalCost += price2;
            applyDiscount = ApplyDiscount(rb1, rb3);
        }
        if(rb3.isChecked()){
            totalCost += price3;
            applyDiscount = ApplyDiscount(rb2, rb1);
        }
        if(applyDiscount){
            totalCost = totalCost - (totalCost * discountPercentage);
        }
        txtResult.setText("$" + df.format(totalCost) + "/mon");
    }

    boolean ApplyDiscount(RadioButton rb1, RadioButton rb2){
        if(rb1.isChecked() || rb2.isChecked()){
            return true;
        }
        return false;
    }
}
