package basic;

import java.util.UUID;

/**
 * Created by hyq on 2021/2/19 14:38.
 */

//测试UUID
public class UUIDTest {
    public static void main(String[] args) {
        byte[] bytes = {2, 3};
        System.out.println(UUID.fromString("a-b-e-e-f"));
        System.out.println(UUID.nameUUIDFromBytes(bytes));
        System.out.println(UUID.randomUUID());
    }
}
