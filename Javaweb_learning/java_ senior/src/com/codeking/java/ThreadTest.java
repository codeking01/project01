package com.codeking.java;

/**
 * @author king_xiong
 * @date 2022-01-02 21:37
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        //调用start（）： 1.开启线程 2.调用当前线程的run()
        t1.start();
        /**
         *  ①不可以通过 t1.run（）去直接调用  这样的话，并没有开启线程。
         *  ②要再 启动一个线程的话，需要重新去新建一个线程对象，然后再调用：  MyThread t2= new MyThread(); t2.start();
         */


        //如下的操作还是在主线程main中执行的
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "********************main()***************");
            }
        }
    }
}
