package com.javademo.base.concurrent.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.*;

/**
 * 会有重复日期 发生线程安全问题
 * @Author YSS
 * @Date 2020/6/22 16:24
 */
public class ThreadLocalDataFormatThreadPool {
    private static ExecutorService threadPool= Executors.newFixedThreadPool(10);
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    public static void main(String[] args) {
        ConcurrentSkipListSet concurrentSkipListSet=new ConcurrentSkipListSet<>();
        for(int i=0;i<1000;i++){
            int finalI=i;
            Runnable target=()->{
                String date = new ThreadLocalDataFormatOne().date(finalI);
                concurrentSkipListSet.add(date);
                System.out.println(date);
            };
            threadPool.submit(target);
        }
        threadPool.shutdown();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(concurrentSkipListSet.size());
    }
    public  String date(int seconds){
        Date date=new Date(1000*seconds);
        String formatDate = sdf.format(date);
        return formatDate;
    }
}
