package com.example.cardiacrecorder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * UnitTest class for testing insertion, update or deletion in the RecordList
 */
public class UnitTest {
    /**
     * create a Mock RecordList with one Record data
     * @return
     * returns a RecordList
     */
    private  RecordList mockRecordList() {
        RecordList recordList = new RecordList();
        recordList.addRecord(mockRecord());
        return recordList;
    }

    /**
     * create a Mock Record
     * @return
     * returns created Mock Record
     */
    private Record mockRecord() {
        return new Record("12/12/12", "10:00", "120", "80", "60", "after walk", "Normal", "Normal");
    }

    /**
     * checks if a record is added successfully on RecordList
     */
    @Test
    public void testAdd() {
        Record record1 = new Record("12/12/12", "10:00",
                "120", "80", "60", "after drink",
                "Normal", "Normal");
        RecordList recordList = new RecordList();
        recordList.addRecord(record1);
        assertEquals(1, recordList.getRecords().size());

        Record record3 = new Record("12/12/12", "10:00",
                "120", "80", "60", "after drink",
                "Normal", "Normal");
        recordList.addRecord(record3);
        assertEquals(2, recordList.getRecords().size());

        Record record2 = new Record("12/12/12", "10:00", "120", "80", "60", "after drink", "Normal", "Normal");
        recordList.addRecord(record2);

        assertEquals(3, recordList.getRecords().size());
        assertTrue(recordList.getRecords().contains(record1));
    }

    /**
     * checks if add function handle exception successfully
     */
    @Test
    public void testAddException() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("12/12/12", "10:00",
                "120", "80", "60", "after drink",
                "Normal", "Normal");
        recordList.addRecord(record1);

        assertThrows(IllegalArgumentException.class, () -> {
            recordList.addRecord(record1);
        });
    }

    /**
     * checks if getRecords return a List successfully
     */
    @Test
    public void testGetRecords() {
        RecordList recordList = new RecordList();
        Record record1 = new Record("12/12/12", "10:00",
                "120", "80", "60", "after drink",
                "Normal", "Normal");
        recordList.addRecord(record1);
        assertEquals(0,record1.compareTo(recordList.getRecords().get(0)));

        Record record2 = new Record("98", "78", "68", "Tuesday,July 12",
                "08:06 PM", "after drink", "Normal", "Normal");
        recordList.addRecord(record2);


        assertEquals(0, record2.compareTo(recordList.getRecords().get(1)));
//        assertEquals(1, record2.compareTo(recordList.getRecords().get(0)));

    }

    /**
     * checks if record is deleted successfully from RecordList
     */
    @Test
    public void testDelete() {
        RecordList temp = new RecordList();

        Record a = new Record("98", "78", "68", "Tuesday,July 12", "08:06 PM", "after drink", "Normal", "Normal");

        temp.addRecord(a);
        temp.delete(a);

        assertFalse(temp.getRecords().contains(a));
    }

    /**
     * checks if delete function handle exception successfully
     */
    @Test
    public void testDeleteException() {
        RecordList temp = mockRecordList();

        Record record = new Record("98", "78", "68", "Tuesday,July 12", "08:06 PM", "after drink", "Normal", "Normal");

        assertThrows(IllegalArgumentException.class, () -> {
            temp.delete(record);
        });
    }

    /**
     * checks if countRecords function can count records on RecordList successfully
     */
    @Test
    public void testcountRecords() {
        RecordList recordList = new RecordList();

        Record record = new Record("98", "78", "68", "Tuesday,July 12",
                "08:06 PM", "after drink", "Normal", "Normal");

        recordList.addRecord(record);
        assertEquals(1, recordList.countRecords());
    }

    /**
     * checks if record is updated successfully on RecordList
     */
    @Test
    public void testupdate() {
        RecordList recordList = new RecordList();

        Record record1 = new Record("95", "75", "68", "Tuesday,July 12", "08:02 PM", "after walk", "Normal", "Normal");
        Record record2 = new Record("98", "78", "68", "Tuesday,July 12", "08:06 PM", "after drink", "Normal", "Normal");

        recordList.addRecord(record1);

        recordList.update(record1, record2);
        assertEquals(0, record2.compareTo(recordList.getRecords().get(0)));
    }

    /**
     * checks if update function handle exception in deleting successfully
     */
    @Test
    public void testUpdateExceptionDelete() {
        RecordList recordList = new RecordList();

        Record record1 = new Record("95", "75", "68", "Tuesday,July 12", "08:02 PM", "after walk", "Normal", "Normal");
        Record record2 = new Record("98", "78", "68", "Tuesday,July 12", "08:06 PM", "after drink", "Normal", "Normal");

        assertThrows(IllegalArgumentException.class, () -> {
            recordList.update(record1, record2);
        });
    }

    /**
     * checks if update function handle exception in adding successfully
     */
    @Test
    public void testUpdateExceptionAdd() {
        RecordList recordList = new RecordList();

        Record record1 = new Record("95", "75", "68", "Tuesday,July 12", "08:02 PM", "after walk", "Normal", "Normal");
        Record record2 = new Record("98", "78", "68", "Tuesday,July 12", "08:06 PM", "after drink", "Normal", "Normal");

        recordList.addRecord(record2);
        recordList.addRecord(record1);
        assertThrows(IllegalArgumentException.class, () -> {
            recordList.update(record1, record2);
        });
    }

}