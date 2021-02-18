package concurrent.advance;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * TransmittableThreadLocal的基本使用
 * 场景：父线程给子线程传递值
 * InheritableThreadLocal也可以实现这种功能
 */
public class SimpleDemo {
    static ThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();
    static ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        transmittableThreadLocal.set("value-set-in-parent");
        inheritableThreadLocal.set("value-set-in-parent");
        threadLocal.set("value-set-in-parent");

        Thread child = new Thread() {
            @Override
            public void run() {
                System.out.println("child-transmittableThreadLocal:" + transmittableThreadLocal.get());
                System.out.println("child-inheritableThreadLocal:" + inheritableThreadLocal.get());
                System.out.println("child-threadLocal:" + threadLocal.get());
            }
        };
        child.start();
        child.join();
        System.out.println("main-transmittableThreadLocal:" + transmittableThreadLocal.get());
        System.out.println("main-inheritableThreadLocal:" + inheritableThreadLocal.get());
        System.out.println("main-threadLocal:" + threadLocal.get());
    }
}
