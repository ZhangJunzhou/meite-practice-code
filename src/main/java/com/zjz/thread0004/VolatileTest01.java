package com.zjz.thread0004;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName VolatileTest01
 * @Author Junzhou Zhang
 * @Create 2022/8/27 10:37
 */
public class VolatileTest01 extends Thread {
//    private static volatile int count;

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    // private static AtomicInteger count = new AtomicInteger(0);
//    private static void addCount() {
//
//    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
//            count++;
            atomicInteger.incrementAndGet();
        }
        System.out.println(atomicInteger);
    }

    public static void main(String[] args) {

        VolatileTest01[] arr = new VolatileTest01[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new VolatileTest01();
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i].start();
        }

    }

}
