package com.example.myekoapplication;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WodaLicznik extends AppCompatActivity {
    //private static final long START_TIME_IN_MILLIS = 2592000000L;
    private String myFormat = "dd/MM/yy";
    final Calendar myCalendar = Calendar.getInstance();
    private Button buttonStart;
    private EditText editTextDate;
    private Date startDate;
    private Calendar endDate = Calendar.getInstance();
    private TextView textViewCountdown;
    private TextView textView;
    private boolean timeRunning = false;

    private long diff;
    private long endTime;
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
                if(timeRunning) {
                    openReset();
                } else
                    if(editTextDate.getText().toString().matches("")){
                        Toast.makeText(WodaLicznik.this, "Wybierz datę", Toast.LENGTH_SHORT).show();
                    } else
                        openStart();

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

       diff = endDate.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
       endTime = System.currentTimeMillis() + diff;

       counter = new MyCount(diff, 86400000L);
       counter.start();

       /*buttonStart.setText("reset");
       textView.setText("Data włożenia filtra");*/
       timeRunning = true;
       updateButtons();
   }

   public void  openReset() {
        counter.cancel();
        /*buttonStart.setText("Zacznij odliczać");
        textView.setText("Podaj datę włożenia filtra:");
        textViewCountdown.setText("");
        editTextDate.setText("");*/
       timeRunning = false;
       updateButtons();
   }

   private void updateButtons() {
        if(timeRunning) {
            buttonStart.setText("reset");
            textView.setText("Data włożenia filtra");
            editTextDate.setText(new SimpleDateFormat("dd/MM/yy").format(startDate));
        } else {
            buttonStart.setText("Zacznij odliczać");
            textView.setText("Podaj datę włożenia filtra:");
            textViewCountdown.setText("");
            editTextDate.setText("");
        }
   }

   public void updateCountDownText() {
        if(diff == 999) {
            textViewCountdown.setText("");
        } else
            textViewCountdown.setText("Pozostało:\n" + diff/86400000 + "\ndni");
   }

    public class MyCount extends CountDownTimer {
        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            textViewCountdown.setText("Zakończono odliczanie!");
            timeRunning = false;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            diff = millisUntilFinished;
            //textViewCountdown.setText("Pozostało:\n" + millisUntilFinished/86400000 + "\ndni");
            updateCountDownText();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("millisLeft", diff);
        editor.putBoolean("timerRunning", timeRunning);
        editor.putLong("endTime", endTime);
        editor.putString("startDate", new SimpleDateFormat("dd/MM/yy").format(startDate));
        editor.apply();
        if (counter != null) {
            counter.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        String startDateString = prefs.getString("startDate", new SimpleDateFormat("dd/MM/yy").format(new Date()));
        try {
            startDate = new SimpleDateFormat("dd/MM/yy").parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        diff = prefs.getLong("millisLeft", 999);
        timeRunning = prefs.getBoolean("timerRunning", false);
        updateCountDownText();
        updateButtons();
        if (timeRunning) {
            endTime = prefs.getLong("endTime", 0);
            diff = endTime - System.currentTimeMillis();
            if (diff < 0) {
                diff = 0;
                timeRunning = false;
                updateCountDownText();
                updateButtons();
            } else {
                openStart();
            }
        }
    }

}
