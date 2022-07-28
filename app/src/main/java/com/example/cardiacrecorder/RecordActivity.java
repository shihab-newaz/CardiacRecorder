package com.example.cardiacrecorder;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Objects;

public class RecordActivity extends AppCompatActivity {

    EditText date;
    EditText time;
    EditText systolic;
    EditText diastolic;
    EditText heartRate;
    EditText comment;
    Button save;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_record);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        systolic = findViewById(R.id.systolicPressure);
        diastolic = findViewById(R.id.diastolicPressure);
        heartRate = findViewById(R.id.heartRate);
        comment = findViewById(R.id.comment);
        save = findViewById(R.id.saveButton);

        date.setOnClickListener(v -> {
            DatePicker datePicker = new DatePicker(RecordActivity.this);
            int currentDate = datePicker.getDayOfMonth();
            int currentMonth = datePicker.getMonth();
            int currentYear = datePicker.getYear();
            DatePickerDialog datePickerDialog = new DatePickerDialog(RecordActivity.this,
                    (view, year, month, dayOfMonth) -> date.setText(dayOfMonth + "/" + (month + 1) + "/" + year), currentYear, currentMonth, currentDate);
            datePickerDialog.show();
        });

        time.setOnClickListener(v -> {
            Calendar currentTime = Calendar.getInstance();
            int hour = currentTime.get(Calendar.HOUR_OF_DAY);
            int minute = currentTime.get(Calendar.MINUTE);
            TimePickerDialog mTimePicker;
            mTimePicker = new TimePickerDialog(RecordActivity.this, (timePicker, selectedHour, selectedMinute) -> time.setText(selectedHour + ":" + selectedMinute), hour, minute, true);//Yes 24 hour time
            mTimePicker.show();

        });

//        String sys = systolic.getText().toString();
//        String dias = diastolic.getText().toString();
//        String hr = heartRate.getText().toString();

        String check = getIntent().getStringExtra("check");

        if (check.equals("1")) {

            save.setOnClickListener(v -> {
                String bp_status = "N/A";
                String heart_rate_status = "N/A";
                String sys = systolic.getText().toString();
                String dias = diastolic.getText().toString();
                String hr = heartRate.getText().toString();
                if (!TextUtils.isEmpty(sys) && !TextUtils.isEmpty(dias) && !TextUtils.isEmpty(hr)) {
                    int systolic1 = Integer.parseInt(sys);
                    int diastolic1 = Integer.parseInt(dias);
                    int heart_rate = Integer.parseInt(hr);
                    if (systolic1 >= 180 || diastolic1 >= 120) {
                        bp_status = "Hypertensive Crisis(Seek Emergency Care)";
                    } else if (systolic1 >= 140 || diastolic1 >= 90) {
                        bp_status = "Hypertension Stage 2";
                    } else if (systolic1 >= 130 || diastolic1 >= 80) {
                        bp_status = "Hypertension Stage 1";
                    } else if (systolic1 < 90 && diastolic1 < 60) {
                        bp_status = "Hypotension";

                    } else if (systolic1 > 120) {
                        bp_status = "Elevated";
                    } else if (systolic1 < 120) {
                        bp_status = "Normal";
                    }

                    if (heart_rate >= 60 && heart_rate <= 80) {
                        heart_rate_status = "Normal";
                    } else {
                        heart_rate_status = "Exceptional";
                    }
                    SQliteDBmanager sqliteDBmanager = new SQliteDBmanager(RecordActivity.this);
                     sqliteDBmanager.addRecord(date.getText().toString(),
                            time.getText().toString(), systolic.getText().toString(),
                            diastolic.getText().toString(), heartRate.getText().toString(),
                            bp_status, heart_rate_status, comment.getText().toString());
                    time.setText("");
                    systolic.setText("");
                    diastolic.setText("");
                    heartRate.setText("");
                    date.setText("");
                    comment.setText("");
//            if (res == -1) {
//                Toast.makeText(RecordActivity.this, "Not successful", Toast.LENGTH_LONG).show();
//            } else {
//                Toast.makeText(RecordActivity.this, " successful "+bp_status+" "+heart_rate_status, Toast.LENGTH_LONG).show();
//            }
                    Intent intent = new Intent(RecordActivity.this, listofRecord.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(RecordActivity.this, " Enter data ", Toast.LENGTH_LONG).show();
                }
            });
        }


    }
}

