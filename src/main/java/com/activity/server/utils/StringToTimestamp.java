package com.activity.server.utils;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StringToTimestamp {
    public Timestamp stringToTimestamp(String time) {
        Timestamp timestamp= null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            timestamp = java.sql.Timestamp.valueOf(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return timestamp;
    }
}
