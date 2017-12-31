package com.a.io_ver13;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/30.
 * 这个是用来调用的！
 */

public class DBOper {
    private DBConnector connector;
    private ArrayList<EventData> eventlist = new ArrayList<EventData>();
    public DBOper(Context context) {
        connector = new DBConnector(context);
    }
    //插入事件将接受一个EventData数据，注意event_id在此函数中无效
    public void insert(EventData eventdata) {
        SimpleDateFormat sdf= (SimpleDateFormat) SimpleDateFormat.getDateTimeInstance();
        int if_alarm = 0;
        if(eventdata.event_if_alarm) if_alarm = 1;
        SQLiteDatabase database = connector.getWritableDatabase();
        database.execSQL("insert into EventData (event_title, event_date, event_if_alarm, event_note) values(?,?,?,?)",
                new Object[] {eventdata.event_title,sdf.format(eventdata.event_date),if_alarm,eventdata.event_note});
        database.close();
    }

    public void delete(EventData eventdata) {
        SimpleDateFormat sdf= (SimpleDateFormat) SimpleDateFormat.getDateTimeInstance();
        int if_alarm = 0;
        if(eventdata.event_if_alarm) if_alarm = 1;
        SQLiteDatabase database = connector.getWritableDatabase();
        database.execSQL("delete from EventData where event_title = ? and event_date = ? and event_if_alarm = ? and event_note = ?",
                new Object[] {eventdata.event_title,sdf.format(eventdata.event_date),if_alarm,eventdata.event_note});
        database.close();
    }

    public void update(EventData eventdata1,EventData eventdata2) {
        delete(eventdata1);
        insert(eventdata2);
    }

    public ArrayList<EventData> query() throws ParseException {
        SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getDateTimeInstance();
        SQLiteDatabase database = connector.getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = database.rawQuery("select * from EventData", null);
        eventlist.clear();
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex("event_title"));
            Date date = null;
            date = sdf.parse(cursor.getString(cursor.getColumnIndex("event_date")));
            int ifalarm = cursor.getInt(cursor.getColumnIndex("event_if_alarm"));
            boolean if_alarm = false;
            if (ifalarm == 1) if_alarm = true;
            String note = cursor.getString(cursor.getColumnIndex("event_note"));
            eventlist.add(new EventData(title, date, if_alarm, note));
        }
        return eventlist;
    }
}
