package com.example.myekoapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WodaLicznik extends AppCompatActivity {
    private String myFormat = "dd/MM/yy";
    final Calendar myCalendar = Calendar.getInstance();
    private Button buttonStart;
    private EditText editTextDate;
    private Date startDate;
    private Calendar endDate = Calendar.getInstance();
    private TextView textViewCountdown;
    private TextView textView;
    private boolean flaga = true;


    private  MyCount counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_woda_licznik);

        textViewCountdown = (TextView) findViewById(R.id.textViewCountdown);
        textView = (TextView) findViewById(R.id.textView);

        editTextDate = (EditText) findViewById(R.id.editTextDate);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flaga == true) {
                    openStart();
                } else
                    openReset();

            }
        });

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        editTextDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(WodaLicznik.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
        editTextDate.setText(sdf.format(myCalendar.getTime()));
    }

   public void openStart() {
       SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());
       try {
           startDate = sdf.parse(editTextDate.getText().toString());
       } catch (ParseException e) {
           e.printStackTrace();
       }
       endDate.setTime(startDate);
       endDate.add(Calendar.MONTH, 1);
       //System.out.println(endDate.getTime());
       //Calendar newStartDate = Calendar.getInstance();
       //newStartDate.setTime(startDate);

       long diff = endDate.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();

       counter = new MyCount(diff, 86400000L);
       counter.start();

       buttonStart.setText("reset");
       textView.setText("Data włożenia filtra");
       flaga = false;
   }

   public void  openReset() {
        counter.cancel();
        buttonStart.setText("Zacznij odliczać");
        textView.setText("Podaj datę włożenia filtra:");
        textViewCountdown.setText("");
        editTextDate.setText("");
        flaga = true;
   }

    public class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            textViewCountdown.setText("Zakończono odliczanie!");
            flaga = true;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            textViewCountdown.setText("Pozostało:\n" + millisUntilFinished/86400000 + "\ndni");
        }
    }

}
