package concurrent.c82;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hyq on 2021/2/18 15:49.
 */
public class ThreadPoolProblem {
    static ThreadLocal<AtomicInteger> sequencer = new ThreadLocal<AtomicInteger>() {

        @Override
        protected AtomicInteger initialValue() {
            return new AtomicInteger(0);
        }
    };

    static class Task implements Runnable {

        @Override
        public void run() {
            sequencer.remove();
            AtomicInteger s = sequencer.get();
            int initial = s.getAndIncrement();
            // 期望初始为0
            System.out.println(initial);
        }
    }


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Task());
        executor.execute(new Task());
        executor.execute(new Task());
        executor.shutdown();
    }
}
