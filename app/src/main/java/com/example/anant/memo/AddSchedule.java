package com.example.anant.memo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class AddSchedule extends AppCompatActivity implements Calender.getCalenderDate,AddScheduleFragment.getCalenderDate1{

    private static int SCHEDULE_FRAG_ID=R.id.Schedule_layout;

    private static String SCHEDULE_FRAG_TAG="schedule_frag";
    private static String CALENDAR_FRAG_TAG="calendar_frag";

    public void replaceScheduleFrgament(Bundle args,int fragId,String tag){
        AddScheduleFragment fragment = new AddScheduleFragment();
        fragment.setArguments(args);

        getSupportFragmentManager().beginTransaction().replace(fragId,fragment,tag).addToBackStack(tag).commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);
        setDate(-1);
    }


    public void setDate(long date){
        Bundle args = new Bundle();
        args.putLong(AddScheduleFragment.DATE_VAL,date);
        replaceScheduleFrgament(args,SCHEDULE_FRAG_ID,SCHEDULE_FRAG_TAG);
    }


    public void getDateCalendar(long date) {
        Calender fragment= new Calender();
        getSupportFragmentManager().beginTransaction().replace(SCHEDULE_FRAG_ID,fragment,CALENDAR_FRAG_TAG).addToBackStack(SCHEDULE_FRAG_TAG).commit();
    }
}
