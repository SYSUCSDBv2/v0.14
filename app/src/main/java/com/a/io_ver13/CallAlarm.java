package com.a.io_ver13;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2018/1/1.
 */

public class CallAlarm extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        DBOper dboper = new DBOper(context);
        EventData eventData = dboper.getRemindMsg();
        if (eventData != null) {
            Intent myIntent = new Intent(context,AlarmAlert.class);
            Bundle bundleRet = new Bundle();
            bundleRet.putString("event_title",eventData.event_title);
            bundleRet.putString("event_note",eventData.event_note);
            myIntent.putExtras(bundleRet);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(myIntent);
        }
    }
}
