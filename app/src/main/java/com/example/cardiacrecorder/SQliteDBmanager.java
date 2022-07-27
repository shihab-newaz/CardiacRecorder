package com.example.cardiacrecorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

/**
 * this is a manager class which extends SQLiteOpenHelper class
 * this manager class has some methods to do some operation with sqlite database
 */
public class SQliteDBmanager extends SQLiteOpenHelper {
    private static final String dbname = "measurements";
    private Context context;
    private static final String table_name = "records";

    /**
     * initialize MyDatabaseHelper with context
     *
     * @param context initialize context
     */
    public SQliteDBmanager(@Nullable Context context) {
        super(context, dbname, null, 1);
        this.context = context;
    }



    /**
     * onCreate method of SQliteDBmanager class
     * this method will be
     * executed and connect system with sqlite database
     *
     * @param sqLiteDatabase this uses SQLiteDatabase type as parameter
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            String query = "CREATE TABLE " + table_name +
                    "(id integer primary key autoincrement,creation_date text,creation_time text," +
                    "systolic text,diastolic text,heart_rate text," +
                    "bp_status text,heart_rate_status text,comment text)";
            sqLiteDatabase.execSQL(query);
        } catch (Exception e) {
            Toast.makeText(context, "Error-can't create table: " + e, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * this method will do some update on database table
     *
     * @param sqLiteDatabase this is a SQLiteDatabase type parameter
     * @param i
     * @param i1
     */

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + table_name);
            onCreate(sqLiteDatabase);
        } catch (Exception e) {
            Toast.makeText(context, "Exception : " + e, Toast.LENGTH_SHORT).show();
        }
    }


    /**
     * add record into sqlite database
     *
     * @param date
     * @param date      time
     * @param time      systolic pressure
     * @param systolic  diastolic pressure
     * @param diastolic heartrate
     * @param heartrate
     * @param comment
     * @return return the id of where this record data is inserted
     * in database
     */

    public long addRecord(String date, String time, String systolic, String diastolic, String heartrate,
                          String bpstatus, String heartratestatus, String comment) {
        long result=0;
        try {
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("creation_date", date);
            contentValues.put("creation_time", time);
            contentValues.put("systolic", systolic);
            contentValues.put("diastolic", diastolic);
            contentValues.put("heart_rate", heartrate);
            contentValues.put("bp_status", bpstatus);
            contentValues.put("heart_rate_status", heartratestatus);
            contentValues.put("comment", comment);

            result = sqLiteDatabase.insert(table_name, null, contentValues);


        } catch (SQLiteException e) {
            e.printStackTrace();
            Toast.makeText(context, "Could not add to database", Toast.LENGTH_LONG).show();
        }
        return result;
    }

        /**
         * used to update data on database
         *
         * @param id              id for each record
         * @param date            date
         * @param time            time
         * @param systolic        systolic data
         * @param diastolic       disatolic data
         * @param heartrate       heartRate
         * @param bpstatus        bpstatus
         * @param heartratestatus bpstatus
         * @param comment         comment on each record
         * @return true if data is updated on that particular id or
         * false if updateData is unsuccessful
         */
        public Boolean updateData (String id, String date, String time, String systolic, String
        diastolic, String heartrate, String comment, String bpstatus, String heartratestatus){

            // Toast.makeText(context,"id: "+id,Toast.LENGTH_SHORT).show();
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("creation_date", date);
            contentValues.put("creation_date", time);
            contentValues.put("systolic", systolic);
            contentValues.put("diastolic", diastolic);
            contentValues.put("heart_rate", heartrate);
            contentValues.put("bp_status", bpstatus);
            contentValues.put("heart_rate_status", heartratestatus);
            contentValues.put("comment", comment);

            long res = sqLiteDatabase.update("records", contentValues, "_id = ?", new String[]{id});

            if (res > 0) return true;

            return false;
        }

        /**
         * delete a particular data from database table
         * where row id is equal to parameterized id
         *
         * @param id id of that record which you want to delete
         * @return
         */
        public long deleteList (String id){
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            return sqLiteDatabase.delete("records", id + " = ?", new String[]{id});
        }

        /**
         * create a ListArray from fetching database all values
         * using cursor
         *
         * @return a simpleCursorAdapter to return all values at once
         */
    public SimpleCursorAdapter loadListViewFromDB() {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        String columns[] = {"id", "date", "time", "systolic", "diastolic", "heartrate", "bpstatus", "heartratestatus"};
        Cursor cursor = sqLiteDatabase.query(SQliteDBmanager.table_name, columns, null, null, null, null, null);

        String[] fromFieldNames = new String[]{
                "id", "date", "time", "systolic", "diastolic", "heartrate", "bpstatus", "heartratestatus"
        };

        int[] toViewId = new int[]{
                R.id.listid, R.id.date_id_single_data_item, R.id.time_id_single_data_item, R.id.Systolic_id_single_data_item, R.id.dystolic_id_single_data_item, R.id.heartRate_id_single_data_item, R.id.comment_id_single_data_item, R.id.bpstatus_id_single_data_item, R.id.heartratestatus_id_single_data_item
        };
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(context, R.layout.singlerecord, cursor, fromFieldNames, toViewId);
        return listAdapter;

    }
    public Cursor getListContents(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor data=sqLiteDatabase.rawQuery("SELECT * FROM "+table_name,null);
        return data;

    }

    }

