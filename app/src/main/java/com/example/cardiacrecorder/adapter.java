package com.example.cardiacrecorder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class adapter  extends ArrayAdapter <Record> {
    private Activity context;
    private List<Record> RecordList;

    ImageView edit, delete;

    public adapter(Activity context,  List<Record> RecordList) {
        super(context,R.layout.singlerecord,RecordList);
        this.context = context;
        this.RecordList = RecordList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.singlerecord,null,true);
        Record record=RecordList.get(position);
        TextView textView1=view.findViewById(R.id.date_id_single_data_item);
        TextView textView2=view.findViewById(R.id.time_id_single_data_item);
        TextView textView3=view.findViewById(R.id.Systolic_id_single_data_item);
        TextView textView4=view.findViewById(R.id.dystolic_id_single_data_item);
        TextView textView5=view.findViewById(R.id.heartRate_id_single_data_item);
        TextView textView6=view.findViewById(R.id.comment_id_single_data_item);
        TextView textView7=view.findViewById(R.id.bpstatus_id_single_data_item);
        TextView textView8=view.findViewById(R.id.heartratestatus_id_single_data_item);

        textView1.setText(record.getDate());
        textView2.setText(record.getTime());
        textView3.setText(record.getDiastolic());
        textView4.setText(record.getSystolic());
        textView5.setText(record.getHeartRate());
        textView6.setText(record.getComment());
        textView7.setText(record.getBpStatus());
        textView8.setText(record.getHeartRateStatus());
//        ImageView delete = view.findViewById(R.id.deleteButton);
//        delete.setOnClickListener(v-> {
//
//            sQliteDBmanager.deleteList(records.getString(0));
//        });
        return view;

    }

}
