package com.example.phonephotoprintsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double fourBySixRate = .19;
    double fiveBySevenRate = .49;
    double eightByTenRate = .49;
    int numberEntered;
    double totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText numberOrdered = (EditText)findViewById(R.id.txtNumberOrdered);
        final RadioButton fourBySix = (RadioButton)findViewById(R.id.rad4x6);
        final RadioButton fiveBySeven = (RadioButton)findViewById(R.id.rad5x7);
        final RadioButton eightByTen = (RadioButton)findViewById(R.id.rad8x10);
        final TextView result = (TextView)findViewById(R.id.txtResults);
        Button order = (Button)findViewById(R.id.btnOrder);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberEntered = Integer.parseInt(numberOrdered.getText().toString());
                DecimalFormat currency = new DecimalFormat("$#,###.##");

                if(numberEntered <= 50){
                    if(fourBySix.isChecked()){
                        totalPrice = numberEntered * fourBySixRate;
                    }
                    if(fiveBySeven.isChecked()){
                        totalPrice = numberEntered * fiveBySevenRate;
                    }
                    if(eightByTen.isChecked()){
                        totalPrice = numberEntered * eightByTenRate;
                    }
                    result.setText("The order cost is " + currency.format(totalPrice));
                }
                else {
                    Toast.makeText(MainActivity.this, "Number ordered must be 50 or less", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
