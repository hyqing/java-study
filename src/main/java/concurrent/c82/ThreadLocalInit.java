package concurrent.c82;

/**
 * Created by hyq on 2021/2/18 15:31.
 */
public class ThreadLocalInit {
    static ThreadLocal<Integer> local = new ThreadLocal<Integer>() {

        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public static void main(String[] args) {
        System.out.println(local.get());
        local.set(200);
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
    }
}
