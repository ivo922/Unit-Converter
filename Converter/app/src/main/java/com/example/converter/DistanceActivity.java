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

public class DistanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DistanceActivity.this, MainActivity.class);
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
        Intent intent = new Intent(DistanceActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void PopulateSpinners() {
        //Create the adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.distance_array, android.R.layout.simple_spinner_item);
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
                case "Kilometer":
                    switch (unitTo) {
                        case "Meter":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom * 1000 * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom * 1000 * 100;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom * 1000 * 100 * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom * 1000 * 100 * 10 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 1000 * 100 * 10 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 1000 * 100 * 10 * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom * 1000 * 100 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom * 1000 * 100 * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Meter":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom * 100;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom * 100 * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom * 100 * 10 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 100 * 10 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 100 * 10 * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom * 100 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom * 100 * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Decimeter":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom * 10 * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom * 10 * 10 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 10 * 10 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 10 * 10 * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom * 10 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom * 10 * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Centimeter":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom / 10 / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom * 10 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 10 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 10 * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Millimeter":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom / 10 / 10 / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom / 10 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom / 10 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom / 10 * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Micrometer":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom / 1000 / 10 / 10 / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom / 1000 / 10 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom / 1000 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom / 1000 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom / 1000 / 10 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom / 1000 / 10 * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Nanometer":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom / 1000 / 1000 / 10 / 10 / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom / 1000 / 1000 / 10 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom / 1000 / 1000 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom / 1000 / 1000 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom / 1000 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom / 1000 / 1000 / 10 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom / 1000 / 1000 / 10 * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Picometer":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom / 1000 / 1000 / 1000 / 10 / 10 / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom / 1000 / 1000 / 1000 / 10 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom / 1000 / 1000 / 1000 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom / 1000 / 1000 / 1000 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom / 1000 / 1000 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom / 1000 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom / 1000 / 1000 / 1000 / 10 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom / 1000 / 1000 / 1000 / 10 * 2.54 * 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Inch":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom * 2.54 / 10 / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom * 2.54 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom * 2.54 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom * 2.54 * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom * 2.54 * 10 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 2.54 * 10 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 2.54 * 10 * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Feet":
                            valueTo = valueFrom / 12;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Feet":
                    switch (unitTo) {
                        case "Kilometer":
                            valueTo = valueFrom *12 * 2.54 / 10 / 10 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Meter":
                            valueTo = valueFrom *12  * 2.54 / 10 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Decimeter":
                            valueTo = valueFrom * 12 * 2.54 / 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Millimeter":
                            valueTo = valueFrom * 12 * 2.54 * 10;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Micrometer":
                            valueTo = valueFrom * 12 * 2.54 * 10 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Nanometer":
                            valueTo = valueFrom * 12 * 2.54 * 10 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Picometer":
                            valueTo = valueFrom * 12 * 2.54 * 10 * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Centimeter":
                            valueTo = valueFrom * 12 * 2.54;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Inch":
                            valueTo = valueFrom * 12;
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
