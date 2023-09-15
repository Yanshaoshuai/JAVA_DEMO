package com.javademo.base.concurrent.create;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author YSS
 * @Date 2020/6/11 23:53
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
