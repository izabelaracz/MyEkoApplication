package com.example.myekoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

public class MainActivity extends AppCompatActivity {

    private ImageButton buttonSort;
    private ImageButton buttonWoda;
    private ImageButton buttonQuiz;
    private ImageButton buttonDom;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCenter.start(getApplication(), "9d7519b7-785c-4c08-a882-0ef67c2daa23",
                Analytics.class, Crashes.class);

        buttonSort = (ImageButton) findViewById(R.id.button_sortowanie);
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSortowanie();
            }
        });

        buttonWoda = (ImageButton) findViewById(R.id.button_woda);
        buttonWoda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWoda();
            }
        });

        buttonQuiz = (ImageButton) findViewById(R.id.button_quiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });

        buttonDom = (ImageButton) findViewById(R.id.button_dom);
        buttonDom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDom();
            }
        });
    }

    public void openSortowanie() {
        Intent intent = new Intent(this, Sortowanie.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void openWoda() {
        Intent intent = new Intent(this, Woda.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    public void openQuiz() {
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    public void openDom() {
        Intent intent = new Intent(this, Dom.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.pomoc, menu);
        return true;
    }
}