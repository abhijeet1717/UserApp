package com.example.userapp;

import java.util.Calendar;

public class Functions {
    public static String wishMe(){
        String s = "";
        Calendar c = Calendar.getInstance();
        int time = c.get(Calendar.HOUR_OF_DAY);

        if(time >= 0 && time<12){
            s = "Good Morning! ";
        } else if (time>=12 && time<16) {
            s = "Good Afternoon!";
        } else if (time>=16 && time<20) {
            s = "Good Evening! ";
        } else if (time>=20 && time<22) {
            s = "Good Night! ";
        }

        return  s;
    }
}
