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

public class WeightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeightActivity.this, MainActivity.class);
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
        Intent intent = new Intent(WeightActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void PopulateSpinners() {
        //Create the adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weight_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Populate first spinner
        Spinner spinnerFrom = (Spinner) findViewById(R.id.spinner);
        spinnerFrom.setAdapter(adapter);

        //Populate second spinner
        Spinner spinnerTo = (Spinner) findViewById(R.id.spinner2);
        spinnerTo.setAdapter(adapter);
    }

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
                case "Milligram":
                    switch (unitTo) {
                        case "Gram":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kilogram":
                            valueTo = valueFrom / 1000 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ton":
                            valueTo = valueFrom / 1000 / 1000 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Pound":
                            valueTo = valueFrom / 453592;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Stone":
                            valueTo = valueFrom / 453592 / 14;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ounce":
                            valueTo = valueFrom / 28350;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Gram":
                    switch (unitTo) {
                        case "Milligram":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kilogram":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ton":
                            valueTo = valueFrom / 1000 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Pound":
                            valueTo = valueFrom / 454;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Stone":
                            valueTo = valueFrom / 454 / 14;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ounce":
                            valueTo = valueFrom / 28.35;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Kilogram":
                    switch (unitTo) {
                        case "Milligram":
                            valueTo = valueFrom * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Gram":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ton":
                            valueTo = valueFrom / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Pound":
                            valueTo = valueFrom * 2.205;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Stone":
                            valueTo = valueFrom / 6.35;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ounce":
                            valueTo = valueFrom * 35.274;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Ton":
                    switch (unitTo) {
                        case "Milligram":
                            valueTo = valueFrom * 1000 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Gram":
                            valueTo = valueFrom * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kilogram":
                            valueTo = valueFrom * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Pound":
                            valueTo = valueFrom * 1000 * 2.205;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Stone":
                            valueTo = valueFrom * 1000 / 6.35;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ounce":
                            valueTo = valueFrom * 1000 * 35.274;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Pound":
                    switch (unitTo){
                        case "Milligram":
                            valueTo = valueFrom * 2.205 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Gram":
                            valueTo = valueFrom * 2.205 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kilogram":
                            valueTo = valueFrom * 2.205;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ton":
                            valueTo = valueFrom * 2.205 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Stone":
                            valueTo = valueFrom * 2.205 / 6.35;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ounce":
                            valueTo = valueFrom * 2.205 * 35.274;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Stone":
                    switch (unitTo){
                        case "Milligram":
                            valueTo = valueFrom * 6.35 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Gram":
                            valueTo = valueFrom * 6.35 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kilogram":
                            valueTo = valueFrom * 6.35;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ton":
                            valueTo = valueFrom * 6.35 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Pound":
                            valueTo = valueFrom * 6.35 * 2.205;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ounce":
                            valueTo = valueFrom * 6.35 * 35.274;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        default:
                            valueTo = valueFrom;
                            etTo.setText(Double.toString(valueTo));
                            break;
                    }
                    break;
                case "Ounce":
                    switch (unitTo){
                        case "Milligram":
                            valueTo = valueFrom / 35.274 * 1000 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Gram":
                            valueTo = valueFrom / 35.274 * 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Kilogram":
                            valueTo = valueFrom / 35.274;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Ton":
                            valueTo = valueFrom / 35.274 / 1000;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Pound":
                            valueTo = valueFrom / 35.274 * 2.205;
                            etTo.setText(Double.toString(valueTo));
                            break;
                        case "Stone":
                            valueTo = valueFrom / 35.274 * 35.274;
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
