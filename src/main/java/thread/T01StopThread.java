package thread;

/**
 * @author chenxing
 * 一般来说，线程执行完毕就会结束，无须自动关闭。但是对于一些while true的线程如果想关闭呢？Thread类里有stop()方法，但是已经不建议使用了。
 * 因为它是强制停止线程，无论线程处于什么状态，很容易出现线程正在处理一半数据被停止的情况，这样非常容易造成数据不一致问题。
 * 所以慎用stop()(最好不用)，通过下边这种方式来停止那些无限循环的线程
 */
public class T01StopThread extends Thread {

    volatile Boolean stopMe = false;

    /**
     * 创建停止线程的方法
     */
    public void stopMe() {
        this.stopMe = true;
    }

    @Override
    public void run() {
        while (true) {
            //死循环中出现停止标识，直接退出
            if (stopMe) {
                System.out.println("触发线程的标记，线程停止。");
                break;
            }

            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        T01StopThread t1 = new T01StopThread();
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.stopMe();
    }
}

/**
 * 线程中断：是一种线程协作机制。是告诉目标线程一个中断通知，至于接到通知后如何处理，则有线程自己决定处理
 */
class InterruptThread {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            while (true) {
                //判断如果有中断标识，则直接跳出
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("exit by interrupt.");
                    break;
                }
                System.out.println(System.currentTimeMillis());
                //Thread.yield()方法很多人翻译成线程让步，就是说当一个线程使用了这个方法之后，
                // 它就会把自己CPU执行的时间让掉，使当前线程从执行状态（运行状态）变为可执行态（就绪状态），
                // 让自己或者其它的线程运行。(重新抢线程执行)
                Thread.yield();
            }
        };

        Thread t1 = new Thread(r1);
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}

/**
 * 等待（wait）和通知（notify），也是为了支持线程之间的协作。
 * 方法都是在Object上定义的，例如线程A调用了obj.wait()方法，那么线程A就会停止执行，等到其它线程调用obj.notify()方法为止
 */
class WaitNotifyThread {
    final static Object obj = new Object();

    public static void main(String[] args) {
        Runnable r1 = () -> {
            //加同步锁
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + " is start.--" + System.currentTimeMillis());
                try {
                    System.out.println(Thread.currentThread().getName() + " is wait.--" + System.currentTimeMillis());
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is end.--" + System.currentTimeMillis());
            }
        };

        Runnable r2 = () -> {
            //等待第一个线程先执行
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //加同步锁
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + " is start.--" + System.currentTimeMillis());

                System.out.println(Thread.currentThread().getName() + " is notify start.--" + System.currentTimeMillis());
                //唤醒其他加同步锁的线程
                obj.notify();
                System.out.println(Thread.currentThread().getName() + " is notify end.--" + System.currentTimeMillis());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is end.--" + System.currentTimeMillis());
            }
        };

        /*普通方法创建线程
        new Thread(r1).start();
        new Thread(r2).start();
        */

        //使用线程组
        ThreadGroup tg = new ThreadGroup("tg1");
        new Thread(tg, r1, "t1").start();
        new Thread(tg, r2, "t2").start();

        System.out.println("ThreadGroup active count:" + tg.activeCount());
        synchronized (obj){
            System.out.println("-----begin show thread group list:---------");
            tg.list();
            System.out.println("-------show thread group list end.---------");
        }
    }
}

//等待线程结束（join）,主线程等待子线程结束后再执行
class JoinThread {
    volatile static Integer num = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (; num < 10000; num++) ;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread t1 = new AddThread();
        t1.start();
        //等待线程执行一会
        Thread.sleep(1);
        System.out.println(num);
        //等待线程执行完成
        t1.join();
        System.out.println(num);
    }
}