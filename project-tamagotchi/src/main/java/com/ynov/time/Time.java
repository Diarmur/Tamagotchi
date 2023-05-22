package com.ynov.time;

import java.util.Date;


public class Time {


    Date dateInit = new Date();
    
    

    public int getTime(Date date) {


        return (int)date.getTime()/1000;
    }

    public int elapsedTime(){
        int second = 0;
        Date nowDate = new Date();
        second = this.getTime(nowDate)-this.getTime(this.dateInit);
        
        return second;
    }
}
