package com.example.myekoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Quiz extends AppCompatActivity {
    private Button buttonDalej;
    private TextView textViewInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        textViewInfo = (TextView) findViewById((R.id.textViewMsg));
        textViewInfo.setText("Sprawdź się i zobacz jak dużo wiesz o byciu eko! Quiz nie jest trudny, od razu zobaczysz czy Twoja odpowiedź jest prawidłowa. Dostaniesz także wytłumaczenie odpowiedzi. Nasz quiz to przede wszystkim zabawa, ale masz również możliwość zdobycia nowej wiedzy.\nPowodzenia!");

        buttonDalej = (Button) findViewById(R.id.buttonNext);
        buttonDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });
    }

    private void openQuiz() {
        Intent intent = new Intent(this, QuizWorking.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

}
