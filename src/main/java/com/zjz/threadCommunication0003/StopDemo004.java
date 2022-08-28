package com.zjz.threadCommunication0003;


class StopThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "我是子线程");
        }
    }

    public void stopThread() {
        this.flag = false;
    }

}


/**
 * @ClassName StopDemo004
 * @Author Junzhou Zhang
 * @Create 2022/8/23 0:17
 */
public class StopDemo004 {
    public static void main(String[] args) {
        StopThread stopThread1 = new StopThread();
        Thread thread1 = new Thread(stopThread1);
        Thread thread2 = new Thread(stopThread1);
        thread1.start();
        thread2.start();
        int i = 0;
        while (true) {
            System.out.println("thread main..");
            if (i == 30) {
//                 stopThread1.stopThread();
//                thread1.interrupt();
//                thread2.interrupt();
                break;
            }
            i++;
        }
    }

}
