package thread;

import java.util.concurrent.*;

/**
 * Future模式——异步调用
 */
public class T05Future {
}

/**
 * 数据接口
 */
interface Data {
    String getResult();
}

/**
 * RealData类
 */
class RealData implements Data {
    private String result;

    @Override
    public String getResult() {
        return result;
    }

    public RealData(String data) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(data);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        result = sb.toString();
    }
}

/**
 * FutureData类
 * FutureData是realData的包装(利用线程锁get方法实现异步调用)
 */
class FutureData implements Data {

    private RealData realData;
    private Boolean isReady = false;

    public synchronized void setRealData(RealData data) {
        //如果已经设定了值，则直接返回，不能再设定值
        if (isReady) {
            return;
        }
        this.realData = data;
        isReady = true;
        //唤醒其他等待的线程
        this.notifyAll();
    }

    @Override
    public synchronized String getResult() {
        //如果没有设定值，则等待
        while (!isReady) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getResult();
    }
}

/**
 * 调用future
 */
class Client {
    public Data request(final String queryStr) {
        final FutureData futureData = new FutureData();
        //单独起个线程进行数据处理
        new Thread(() -> {
            RealData realData = new RealData(queryStr);
            futureData.setRealData(realData);
        }).start();
        //立即返回
        return futureData;
    }

    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("hello");
        System.out.println("请求完成。。");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据" + data.getResult());
    }

}

/**
 * JDK中的Future模式：JDK已经帮我们准备了一套完整的实现，我们可以利用其进行非常方便的实现功能。
 * 1，先把上边的例子改为使用jdk的
 */
class RealDataJDK implements Callable<String> {
    private String value;

    public RealDataJDK(String value) {
        this.value = value;
    }

    @Override
    public String call() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(value);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.value = sb.toString();
        return this.value;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new RealDataJDK("hello"));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);
        executorService.shutdown();
        System.out.println("请求完毕");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据: " + futureTask.get());
    }
}