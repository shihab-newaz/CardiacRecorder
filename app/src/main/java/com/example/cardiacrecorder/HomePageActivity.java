package com.example.cardiacrecorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HomePageActivity extends AppCompatActivity {
CardView add,history;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        add= findViewById(R.id.firstCard);
        history= findViewById(R.id.secondCard);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, RecordActivity.class);
                startActivity(intent);
            }
    }
        );
}}
