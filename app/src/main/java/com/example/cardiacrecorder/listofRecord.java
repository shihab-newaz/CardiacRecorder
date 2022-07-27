package com.example.cardiacrecorder;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class listofRecord extends AppCompatActivity {
    private ListView showdatalistView;
    ArrayAdapter<String> recordAdapter;
    ArrayList<String> dataList;
    SQliteDBmanager database;
    private List<Record> recordList;
    private adapter showAdapter;
    ImageView edit, delete;
    public Cursor records;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_list);
        ListView listView = findViewById(R.id.user_data_list_view);
        recordList = new ArrayList<>();
        showAdapter = new adapter(listofRecord.this, recordList);
        showdatalistView = (ListView) findViewById(R.id.user_data_list_view);
        database = new SQliteDBmanager(listofRecord.this);
        records = database.getListContents();
        if (records.getCount() == 0) {
            Toast.makeText(listofRecord.this, "History is empty", Toast.LENGTH_LONG).show();
        } else {
            while (records.moveToNext()) {
                recordList.add(new Record(records.getString(1), records.getString(2).toString(), records.getString(4), records.getString(3), records.getString(5), records.getString(8),
                        records.getString(6), records.getString(7)));
            }

            showdatalistView.setAdapter(showAdapter);
        }

    }


}
