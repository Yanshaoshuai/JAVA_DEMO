package com.javademo.base.concurrent.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YSS
 * @Date 2020/6/22 16:24
 */
public class ThreadLocalDataFormatZero {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            String date = new ThreadLocalDataFormatZero().date(10);
            System.out.println(date);
        });
        Thread thread2=new Thread(()->{
            String date = new ThreadLocalDataFormatZero().date(10047);
            System.out.println(date);
        });
        thread1.start();
        thread2.start();
    }
    public  String date(int seconds){
        Date date=new Date(1000*seconds);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formatDate = sdf.format(date);
        return formatDate;
    }
}
