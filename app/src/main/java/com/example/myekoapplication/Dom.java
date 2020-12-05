package com.example.myekoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Dom extends AppCompatActivity {
    private TextView textViewDom;
    private Button buttonDalej;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom);

        textViewDom = (TextView) findViewById(R.id.textViewDom);
        textViewDom.setText("Można myśleć, że przecież nie zmienię świata, ja sam i tak nic nie zdziałam, za mało znaczę wobec ogromu środowiska i jego problemów. To duży błąd myśleć w ten sposób, ponieważ każda duża zmiana zaczyna się od małego kroku. Naszym małym \"całym światem\" jest nasz dom. To w nim się wszystko zaczyna i w nim kończy. Cokolwiek robimy w naszym domu, ma to wpływ na świat dookoła nas. A więc wprowadzając zmiany w naszym najbliższym otoczeniu, robimy właśnie ten mały krok, który prowadzi do wielkich zmian. Każda mała, domowa ekologiczna decyzja wpływa na nas, nasz dom, nasze środowisko. Czynimy świat, ten nasz domowy i ten wielki, lepszym miejscem. Zobacz jak wiele możesz zrobić wprowadzając w swoim domu bardzo proste zmiany.\nA więc do dzieła!");

        buttonDalej = (Button) findViewById(R.id.buttonNextTip);
        buttonDalej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDom();
            }
        });
    }

    private void openDom() {
        Intent intent = new Intent(this, DomTipy.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
