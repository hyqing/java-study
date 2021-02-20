package basic.buildintype;

/**
 * Created by hyq on 2021/2/20 9:45.
 */
public class StringTest {
    public static void main(String[] args) {
//        String msg = "Connection reset by peer";
//        msg.indexOf("by");
//        System.out.println("ww");

        String msg = "boo:and:oofoo";
        String[] arr1 = msg.split(":");
        for (String s : arr1) {
            System.out.println(s);
        }
        System.out.println("-------------------");
        String[] arr2 = msg.split("o");
        System.out.println(arr2.length);
        for (String s : arr2) {
            System.out.println(s);
        }
    }
}
