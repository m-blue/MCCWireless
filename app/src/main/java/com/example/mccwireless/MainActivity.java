package com.example.mccwireless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton rbOffer1 = findViewById(R.id.rbOffer1),
                rbOffer2 = findViewById(R.id.rbOffer2),
                rbOffer3 = findViewById(R.id.rbOffer3);

        //TextView heysome = findViewById(R.id.txtResult);

        RadioGroup rg1 = findViewById(R.id.rg1),
                rg2 = findViewById(R.id.rg2),
                rg3 = findViewById(R.id.rg3);

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rbOffer1.isChecked()){
                    //DoSomething();
                    CalculateCosts(rbOffer1);
                }
                else{
                    //DoSomethingElse();
                    ApplyOffer(rbOffer1);
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rbOffer2.isChecked()){
                    //DoSomething();
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(rbOffer3.isChecked()){
                    //DoSomething();
                }
            }
        });




    }
    void CalculateCosts(RadioButton rb){
        TextView heysome = findViewById(R.id.txtResult);
        heysome.setText("Hello World");
        Toast.makeText(MainActivity.this, rb.getText().toString() + " was selected",Toast.LENGTH_LONG).show();
    }

    double ApplyOffer(RadioButton rb){
        Toast.makeText(MainActivity.this, rb.getText().toString() + " was DEselected",Toast.LENGTH_LONG).show();
        return 0;
    }
}
