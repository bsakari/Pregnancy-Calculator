package com.fareplanpassenger.myandroidphpapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    Calendar myCalendar;
    TextView mCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCalendar = Calendar.getInstance();

        edittext= (EditText) findViewById(R.id.CycleDate);
        mCalculate = findViewById(R.id.tv_calculate);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if (edittext.getText().toString().trim().isEmpty()){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                    builder1.setTitle("EMPTY FIELD!!!");
                    builder1.setMessage("Sorry!!!. Please select pregnancy time frame.");
                    builder1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).create().show();
                }else {
                    Long nineMonths = Long.parseLong("23668200000");
                    String myDate = edittext.getText().toString();
                    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
                    Date date = new Date();
                    String today = dateFormat.format(date.getTime())+"";
                    SimpleDateFormat sdf,sdf2;
                    sdf= new SimpleDateFormat("MM/dd/yy");
                    Date date1,date2 = null;
                    try {
                        date1 = sdf.parse(myDate);
                        assert date1 != null;
                        long millis = date1.getTime();

                        date2 = sdf.parse(today);
                        assert date2 != null;
                        long millis2 = date2.getTime();
                        Long difference = Long.parseLong(String.valueOf(millis2)) - Long.parseLong(String.valueOf(millis));

                        if (difference > nineMonths){
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("OVERDUE PREGNANCY!!!");
                            builder.setMessage("Sorry!!!. The selected period is more than 9 months. You must have delivered by now. Please select a different time frame.");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create().show();
                        }else if (difference > (nineMonths * 2)){
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("OUT OF RANGE TIME FRAME!!!");
                            builder.setMessage("Sorry!!!. The selected period is of the expected time frame. Please enter a more recent date.");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).create().show();
                        }else {
                            startActivity(new Intent(getApplicationContext(),OnboardingActivity.class));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        edittext.setText(sdf.format(myCalendar.getTime()));
    }

}
