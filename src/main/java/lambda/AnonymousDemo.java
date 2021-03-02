package lambda;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hyq on 2021/3/2 11:06.
 */
public class AnonymousDemo {
    public static void main(String[] args) {
        File f = new File(".");
        File[] files = f.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".txt")) {
                    return true;
                }
                return false;
            }
        });

        //将files按照文件名称排序
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File f1, File f2) {
                return f1.getName().compareTo(f2.getName());
            }
        });

        //执行一个简单的任务
        ExecutorService executor = Executors.newFixedThreadPool(100);
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world1");
            }
        });

        executor.shutdown();
    }
}
