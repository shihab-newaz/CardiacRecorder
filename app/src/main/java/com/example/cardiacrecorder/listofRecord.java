package com.example.cardiacrecorder;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class listofRecord extends AppCompatActivity {
    private ListView showdatalistView;

    SQliteDBmanager database;
    private List<Record> recordList;
    private adapter showAdapter;
    public FloatingActionButton add;
    public Cursor records,show;
    SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);
        recordList = new ArrayList<>();
        showAdapter = new adapter(listofRecord.this, recordList);

        showdatalistView = findViewById(R.id.user_data_list_view);

        database = new SQliteDBmanager(listofRecord.this);

        records = database.getListContents();

        add = findViewById(R.id.floating_add_btn);
        add.setOnClickListener(view ->
        {
            Intent intent2 = new Intent(listofRecord.this, RecordActivity.class);
            intent2.putExtra("check", "1");
            startActivity(intent2);
        });

        if (records.getCount() == 0) {
            Toast.makeText(listofRecord.this, "History is empty", Toast.LENGTH_LONG).show();
        } else {
            while (records.moveToNext()) {
                recordList.add(new Record(records.getString(1), records.getString(2),
                        records.getString(4), records.getString(3),
                        records.getString(5), records.getString(8),
                        records.getString(6), records.getString(7)));
            }

            showdatalistView.setAdapter(showAdapter);
        }

        show = database.showRecords();


        showdatalistView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(listofRecord.this, ShowMeasurement.class);
            {
                while (show.moveToNext()) {
                    intent.putExtra("creation_time", show.getString(1));
                    intent.putExtra("creation_date", show.getString(2));
                    intent.putExtra("systolic", show.getString(3));
                    intent.putExtra("diastolic", show.getString(4));
                    intent.putExtra("heart_rate", show.getString(5));
                    intent.putExtra("comments", show.getString(8));
                }
                startActivity(intent);
            }
        });


    }


}



