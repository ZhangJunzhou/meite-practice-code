package com.zjz.thread0004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName NewSingleThreadExecutorTest
 * @Author Junzhou Zhang
 * @Create 2022/8/28 14:48
 */
public class NewSingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "------index:" + index);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            });
        }

    }
}
