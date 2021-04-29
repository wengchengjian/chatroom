package service;

import com.wcj.chat.start.server.ServerStart;
import org.junit.Test;

/**
 * @Author 翁丞健
 * @Date:2021/4/28 16:25
 * @Version 1.0.0
 */

public class ServerTest {

    public static void main(String[] args) throws Exception {
        ServerStart serverStart = new ServerStart();
        serverStart.start();
    }
}
