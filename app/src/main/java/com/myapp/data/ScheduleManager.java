package com.myapp.data;

import android.content.Context;
import com.myapp.model.Schedule;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;
import rx.Observable;
import rx.schedulers.Schedulers;

public class ScheduleManager {

    BriteDatabase briteDatabase;

    public ScheduleManager(Context context) {
        final SqlBrite sqlBrite = new SqlBrite.Builder().build();
        briteDatabase = sqlBrite.wrapDatabaseHelper(new DbOpenHelper(context), Schedulers.io());
    }

    public long insertSchedule(Schedule schedule) {
        return schedule.insertInto(briteDatabase);
    }

    public Observable<Schedule> getSchedules() {
        //briteDatabase.createQuery(Schedule.TABLE, )
    }
}
