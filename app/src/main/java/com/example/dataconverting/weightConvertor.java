package com.example.dataconverting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class weightConvertor extends AppCompatActivity {
    TextView backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_convertor);

        backButton = findViewById(R.id.HomeScreen);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openHomePage();
            }
        });
    }

    /* Starts a new activity page and displays it. (Main Screen) */
    public void openHomePage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}