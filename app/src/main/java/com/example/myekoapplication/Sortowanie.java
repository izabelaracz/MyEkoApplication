package com.example.myekoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Sortowanie extends AppCompatActivity {

    private ImageButton plastik;
    private ImageButton papier;
    private ImageButton szklo;
    private ImageButton bio;
    private ImageButton mix;
    private ImageButton niewiadoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sortowanie);

        plastik = (ImageButton) findViewById(R.id.buttonPlastik);
        plastik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSortowaniePlastik();
            }
        });

        papier = (ImageButton) findViewById(R.id.buttonPapier);
        papier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSortowaniePapier();
            }
        });

        szklo = (ImageButton) findViewById(R.id.buttonSzklo);
        szklo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSortowanieSzklo();
            }
        });

        bio = (ImageButton) findViewById(R.id.buttonBio);
        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSortowanieBio();
            }
        });

        mix = (ImageButton) findViewById(R.id.buttonZmieszane);
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSortowanieZmieszane();
            }
        });

        niewiadoma = (ImageButton) findViewById(R.id.buttonniewiadoma);
        niewiadoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSortowanieNN();
            }
        });
    }

    void openSortowaniePlastik() {
        Intent intent = new Intent(this, SortowaniePlastik.class);
        startActivity(intent);
    }

    void openSortowaniePapier() {
        Intent intent = new Intent(this, SortowaniePapier.class);
        startActivity(intent);
    }

    void openSortowanieSzklo() {
        Intent intent = new Intent(this, SortowanieSzklo.class);
        startActivity(intent);
    }

    void openSortowanieBio() {
        Intent intent = new Intent(this, SortowanieBio.class);
        startActivity(intent);
    }
     void openSortowanieZmieszane() {
         Intent intent = new Intent(this, SortowanieMieszane.class);
         startActivity(intent);
     }

    void openSortowanieNN() {
        Intent intent = new Intent(this, SortowanieNN.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}