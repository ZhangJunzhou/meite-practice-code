package com.zjz.thread0004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName NewFixedThreadPoolTest
 * @Author Junzhou Zhang
 * @Create 2022/8/28 14:41
 */
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10;i++){
            final int index = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println(Thread.currentThread().getName() + "-------i:" + index);
                }
            });
        }

    }
}
