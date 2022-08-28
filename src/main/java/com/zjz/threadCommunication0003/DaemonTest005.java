package com.zjz.threadCommunication0003;

/**
 * @ClassName DaemonTest005
 * @Author Junzhou Zhang
 * @Create 2022/8/23 0:27
 */
public class DaemonTest005 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println("我是子线程...");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {

            }
            System.out.println("我是主线程");
        }
        System.out.println("主线程执行完毕!");
    }


}
