package concurrent.advance;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hyq on 2021/2/18 18:26.
 */
public class TtlExecutorWrapperDemo {
    static TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        context.set("value-set-in-parent");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService = TtlExecutors.getTtlExecutorService(executorService);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("child-Runnable:" + context.get());
            }
        };
        Callable call = new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("child-Callable:" + context.get());
                return null;
            }
        };
        executorService.submit(task);
        executorService.submit(call);
        executorService.shutdown();
    }

}
