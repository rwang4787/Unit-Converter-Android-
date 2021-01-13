package com.example.dataconverting;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TemperatureActivity extends AppCompatActivity {

    ActionBar actionBar;
    EditText inputBox;
    Button convertButton, clearButton;
    Spinner fromUnit, toUnit;
    String to = "", from = "";
    TextView backButton, output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_convertor);

        // Adding back button
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Data Converter");

        // Inputbox
        inputBox = findViewById(R.id.editTextNumber);

        // Outputbox
        output = findViewById((R.id.output));

        // spinner for from unit
        fromUnit = findViewById(R.id.fromSpinner);
        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this, R.array.temperatureUnits, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromUnit.setAdapter(fromAdapter);

        // spinner for to unit
        toUnit = findViewById(R.id.toSpinner);
        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this, R.array.temperatureUnits, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toUnit.setAdapter(toAdapter);

        // convert button + listener
        convertButton = findViewById(R.id.convert);
        convertButton.setOnClickListener((View.OnClickListener) v -> {
            double input = Integer.parseInt(inputBox.getText().toString());
            to = toUnit.getSelectedItem().toString();
            from = fromUnit.getSelectedItem().toString();

            input = cToSelection(convertToC(input, from), to);

            output.setText(String.valueOf(input) + " " + to);
        });

        //Adds a listener for when "Clear" is clicked. This will remove any user input.
        clearButton = findViewById(R.id.clear_input);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearText();
            }
        });
    }

    // converts celsius to anyone of the other units of measurement
    double cToSelection(double value, String unit) {
        switch (unit) {
            case "K":
                return value + 273.15;
            case "F":
                return (value * 9.0/5.0) + 32;
            default:
                return value;
        }
    }

    // converts the temperature to celsius if it isn't already
    double convertToC(double value, String unit) {
        switch (unit) {
            case "K":
                return value - 273.15;
            case "F":
                return (value - 32)* (5.0/9.0);
            default:
                return value;
        }
    }

    // Back button to go back to main page
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }

    /* Sets the user input to empty string */
    public void clearText() {
        inputBox.setText("");
        output.setText("");
    }

}