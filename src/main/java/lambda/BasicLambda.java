package lambda;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hyq on 2021/3/2 11:38.
 */
public class BasicLambda {
    public static void main(String[] args) {
        File f = new File(".");
        File[] files = f.listFiles((dir, name) -> name.endsWith(".txt"));
        Arrays.sort(files, (f1, f2) -> f1.getName().compareTo(f2.getName()));
        ExecutorService executor = Executors.newFixedThreadPool(100);
        executor.submit(() -> System.out.println("hello world"));
        executor.shutdown();
    }
}
