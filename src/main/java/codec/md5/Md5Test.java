package codec.md5;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Date;

/**
 * Created by hyq on 2021/1/4 17:39.
 */
public class Md5Test {

    public static void main(String[] args) {
        String appSecret = "abc";
        String appId = "123";

        long time = new Date().getTime();

        String token = appSecret + appId + time + appSecret;
        String md5Token = DigestUtils.md5Hex(token.getBytes());
        String xAuthToken = String.format("from:%s:%s", appId, md5Token);

        System.out.println(xAuthToken);
        System.out.println(time);
    }
}
