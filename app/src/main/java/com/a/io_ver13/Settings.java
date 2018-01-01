package com.a.io_ver13;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by cudd1es on 17-12-29.
 */

public class Settings extends Activity {
    Button log_in;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        log_in = (Button) findViewById(R.id.setting_button_user);

        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(Settings.this, CreateActivity.class);
                startActivity(intent);
            }
        });

        Button btn_rtn = (Button)findViewById(R.id.button_return);
        btn_rtn.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                            finish();
                                       }
                                   }

        );

        /*final Switch pop_up = (Switch) findViewById(R.id.setting_notification_switch);
        pop_up.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean pop) {
                if (pop) {
                    pop_up.setText(new StringBuffer().append("Push enabled"));
                } else {
                    pop_up.setText(new StringBuffer().append("Push disabled"));
                }
            }
        });*/

    }
}
