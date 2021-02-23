package enumtest;

/**
 * Created by hyq on 2021/2/23 10:28.
 */
public class Demo {
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

    public static void main(String[] args) {
//        onChosen(Size.LARGE);
        Size.MEDIUM.onChosen();
    }
}
