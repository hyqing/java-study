package enumtest;

import java.sql.SQLOutput;

/**
 * Created by hyq on 2021/1/4 17:53.
 */
public class Test {
    public static void main(String[] args) {
        Size size = Size.MEDIUM;
        System.out.println(size.toString());
        System.out.println(size.name());
        System.out.println(size.ordinal());

        System.out.println(size == Size.MEDIUM);
        System.out.println(size.equals(Size.MEDIUM));

        System.out.println(size.compareTo(Size.LARGE));

        System.out.println(Size.valueOf("LARGE") == Size.LARGE);

        for(Size s : Size.values()){
            System.out.println(s);
        }

        onChosen(size);
    }

    static void onChosen(Size size) {
        switch (size) {
            case SMALL:
                System.out.println("chosen small");
                break;
            case MEDIUM:
                System.out.println("chosen medium");
                break;
            case LARGE:
                System.out.println("chosen large");
                break;
        }
    }
}
