package com.example.cardiacrecorder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

/**
 * DatabaseUnitTest class for testing on Database insertion, update or delete
 */
@RunWith(RobolectricTestRunner.class)
public class DatabaseTest {

    /**
     * checks if a record is added successfully on database
     */
    @Test
    public void testAdd() {
        SQliteDBmanager sqLiteDatabase = new SQliteDBmanager(RuntimeEnvironment.application);
        String date="12/12/12";
        String time="10:00";
        String systol = "120";
        String diastol = "80";
        String pulse = "68";
        String comments = "ok";
        String bpstatus = "Normal";
        String pulse_status = "Normal";



        Long id = sqLiteDatabase.addRecord(date,time,systol, diastol, bpstatus, pulse, pulse_status, comments);

        assertTrue(sqLiteDatabase.checkData(id.toString()));

        sqLiteDatabase.close();
    }

    /**
     * checks if a record is deleted successfully on database
     */
    @Test
    public void testdelete() {
        SQliteDBmanager sQliteDBmanager = new SQliteDBmanager(RuntimeEnvironment.application);
        String date="12/12/12";
        String time="10:00";
        String systol = "120";
        String diastol = "80";
        String pulse = "68";
        String comments = "ok";
        String bpstatus = "Normal";
        String pulse_status = "Normal";


        Long id = sQliteDBmanager.addRecord(date,time,systol, diastol,pulse, bpstatus, pulse_status, comments);

        sQliteDBmanager.deleteList(id.toString());

        assertTrue(!sQliteDBmanager.checkData(id.toString()));

       sQliteDBmanager.close();
    }

    /**
     * checks if update on database is successful
     */
    @Test
    public void testUpdate() {
        SQliteDBmanager sQliteDBmanager = new SQliteDBmanager(RuntimeEnvironment.application);

        String date="12/12/12";
        String time="10:00";
        String systol = "120";
        String diastol = "80";
        String pulse = "68";
        String comments = "ok";
        String bpstatus = "Normal";
        String pulse_status = "Normal";



        Long id = sQliteDBmanager.addRecord(date,time,systol, diastol,pulse, bpstatus, pulse_status,comments);

        date="12/12/12";
        time="10:00";
        systol = "120";
        diastol = "80";
        pulse = "60";
        comments = "ok";
        bpstatus = "Normal";
        pulse_status = "not ok";


        long flag = sQliteDBmanager.updateData(id.toString(), date,time,systol, diastol,pulse, bpstatus, pulse_status, comments);

        assertEquals(1,flag);

        sQliteDBmanager.close();
    }

}
