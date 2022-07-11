package com.codeking.exer;

import static javafx.util.Duration.millis;
import static sun.misc.Version.println;

/**
 * 通过同步机制完成线程的安全问题
 *
 * @author king_xiong
 * @date 2022-01-03 19:30
 */
class Window1 implements Runnable {
    private int ticket = 100;
    //Object obj=new Object();

    @Override
    public void run() {
        while (true) {
            //开启同步代码块  同步监视器，加锁。任何一个类的对象都可以充当锁
            //surround with 的快捷键是ctrl+alt+t
            synchronized(this){  //obj-->替换为this当前对象（慎用，最好使用：当前类.class）  只要保证这个对象是唯一的就可以，因为这个地方只创建了一个对象（w）
            /*
             synchronized(当前类.class)  这个也是可以充当一个对象的，类只会加载一次
             */
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":卖票，窗口为：" + ticket);
                ticket--;
            } else {
                break;
            }
        } }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        //创建一个窗口对象
        Window1 w = new Window1();
        //开启多线程
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        //给线程命名
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        //t1.start();
        //t2.start();
        //t3.start();
        StringBuffer s1 = new StringBuffer();
        System.out.println(s1);
        s1.append("a");
        System.out.println(s1);
    }
}
