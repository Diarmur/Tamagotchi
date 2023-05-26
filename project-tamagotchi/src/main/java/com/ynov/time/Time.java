package com.ynov.time;

import java.util.Date;


public class Time {


    private Date dateInit = new Date();
    public int timeUnit = 0;
    private int second = 0;
    

    public int getTime(Date date) {


        return (int)date.getTime()/1000;
    }

    public boolean elapsedTime(){
        
        Date nowDate = new Date();
        if(this.getTime(nowDate)-this.getTime(this.dateInit)>this.second){
            this.second++;
            this.timeUnit++;
            return true;
        }
        
        
        return false;
    }
}
