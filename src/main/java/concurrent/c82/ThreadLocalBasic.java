package concurrent.c82;

/**
 * Created by hyq on 2021/2/18 15:19.
 */
public class ThreadLocalBasic {

    static ThreadLocal<Integer> local = new ThreadLocal<Integer>();

    public static void main(String[] args) throws InterruptedException {
        Thread child = new Thread() {
            @Override
            public void run() {
                System.out.println("child thread initial:" + local.get());
                local.set(200);
                System.out.println("child thread initial:" + local.get());
            }
        };
        local.set(100);
        child.start();
        child.join();
        System.out.println("main thread initial:" + local.get());
    }
}
