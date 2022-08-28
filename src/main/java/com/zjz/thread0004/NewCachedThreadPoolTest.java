package com.zjz.thread0004;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName NewCachedThreadPoolTest
 * @Author Junzhou Zhang
 * @Create 2022/8/28 14:26
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        // 创建可缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0; i < 30; i++){
            int index = i;
            // 类似执行线程的start()方法
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(index * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "------" + index);
                }
            });
        }
        //关闭线程池
        executorService.shutdown();

    }
}
