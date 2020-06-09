package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AreaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AreaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        PopulateSpinners();

        // Capture our button from layout
        Button button = (Button)findViewById(R.id.button);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(convertListener);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AreaActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void PopulateSpinners() {
        //Create the adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.area_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Populate first spinner
        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinner);
        spinnerFrom.setAdapter(adapter);

        //Populate second spinner
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinner2);
        spinnerTo.setAdapter(adapter);
    }

    // Create an anonymous implementation of OnClickListener
    private View.OnClickListener convertListener = new View.OnClickListener() {
        public void onClick(View v) {
            //Get the value you wish to coDouble
            EditText etFrom = (EditText) findViewById(R.id.editText);
            double valueFrom = Double.parseDouble(etFrom.getText().toString());
            //Get the first unit
            Spinner spinnerFrom = (Spinner) findViewById(R.id.spinner);
            String unitFrom = spinnerFrom.getSelectedItem().toString();
            //Get the second unit
            Spinner spinnerTo = (Spinner) findViewById(R.id.spinner2);
            String unitTo = spinnerTo.getSelectedItem().toString();
            //ValueTo
            EditText etTo = (EditText) findViewById(R.id.editText2);
            double valueTo;

            switch (unitFrom) {
                case "Square Centimeter":
                    switch (unitTo) {
                        case "Square Meter":
                            valueTo = valueFrom / 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom / 10000 / 1000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom / 6.4516;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom / 929.0304;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom / 8361.2736;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = valueFrom / 40468560;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = valueFrom / 100000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = valueFrom / 10000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Square Meter":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom / 1000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom * 1550.0031;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom * 10.7639104;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom * 1.19599005;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = valueFrom / 4046.856;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = valueFrom / 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Square Kilometer":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 1000000 * 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Meter":
                            valueTo = valueFrom * 1000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom * 1000000 * 1550.0031;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom * 1000000 * 10.7639104;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom * 1000000 * 1.19599005;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = (valueFrom * 1000000) / 4046.856;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = (valueFrom * 1000000) / 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = (valueFrom * 1000000) / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Square Inch":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 6.4516;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Meter":
                            valueTo = valueFrom * 6.4516 / 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom * 6.4516 / 10000 / 1000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom / 144;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom / 1296;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = valueFrom / 144 / 43560;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = valueFrom / 144 / 107639;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = valueFrom / 1550003.1;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Square Feet":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 929;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Meter":
                            valueTo = valueFrom / 10.764;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom / 10.764 / 1000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom * 144;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom / 9;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = valueFrom / 43560;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = valueFrom / 107639;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = valueFrom / 10763.91;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Square Yard":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 8361;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Meter":
                            valueTo = valueFrom / 1.196;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom / 1.196 / 1000000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom * 1296;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom * 9;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = valueFrom / 4840;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = valueFrom / 11960;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = valueFrom / 1195.99;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Acre":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 4047 * 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Meter":
                            valueTo = valueFrom * 4047;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom / 247;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom * 43560 * 144;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom * 43560;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom * 4840;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = valueFrom / 2.471;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = valueFrom * 4.05;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Hectare":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 10000 * 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Meter":
                            valueTo = valueFrom * 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom / 100;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom * 107639 * 144;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom * 107639;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom * 11960;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = valueFrom * 2.471;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decare":
                            valueTo = valueFrom * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Decare":
                    switch (unitTo) {
                        case "Square Centimeter":
                            valueTo = valueFrom * 1000 * 10000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Meter":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Kilometer":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Inch":
                            valueTo = valueFrom * 10763.9 * 144;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Feet":
                            valueTo = valueFrom * 10763.9;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Square Yard":
                            valueTo = valueFrom * 1196;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Acre":
                            valueTo = valueFrom / 4;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Hectare":
                            valueTo = valueFrom / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                default:
            }
        }
    };
}