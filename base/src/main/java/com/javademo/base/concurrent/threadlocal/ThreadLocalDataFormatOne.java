package com.javademo.base.concurrent.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YSS
 * @Date 2020/6/22 16:24
 */
public class ThreadLocalDataFormatOne {
    public static void main(String[] args) {
        for(int i=0;i<30;i++){
            int finalI=i;
            Thread thread=new Thread(()->{
                String date = new ThreadLocalDataFormatOne().date(finalI);
                System.out.println(date);
            });
            thread.start();
        }
    }
    public  String date(int seconds){
        Date date=new Date(1000*seconds);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formatDate = sdf.format(date);
        return formatDate;
    }
}
