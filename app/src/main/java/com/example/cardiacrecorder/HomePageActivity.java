package com.example.cardiacrecorder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {
    ImageView add,history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        add= findViewById(R.id.image_add);
        history= findViewById(R.id.image_history);
        add.setOnClickListener(v -> {

            Intent intent = new Intent(HomePageActivity.this, RecordActivity.class);
            intent.putExtra("check","1");
            startActivity(intent);
        }
        );
        history.setOnClickListener(view -> {
            Intent intent = new Intent(HomePageActivity.this, listofRecord.class);
            intent.putExtra("check","2");
            startActivity(intent);
            finish();
        });
}}
