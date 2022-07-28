package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMeasurement extends AppCompatActivity {
    Button edit, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_show_measurement);

        String date = intent.getStringExtra("creation_date");
        TextView showtime = findViewById(R.id.showTime);
        showtime.setText(date);

        String time = intent.getStringExtra("creation_time");
        TextView showDate = findViewById(R.id.showDate);
        showDate.setText(time);

        String systolic = intent.getStringExtra("systolic");
        TextView showSystolic = findViewById(R.id.showSystolic);
        showSystolic.setText(systolic);

        String diastolic = intent.getStringExtra("diastolic");
        TextView showDiastolic = findViewById(R.id.showDiastolic);
        showDiastolic.setText(diastolic);

        String heart_rate = intent.getStringExtra("heart_rate");
        TextView showBPM = findViewById(R.id.showBPM);
        showBPM.setText(heart_rate);

        String comments = intent.getStringExtra("comments");
        TextView showComment = findViewById(R.id.showComment);
        showComment.setText(comments);

        edit = findViewById(R.id.buttonEdit);
        delete = findViewById(R.id.buttonDelete);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ShowMeasurement.this, RecordActivity.class);
                intent2.putExtra("creation_date", date);
                intent2.putExtra("creation_time", time);
                intent2.putExtra("systolic", systolic);
                intent2.putExtra("diastolic", diastolic);
                intent2.putExtra("heart_rate", heart_rate);
                intent2.putExtra("comments", comments);
                intent2.putExtra("check", "1");
                startActivity(intent2);
                finish();
            }


        });


        delete.setOnClickListener(view ->
        {
//            Intent intent3 = new Intent(ShowMeasurement.this, RecordActivity.class);
//            startActivity(intent3);
        });
    }
}