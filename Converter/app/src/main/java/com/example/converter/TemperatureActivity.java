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

public class TemperatureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TemperatureActivity.this, MainActivity.class);
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
        Intent intent = new Intent(TemperatureActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void PopulateSpinners() {
        //Create the adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_array, android.R.layout.simple_spinner_item);
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
                case "Celsius":
                    switch (unitTo) {
                        case "Fahrenheit":
                            valueTo = valueFrom * 9 / 5 + 32;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kelvin":
                            valueTo = valueFrom - 273.15;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Fahrenheit":
                    switch (unitTo) {
                        case "Celsius":
                            valueTo = (valueFrom - 32) * 5 / 9;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kelvin":
                            valueTo = (valueFrom - 32) * 5 / 9 + 273.15;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Kelvin":
                    switch (unitTo) {
                        case "Celsius":
                            valueTo = valueFrom - 273.15;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Fahrenheit":
                            valueTo = (valueFrom - 273.15) * 9 / 5 + 32;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
            }
        }
    };
}
