package com.zjz.threadDemo0001;

/**
 * @ClassName ThreadDemo005
 * @Author Junzhou Zhang
 * @Create 2022/8/13 13:39
 */
public class ThreadDemo005 {
    public static void main(String[] args) {
        DemoThread demoThread = new DemoThread();
        demoThread.start();

    }
}

class DemoThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("DemoThread-i:" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
