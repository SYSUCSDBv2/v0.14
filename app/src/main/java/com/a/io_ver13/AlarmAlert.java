package com.a.io_ver13;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2018/1/1.
 */

public class AlarmAlert extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        assert bundle != null;
        String title = bundle.getString("event_title");
        String note = bundle.getString("event_note");

        new AlertDialog.Builder(AlarmAlert.this).setTitle(title).setMessage(note)
                .setPositiveButton("I Know", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AlarmAlert.this.finish();
                    }
                }).show();
    }
}
