package thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author chenxing
 * ReentrantLock（重入锁）：
 * 1，顾名思义就是像一把锁，我们可以锁住，又可以打开，从而控制资源的同步访问。而其中重入特性指的是同一个线程，可以反复的进入；
 * 2，中断响应，对于synchronized只有保持等待，和继续执行两种情况；而ReentrantLock在等待的过程，我们可以通知其放弃等待
 * （类似生活中约会，你等了一会朋友没到，但是朋友遇到突发情况不能来了，给你打了电话通知你，你就不等了）；
 * 3，申请等待时间：就是指定等待时间，在指定时间没得到，则放弃；4，公平锁：指定fair为true则进行先到先得，而不是随机选取。
 * 原文链接：https://blog.csdn.net/liujiahan629629/article/details/84312204
 */

/**
 * 1 顾名思义就是像一把锁，我们可以锁住，又可以打开
 */
public class T02ReenTrantLock implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private static Integer num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            //加锁
            lock.lock();
            try {
                num++;
            } finally {
                //解锁
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T02ReenTrantLock r1 = new T02ReenTrantLock();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        System.out.println(num);
        t1.join();
        System.out.println(num);
        t2.join();
        System.out.println(num);
    }
}


/**
 * 2 lock.lockInterruptibly()中断后可放弃。
 * 当线程在活动之前或活动期间处于正在等待、休眠或占用状态且该线程被中断时，抛出该异常InterruptedException。
 * 有时候，一种方法可能希望测试当前线程是否已被中断，如果已被中断，则立即抛出异常InterruptedException.
 */
class InterruptLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public InterruptLock(int lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            if (lock == 1) {
                System.out.println("lock 1 begin..");
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                System.out.println("lock 2 begin..");
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptLock interruptLock1 = new InterruptLock(1);
        InterruptLock interruptLock2 = new InterruptLock(2);
        Thread t1 = new Thread(interruptLock1);
        Thread t2 = new Thread(interruptLock2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        //中断线程
        t2.interrupt();
    }
}

/**
 * 3 申请等待时间例子：如果直接使用tryLock()如果拿不到则直接返回，不会等待
 */
class TimeLock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            //如果在等待的时间限内可以拿到锁，则运行。拿不到则直接跳过。
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " begin.Get lock success.");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName() + " get lock failed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TimeLock r1 = new TimeLock();
        new Thread(r1).start();
        new Thread(r1).start();
    }
}


//4,公平锁，先到先得
class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock.");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock);
        Thread t2 = new Thread(fairLock);
        t1.start();
        t2.start();
    }
}

/**
 * Condition条件：记得上篇博客中我们wait()、notify()等待和通知，Condition也可以实现类似的功能，配合锁进行使用。
 * 提供的方法await()、awaitUninterruptibly()、awaitNanos(long nanosTimeout)、await(long time,TimeUnit unit)、signal()、signalAll()等，也很容易理解。
 * 这里提一下：生产者消费者模型中，如果库房慢了，则生产者await；如果库房没了，则消费者await；生产者生成一个则signal；消费者消费一个则signal。
 */
class ConditionTest implements Runnable {

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition condition = reentrantLock.newCondition();

    public void run() {
        try {
            reentrantLock.lock();
            condition.await();
            System.out.println("Thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest conditionTest = new ConditionTest();
        Thread t1 = new Thread(conditionTest);
        t1.start();
        Thread.sleep(2000);
        reentrantLock.lock();
        //释放条件，使线程继续
        condition.signal();
        reentrantLock.unlock();
    }
}

/**
 * Semaphore信号量：这个也挺容易理解的。无论是synchronized还是lock都是一次只能一个线程获取资源，而信号量可以多个同时访问。
 * 其中方法有：acquire()、acquireUninterruptibly()、tryAcquire()、tryAcquire(long timeout,TimeUnit unit)、release()等。
 * 构造方法默认是1个，表示只能同时一个线程进入acquire()和release()间的code，如果构造方法是多个则可以同时进入多个。
 */
class SemaphoreTest implements Runnable {
    //代码段可以同时进入5个线程
    final Semaphore semaphore = new Semaphore(5);

    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " done");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        final SemaphoreTest semaphoreTest = new SemaphoreTest();
        for (int i = 0; i < 20; i++) {
            executorService.execute(semaphoreTest);
        }
        //等待执行完毕，关闭线程
        executorService.shutdown();
    }
}


/**
 * ReadWriteLock读写锁：现实业务场景中往往都是读多写少，而读不会带来数据的不一致性，所以就有了读写锁，读读不阻塞、读写阻塞、写写阻塞，对于读远远大于写的非常使用。
 */
class ReadWriteLockTask {
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private Integer value = 0;

    /**
     * 读取数据
     *
     * @param lock
     * @return
     * @throws InterruptedException
     */
    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 写入数据
     *
     * @param lock
     * @param num
     * @throws InterruptedException
     */
    public void handleWrite(Lock lock, int num) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            this.value = num;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockTask task = new ReadWriteLockTask();
        Runnable readRun = () -> {
            try {
                Thread.sleep(1000);
                Integer num = (int) task.handleRead(readLock);
                System.out.println("read number is " + num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable writeRun = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("begin write..");
                int number = new Random().nextInt(100);
                task.handleWrite(writeLock, number);
                System.out.println("after write,number is " + number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 2; i++) {
            new Thread(writeRun).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(readRun).start();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(writeRun).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(readRun).start();
        }
    }
}
