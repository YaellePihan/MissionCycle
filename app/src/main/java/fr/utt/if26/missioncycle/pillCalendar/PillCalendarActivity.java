package fr.utt.if26.missioncycle.pillCalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import fr.utt.if26.missioncycle.R;

public class PillCalendarActivity extends AppCompatActivity {
    CalendarView pill_calendar;
    TextView pill_calendar_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_calendar);

        pill_calendar = (CalendarView)
                findViewById(R.id.calendarView_apc);
        pill_calendar_title = (TextView)
                findViewById(R.id.tv_apc_calendar_title);

        pill_calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(
                    @NonNull CalendarView view,
                    int year,
                    int month,
                    int dayOfMonth) {

                String Date
                        = dayOfMonth + "-"
                        + (month + 1) + "-" + year;

                // set this date in TextView for Display
                pill_calendar_title.setText(Date);
            }
        });
    }
}