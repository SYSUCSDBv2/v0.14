package com.a.io_ver13;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TimePicker;

/**
 * Created by pengb on 2017/12/19.
 */

public class CreateActivity extends Activity {
    public final int CREATE_REQUEST = 1;
    public final int CREATE_RESULT = 2;
    public final int DATE_DIALOG = 1;
    public final int TIME_DIALOG = 2;
    public EventData m_event_data;
    public boolean i = true;
    public DBOper dboper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_page);
        m_event_data = new EventData();
        dboper = new DBOper(this);
        //add button event here
        Button button_date = (Button)findViewById(R.id.button_date_selecter);
        button_date.setText(m_event_data.day_to_string());
        button_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*link create page here*/
                /*Intent intent = new Intent();
                intent.setClass(CreateActivity.this, DateSelecter.class);
                startActivity(intent);*/
                showDialog(DATE_DIALOG);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });
        Button button_time = (Button)findViewById(R.id.button_time_selecter);
        button_time.setText(m_event_data.time_to_string());
        button_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                showDialog(TIME_DIALOG);
            }
        });
        Button button_confirm = (Button)findViewById(R.id.button_confirm);
        button_confirm.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                //pass data to main
                EditText edit_title = (EditText)findViewById(R.id.edit_title);
                EditText edit_note = (EditText)findViewById(R.id.edit_note);
                String m_event_title = "";
                m_event_title += edit_title.getText().toString().trim();
                String m_event_note = "";
                m_event_note += edit_note.getText().toString().trim();
                Intent return_intent = new Intent();
                //return_intent.putExtra("event_title", m_event_title);
                //return_intent.putExtra("event_note", m_event_note);
                //return_intent.putExtra("i", i);
                //finish
                // m_event_data.set_enable();
                m_event_data.set_event_title(m_event_title);
                m_event_data.set_event_note(m_event_note);
                //DBOper m_dboper = new DBOper(CreateActivity.this);
                dboper.insert(m_event_data);
                setResult(CREATE_RESULT, return_intent);
                finish();
            }
        });
        //add switch event here
        final Switch switch_alarm = (Switch)findViewById(R.id.switch_alarm);
        switch_alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                if(isChecked){
                    switch_alarm.setText(new StringBuffer().append("yes"));
                }
                else{
                    switch_alarm.setText(new StringBuffer().append("nooooooo!"));
                }
            }

        });

    };

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, 2017, 1-1, 1);
            case TIME_DIALOG:
                return new TimePickerDialog(this, mtimeListener, 1, 1, true);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            /*mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;*/
            Button button_date = (Button)findViewById(R.id.button_date_selecter);
            button_date.setText(new StringBuffer().append(year).append("-").append(monthOfYear+1).append("-").append(dayOfMonth));
            m_event_data.set_event_day(year, monthOfYear, dayOfMonth);
        }
    };
    private TimePickerDialog.OnTimeSetListener mtimeListener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            Button button_time = (Button)findViewById(R.id.button_time_selecter);
            button_time.setText(new StringBuffer().append(hourOfDay).append(":").append(minute));
            m_event_data.set_event_time(hourOfDay, minute, 0);
        }
    };
}
