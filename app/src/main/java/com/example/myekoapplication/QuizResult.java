package com.example.myekoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuizResult extends AppCompatActivity {
    private TextView textViewScore;
    private TextView textViewInfo;
    private int score;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        textViewInfo = (TextView) findViewById(R.id.textViewTextResult);
        textViewScore = (TextView) findViewById(R.id.textViewResult);

        Intent intent = getIntent();
        score = intent.getIntExtra(QuizWorking.EXTRA_SCORE, 0);

        textViewScore = (TextView) findViewById(R.id.textViewResult);
        textViewInfo = (TextView) findViewById(R.id.textViewTextResult);

        textViewScore.setText("Twój wynik to: " + score);

        if(score > 5) {
            textViewInfo.setText("Super");
        } else {
            textViewScore.setText("Słabo");
        }
    }

}
