package com.myapp.model;

import android.content.ContentValues;
import com.squareup.sqlbrite.BriteDatabase;

public class Schedule {

    public static final String TABLE = "schedule";
    public static final String ID = "schedule_id";
    public static final String TITLE = "schedule_title";
    private static final String DATE = "date";
    private static final String TIME = "time";

    public static final String CREATE_SCHEDULE = "CREATE TABLE "
        + TABLE
        + "( "
        + ID
        + " INTEGER NON NULL PRIMARY KEY"
        + TITLE
        + " TEXT NOT NULL"
        + DATE
        + " TEXT "
        + TIME
        + " TEXT ) ";

    private String title;
    private String date;
    private String time;

    public Schedule(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public long insertInto(BriteDatabase briteDatabase) {
        return briteDatabase.insert(TABLE, toContentValues());
    }

    private ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(TITLE, title);
        values.put(DATE, date);
        values.put(TIME, time);
        return values;
    }
}
