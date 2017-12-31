package com.a.io_ver13;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2017/12/30.
 * 这个不是用来给别的activity调用的~
 */

public class DBConnector extends SQLiteOpenHelper {
    private final static int VERSION = 1;
    private final static String DATABASE_NAME = "localevents.db";
    private static final String TAG = "DBConnector";

    public DBConnector(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table EventData "+
                "(_id integer PRIMARY KEY AUTOINCREMENT," +
                "event_title varchar(255)," +
                "event_date varchar(255)," +
                "event_if_alarm integer," +
                "event_note varchar(255))");
        Log.i(TAG,"onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        this.onDelete(db);
        this.onCreate(db);
    }

    public void onDelete(SQLiteDatabase db) {
        db.execSQL("drop table if exists EventData");
    }
}
