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
import java.util.List;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_SCHEDULE = 1;
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
        final ScheduleAdapter scheduleAdapter = new ScheduleAdapter();
        scheduleRv.setAdapter(scheduleAdapter);

        final Observable<List<Schedule>> schedulesObservable = scheduleManager.getSchedules();
        schedulesObservable.observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<Schedule>>() {
                @Override
                public void call(List<Schedule> schedules) {
                    scheduleAdapter.setSchedules(schedules);
                }
            });
    }

    @OnClick(R.id.fab)
    void onFabClick() {
        Intent intent = new Intent(this, AddScheduleActivity.class);
        startActivityForResult(intent, REQUEST_CODE_ADD_SCHEDULE);
    }

}
