package com.a.io_ver13;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pengb on 2017/12/29.
 */

public class DefaultEvent {
    public ArrayList<EventData> water_event;
    public ArrayList<EventData> sleep_event;
    public ArrayList<EventData> sport_event;

    public DefaultEvent() {
        for(int i = 0; i < 6; i++) {
            EventData tmp = new EventData();
            tmp.set_event_title("Drink Water!");
            tmp.set_event_note("For your health, you need 6 bottles of water everyday.");
            Time tmp_time = new Time(8+i*3, 0, 0);
            tmp.set_event_time(tmp_time);
            //tmp.set_unable();
            water_event.add(tmp);
        }
        for(int i = 0; i < 2; i++) {
            EventData tmp = new EventData();
            tmp.set_event_title("Sleep Now!");
            tmp.set_event_note("For your health, you need to sleep now.");
            Time tmp_time = new Time(12+i*12, 0, 0);
            tmp.set_event_time(tmp_time);
            //tmp.set_unable();
            sleep_event.add(tmp);
        }
        for(int i = 0; i < 3; i++) {
            EventData tmp = new EventData();
            tmp.set_event_title("Take some Sports!");
            tmp.set_event_note("For your health, you need 1h sports everyday.");
            int h = 6;
            if(i == 1) h = 17;
            if(i == 2) h = 21;
            Time tmp_time = new Time(h, 0, 0);
            tmp.set_event_time(tmp_time);
            //tmp.set_unable();
            sport_event.add(tmp);
        }
    }
    
    public void add_water_event() {
        Date now = new Date();
        for (EventData evt: water_event) {
            //evt.set_enable();
            evt.set_event_day(now);
        }
    }

    public void add_sport_event() {
        Date now = new Date();
        for (EventData evt: sport_event) {
            //evt.set_enable();
            evt.set_event_day(now);
        }
    }

    public void add_sleep_event() {
        Date now = new Date();
        for (EventData evt: sleep_event) {
           // evt.set_enable();
            evt.set_event_day(now);
        }
    }
}
