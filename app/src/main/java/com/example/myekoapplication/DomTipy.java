package com.example.myekoapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DomTipy extends AppCompatActivity {
    private Button buttonCzysto;
    private Button buttonZakupy;
    private Button button2Zycie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dom_tipy);

        buttonCzysto = (Button) findViewById(R.id.buttonCzysto);
        buttonCzysto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCzysto();
            }
        });

        buttonZakupy = (Button) findViewById(R.id.buttonZakupy);
        buttonZakupy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openZakupy();
            }
        });

        button2Zycie = (Button) findViewById(R.id.button2Zycie);
        button2Zycie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open2Zycie();
            }
        });

    }

    public void openCzysto() {
        Intent intent = new Intent(this, DomCzysto.class);
        startActivity(intent);
    }

    public void openZakupy() {
        Intent intent = new Intent(this, DomZakupy.class);
        startActivity(intent);
    }

    public void open2Zycie() {
        Intent intent = new Intent(this, Dom2Zycie.class);
        startActivity(intent);
    }

    @Override
    public void finish() {
        super.finish();
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
