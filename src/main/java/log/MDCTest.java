package log;


/**
 * Created by hyq on 2021/2/19 15:34.
 * MDC（Mapped Diagnostic Context，映射调试上下文）是 log4j 和 logback 提供的一种方便在多线程条件下记录日志的功能。
 * MDC 可以看成是一个与当前线程绑定的哈希表，可以往其中添加键值对
 * 典型场景：
 * Web 应用服务器。当用户访问某个页面时，应用服务器可能会创建一个新的线程来处理该请求，
 * 也可能从线程池中复用已有的线程。在一个用户的会话存续期间，可能有多个线程处理过该用户的请求。
 * 这使得比较难以区分不同用户所对应的日志。当需要追踪某个用户在系统中的相关日志记录时，就会变得很麻烦
 */
public class MDCTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadTest t1 = new ThreadTest(1);
        t1.start();
        ThreadTest t2 = new ThreadTest(2);
        t2.start();
        t1.join();
        t2.join();
    }
}
