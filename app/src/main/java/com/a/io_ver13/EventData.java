package com.a.io_ver13;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/27.
 */

public class EventData {
    public String event_title;
    public Date event_date;
    //public Time event_time;
    public boolean event_if_alarm;
    public String event_note;

    public EventData() {
        event_title = "";
        event_date = new Date(System.currentTimeMillis());
        event_note = "";
        event_if_alarm = true;
    }

    public EventData(String title, Date date, boolean if_alarm, String note) {
        event_title = title;
        event_date = date;
        event_note = note;
        event_if_alarm = if_alarm;
    }

    public void set_event_title(String new_title) {
        event_title = new_title;
    }

    public void set_event_date(Date new_date) {
        event_date = new_date;
    }

    public void set_event_day(Date new_date) {
        event_date.setYear(new_date.getYear());
        event_date.setMonth(new_date.getMonth());
        event_date.setDate(new_date.getDay());
    }

    public void set_event_day(int year, int month, int day) {
        event_date.setYear(year);
        event_date.setMonth(month);
        event_date.setDate(day);
    }

    public void set_event_time(Date new_time) {
        event_date.setHours(new_time.getHours());
        event_date.setMinutes(new_time.getMinutes());
        event_date.setSeconds(new_time.getSeconds());
    }

    public void set_event_time(Time new_time) {
        event_date.setHours(new_time.getHours());
        event_date.setMinutes(new_time.getMinutes());
        event_date.setSeconds(new_time.getSeconds());
    }

    public void set_event_time(int hour, int minute, int second) {
        event_date.setHours(hour);
        event_date.setMinutes(minute);
        event_date.setSeconds(second);
    }

    public void set_event_note(String new_note) {
        event_note = new_note;
    }


    public String get_event_title() {
        return event_title;
    }

    public Date get_event_data() {
        return event_date;
    }

    public String get_event_note() {
        return event_note;
    }

    public String toString() {
        SimpleDateFormat sdf= (SimpleDateFormat) SimpleDateFormat.getDateTimeInstance();
        return event_title+","+sdf.format(event_date)+","+event_if_alarm+","+event_note;
    }

    public String day_to_string() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        return sdf.format(event_date);
    }

    public String time_to_string() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(event_date);
    }

    public String date_to_string() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return sdf.format(event_date);
    }

}
