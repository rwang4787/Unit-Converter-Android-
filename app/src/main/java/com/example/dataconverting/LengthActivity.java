package com.example.dataconverting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class lengthConvertor extends AppCompatActivity {

    EditText inputBox;
    Button convertButton;
    EditText clearButton;
    Spinner fromUnit, toUnit;
    String to = "", from = "";
    TextView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length_convertor);

        backButton = findViewById(R.id.HomeScreen);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });

        // Inputbox
        inputBox = findViewById(R.id.editTextNumber);

        // spinner for from unit
        fromUnit = findViewById(R.id.fromSpinner);
        ArrayAdapter<CharSequence> fromAdapter = ArrayAdapter.createFromResource(this, R.array.lengthUnits, android.R.layout.simple_spinner_item);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromUnit.setAdapter(fromAdapter);
        //fromUnit.setOnItemSelectedListener(new fromSpinnerClass());

        // spinner for goal unit
        toUnit = findViewById(R.id.toSpinner);
        ArrayAdapter<CharSequence> toAdapter = ArrayAdapter.createFromResource(this, R.array.lengthUnits, android.R.layout.simple_spinner_item);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toUnit.setAdapter(toAdapter);
        //toUnit.setOnItemSelectedListener(new toSpinnerClass());

        // adding listener to the convert button to display the converted value
        convertButton = findViewById(R.id.convert);
        convertButton.setOnClickListener((View.OnClickListener) v -> {
            double input = Integer.parseInt(inputBox.getText().toString());
            to = toUnit.getSelectedItem().toString();
            from = fromUnit.getSelectedItem().toString();
            input = convertBases(from, to, input);
            TextView output = (TextView) findViewById((R.id.output));
            output.setText(String.valueOf(input) + " " + to);
        });


        //Adds a listener for when "Clear" is clicked. This will remove any user input.
        clearButton = (EditText) findViewById(R.id.editTextNumber);
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearText(v);
            }
        });



    }

    /* Sets the user input to empty string */
    public void clearText(View v) {
        if (v == clearButton) {
            clearButton.setText("Click Me!");
        }

    }

    // Converts from different metric bases
    public double convertBases(String from, String to, double value) {
        return value * Math.pow(10, temp(from) - temp(to));
    }

    // Returns each metric abbreviations powers of 10
    public int temp(String unit) {
        switch (unit) {
            case "km":
                return 3;
            case "hm":
                return 2;
            case "dam":
                return 1;
            case "m":
                return 0;
            case "dm":
                return -1;
            case "cm":
                return -2;
            case "mm":
                return -3;
        }
        return 0;
    }

    /* Starts a new activity page and displays it. (Main Screen) */
    public void openHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}




