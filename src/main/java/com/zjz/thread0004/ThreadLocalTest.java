package com.zjz.thread0004;

class Res {
    // 生成序列号共享变量
    public static Integer count = 0;

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };

    public Integer getNum() {
        int count = threadLocal.get() + 1;
        threadLocal.set(count);
        return count;
    }
}


/**
 * @ClassName ThreadLocalTest
 * @Author Junzhou Zhang
 * @Create 2022/8/27 10:51
 */
public class ThreadLocalTest extends Thread {
    private Res res;

    public ThreadLocalTest(Res res){
        this.res = res;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            System.out.println(Thread.currentThread().getName() + "---" + "i---" + i + "--num:" + res.getNum());
        }
    }


    public static void main(String[] args) {
        Res res = new Res();
        ThreadLocalTest threadLocalTest1 = new ThreadLocalTest(res);
        ThreadLocalTest threadLocalTest2 = new ThreadLocalTest(res);
        ThreadLocalTest threadLocalTest3 = new ThreadLocalTest(res);
        threadLocalTest1.start();
        threadLocalTest2.start();
        threadLocalTest3.start();

    }
}
