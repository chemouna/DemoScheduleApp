package com.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.myapp.data.ScheduleManager;
import com.myapp.model.Schedule;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.scheduleRv) RecyclerView scheduleRv;
    @BindView(R.id.fab) FloatingActionButton fab;
    @BindView(R.id.toolbar) Toolbar toolbar;
    private ScheduleManager scheduleManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        scheduleManager = ((MyApp) getApplicationContext()).getScheduleManager();

        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.schedules);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        scheduleRv.setLayoutManager(new LinearLayoutManager(this));
        ScheduleAdapter scheduleAdapter = new ScheduleAdapter();
        scheduleRv.setAdapter(scheduleAdapter);

        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule("Schedule 1", "5 Wed", "3:00 - 4:00 pm"));
        schedules.add(new Schedule("Schedule 2", "6 Mon", "8:00 - 9:00 pm"));
        schedules.add(new Schedule("Schedule 3", "14 Thu", "4:00 - 7:00 am"));
        schedules.add(new Schedule("Schedule 4", "17 Fri", "7:00 - 9:00 pm"));
        schedules.add(new Schedule("Schedule 5", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 6", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 7", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 8", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 9", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 10", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 11", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 12", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 13", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 14", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 15", "22 Wed", "10:00 - 11:00 am"));
        schedules.add(new Schedule("Schedule 16", "22 Wed", "10:00 - 11:00 am"));

        //scheduleManager.getSchedules();

        scheduleAdapter.addSchedules(schedules);
    }

    @OnClick(R.id.fab)
    void onFabClick() {
        Intent intent = new Intent(this, AddScheduleActivity.class);
        startActivity(intent);
    }

}
