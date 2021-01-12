package com.example.dataconverting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView buttonTempText;
    private RelativeLayout buttonTempLayout;

    private TextView buttonWeightText;
    private RelativeLayout buttonWeightLayout;

    private TextView buttonLengthText;
    private RelativeLayout buttonLengthLayout;




    /* When opened, this runs first! */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /* The following are buttons that if the text is clicked, the corresponding conversion page opens */

        /* Button, that if pressed, will open the temperature converting page */
        buttonTempText = findViewById(R.id.TempButtonTextBox);
        buttonTempText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openTempPage();
            }
        });

        /* Button, that if pressed, will open the weight converting page */
        buttonWeightText = findViewById(R.id.WeightButtonTextBox);
        buttonWeightText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openWeightPage();
            }
        });

        /* Button, that if pressed, will open the length converting page */
        buttonLengthText = findViewById(R.id.LengthButtonTextBox);
        buttonLengthText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLengthPage();
            }
        });




        /* The following are buttons for the entire layout, meaning the background color and top left icons and NOT text,
        if clicked will open the corresponding conversion page. */

        /* Button, that if pressed, will open the length converting page */
        buttonLengthLayout = findViewById(R.id.LengthButtonLayout);
        buttonLengthLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openLengthPage();
            }
        });

        /* Button, that if pressed, will open the length converting page */
        buttonWeightLayout = findViewById(R.id.WeightButtonLayout);
        buttonWeightLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openWeightPage();
            }
        });

        /* Button, that if pressed, will open the length converting page */
        buttonTempLayout = findViewById(R.id.TempButtonLayout);
        buttonTempLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openTempPage();
            }
        });

    }







    /* Starts a new activity page and displays it. (Temperature) */
    public void openTempPage() {
        Intent intent = new Intent(this, temperatureConvertor.class);
        startActivity(intent);

    }



    /* Starts a new activity page and displays it. (length) */
    public void openLengthPage() {
        Intent intent = new Intent(this, lengthConvertor.class);
        startActivity(intent);

    }



    /* Starts a new activity page and displays it. (Weight) */
    public void openWeightPage() {
        Intent intent = new Intent(this, weightConvertor.class);
        startActivity(intent);

    }


}