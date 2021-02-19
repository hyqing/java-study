package log;

import org.slf4j.MDC;

/**
 * Created by hyq on 2021/2/19 16:05.
 */
public class ThreadTest extends Thread{
    private int i;

    public ThreadTest() {
    }

    public ThreadTest(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(++i);
        MDC.put("username", String.valueOf(i));

        for (int j = 0; j < 10; j++) {
            System.out.println("aaa" + i);
            if (j == 1) {
                try {
                    this.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("run:" + i + " " + MDC.get("username"));
    }
}
