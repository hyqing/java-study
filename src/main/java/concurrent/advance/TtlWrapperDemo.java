package concurrent.advance;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlCallable;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hyq on 2021/2/18 18:06.
 */
public class TtlWrapperDemo {
    static TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 在父线程中设置
        context.set("value-set-in-parent");

//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("child:" + context.get());
//            }
//        };

        Callable task = new Callable() {
            @Override
            public String call() {
                System.out.println("child:" + context.get());
                return context.get();
            }
        };
        // 额外的处理，生成修饰了的对象ttlRunnable
//        Runnable ttlRunnable = TtlRunnable.get(task);
        Callable ttlRunnable = TtlCallable.get(task);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(ttlRunnable);
        System.out.println(executorService.submit(ttlRunnable).get());

        executorService.shutdown();
    }
}
