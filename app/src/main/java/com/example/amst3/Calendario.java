package com.example.amst3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.EventLog;
import android.widget.Toast;

import com.example.amst3.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Calendario extends AppCompatActivity {

    CompactCalendarView CompactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle(null);

        CompactCalendar = (CompactCalendarView) findViewById(R.id.compactcalendar_view);
        CompactCalendar.setUseThreeLetterAbbreviation(true);

        //Escribir un evento para 'El cumpleaños de la abuela´
        //Thu Nov 19 09:00:00 AST 2020  Thu Nov 19 00:00:00 GMT+00:00 2020
        Event ev1 = new Event(Color.YELLOW, 1606399200000L, "Cumpleaños de la abuela");
        CompactCalendar.addEvent (ev1);

        CompactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();

                if (dateClicked.toString().compareTo("Thu Nov 19 09:00:00 AST 2020") == 1) {
                    Toast.makeText(context, "Cumpleaños de la abuela", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "No hay evento", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth){

                actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));

            }
        });

    }
}
