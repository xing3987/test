package thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author chenxing
 * ThreadPoolExecutor最原始的构造函数
 * 1,corePoolSize：指定线程池中活跃的线程数量
 * 2,maximumPoolSize：指定线程池中最大线程数量
 * 3,keepAliveTime：超过corePoolSize个多余线程的存活时间
 * 4,unit：keepAliveTime的时间单位
 * 5,workQueue：任务队列，被提交但尚未被执行的任务
 * 6,threadFactory：线程工厂，用于创建线程
 * 7,handler拒绝策略：当任务太多来不及处理时，如何拒绝任务
 * 原文链接：https://blog.csdn.net/liujiahan629629/article/details/84312204
 */
public class T03ThreadPool {

}

/**
 * 1.自定义工厂类
 * work queue 说明：
 * SynchronousQueue	直接提交队列：没有容量，每一个插入操作都要等待一个相应的删除操作。通常使用需要将maximumPoolSize的值设置很大，否则很容易触发拒绝策略。
 * ArrayBlockingQueue	有界的任务队列：任务大小通过入参 int capacity决定，当填满队列后才会创建大于corePoolSize的线程。
 * LinkedBlockingQueue	无界的任务队列：线程个数最大为corePoolSize，如果任务过多，则不断扩充队列，知道内存资源耗尽。
 * PriorityBlockingQueue	优先任务队列：是一个无界的特殊队列，可以控制任务执行的先后顺序，而上边几个都是先进先出的策略。
 */
class ThreadFactoryDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " Thread Name:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadFactoryDemo.MyTask myTask = new ThreadFactoryDemo.MyTask();
        //创建线程池，并指定线程创建工厂类的策略
        ExecutorService pool = new ThreadPoolExecutor(4, 50, 0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                //t.setDaemon(true);
                System.out.println("create thread:" + t.getName());
                return t;
            }
        });
        //使用线程池提交代码
        for (int i = 0; i < 10; i++) {
            pool.submit(myTask);
        }

        pool.shutdown();
    }
}


/**
 * 拒绝策略：如果线程池处理速度达不到任务的出现速度时，只能执行拒绝策略，看下JDK提供几种，然后自定义看个例子：
 * JDK提供的线程池拒绝策略
 * 策略名称	描述
 * AbortPolicy	该策略会直接抛出异常，阻止系统正常 工作。线程池默认为此。
 * CallerRunsPolicy	只要线程池未关闭，该策略直接在调用者线程中，运行当前被丢弃的任务。
 * DiscardOledestPolicy	该策略将丢弃最老的一个请求，也就是即将被执行的一个任务，并尝试重新提交当前任务。
 * DiscardPolicy	该策略默默地丢弃无法处理的任务，不予任务处理。
 */
class RejectThreadPoolDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + " Thread Name:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadFactoryDemo.MyTask myTask = new ThreadFactoryDemo.MyTask();
        //创建线程池，并指定线程创建工厂类的策略
        ExecutorService pool = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + " is discard");
            }
        })/*
        自定义线程池beforeExecute()每个线程执行前，afterExecute()每个线程执行后，terminated()线程池退出时
        {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行线程：" + r.toString() +"==="  + t.getName());
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成线程：" + r.toString());
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出" );
            }
        }*/;
        //使用线程池提交代码
        for (int i = 0; i < 20; i++) {
            pool.submit(myTask);
        }

        pool.shutdown();
    }
}

/**
 * 七，最后看下分而治之：Fork/Join：大家都知道hadoop中的Map-Reduce分开处理，合并结果；当今流行的分布式，将用户的请求分散处理等等。分而治之是非常有用实用的。
 * JDK帮我们提供了ForkJoinPool线程池，供我们做这些处理，有两个子类供我们使用，Recursive有返回值，RecursiveAction无返回值，看个例子吧：
 */
class ForkJoinThreadPoolDemo extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10000;
    private long start;
    private long end;

    public ForkJoinThreadPoolDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (long i = start; i < end; i++) {
                sum += i;
            }
        } else {
            //分成100份进行处理
            long step = (start + end) / 50;
            ArrayList<ForkJoinThreadPoolDemo> subTasks = new ArrayList<ForkJoinThreadPoolDemo>();
            long pos = start;
            for (int i = 0; i < 50; i++) {
                long lastOne = pos + step;
                if (lastOne > end) {
                    lastOne = end;
                }
                ForkJoinThreadPoolDemo subTask = new ForkJoinThreadPoolDemo(pos, lastOne);
                pos += step;
                subTasks.add(subTask);
                subTask.fork();
            }
            for (ForkJoinThreadPoolDemo t : subTasks) {
                sum += t.join();
            }
        }
        return sum;
    }

    //结果199990000
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinThreadPoolDemo task = new ForkJoinThreadPoolDemo(0, 20000);
        ForkJoinTask<Long> result = forkJoinPool.submit(task);

        try {
            long res = result.get();
            System.out.println("结果" + res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}