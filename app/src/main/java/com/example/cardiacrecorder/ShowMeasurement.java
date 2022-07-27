package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMeasurement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        setContentView(R.layout.activity_show_measurement);

        String date=intent.getStringExtra("creation_date");
        TextView showtime=findViewById(R.id.showTime);
        showtime.setText(date);

        String time=intent.getStringExtra("creation_time");
        TextView showDate=findViewById(R.id.showDate);
        showDate.setText(time);

        String systolic=intent.getStringExtra("systolic");
        TextView showSystolic=findViewById(R.id.showSystolic);
        showSystolic.setText(systolic);

        String diastolic=intent.getStringExtra("diastolic");
        TextView showDiastolic=findViewById(R.id.showDiastolic);
        showDiastolic.setText(diastolic);

        String heart_rate=intent.getStringExtra("heart_rate");
        TextView showBPM=findViewById(R.id.showBPM);
        showBPM.setText(heart_rate);

        String comments=intent.getStringExtra("comments");
        TextView showComment=findViewById(R.id.showComment);
        showComment.setText(comments);

    }
}