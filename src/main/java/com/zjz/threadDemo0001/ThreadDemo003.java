package com.zjz.threadDemo0001;

/**
 * @ClassName ThreadDemo003
 * @Author Junzhou Zhang
 * @Create 2022/8/13 12:57
 */
public class ThreadDemo003 implements Runnable {

    private static final int count = 100;

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println("ThreadDemo003-i:" + i);
        }
    }
}
