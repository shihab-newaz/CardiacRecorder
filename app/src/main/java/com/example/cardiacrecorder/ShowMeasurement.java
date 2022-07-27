package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMeasurement extends AppCompatActivity {
    SQliteDBmanager sQliteDBmanager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        setContentView(R.layout.activity_show_measurement);
        String date=intent.getStringExtra("creation_date");
        TextView textView=findViewById(R.id.showTime);
        textView.setText(date);
        String time=intent.getStringExtra("creation_time");
        TextView textView1=findViewById(R.id.showDate);
        textView1.setText(time);
        String systolic=intent.getStringExtra("systolic");
        TextView textView2=findViewById(R.id.showSystolic);
        textView2.setText(systolic);
        String diastolic=intent.getStringExtra("diastolic");
        TextView textView3=findViewById(R.id.showDiastolic);
        textView3.setText(diastolic);
        String heart_rate=intent.getStringExtra("heart_rate");
        TextView textView4=findViewById(R.id.showBPM);
        textView4.setText(heart_rate);
        String comments=intent.getStringExtra("comments");
        TextView textView5=findViewById(R.id.showComment);
        textView5.setText(comments);
    }
}