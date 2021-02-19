package concurrent.c77;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by hyq on 2021/2/19 16:46.
 * <p>
 * Executors:类，Executor的工具类
 * Executor：接口，任务执行服务，由Executor工具类创建，用于创建ExecutorService
 * ExecutorService：接口，可以理解为线程池对外提供的执行服务（提交任务、获取结果、取消任务、关闭执行服务等）
 */
public class BasicDemo {
    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            int sleepSeconds = new Random().nextInt(1000);
            Thread.sleep(sleepSeconds);
            return sleepSeconds;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new Task());

        // 模拟执行其他任务
        Thread.sleep(100);

        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
