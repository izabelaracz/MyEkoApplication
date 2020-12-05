package com.example.myekoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Woda extends AppCompatActivity {
    private Button buttonCiekawostka;
    private Button buttonLicznik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woda);

        buttonCiekawostka = (Button) findViewById(R.id.buttonCiekawostka);
        buttonCiekawostka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        buttonLicznik = (Button) findViewById(R.id.buttonLicznik);
        buttonLicznik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLicznik();
            }
        });
    }

    public void openLicznik() {
        Intent intent = new Intent(this, WodaLicznik.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}