package day2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class UserLoginController {
    public static void main(String[] args) throws IOException {

        Configuration conf = new Configuration();

        LoginServiceInterface loginServiceImpl = RPC.getProxy(LoginServiceInterface.class, 1L, new InetSocketAddress("127.0.0.1", 10000), conf);

        String result = loginServiceImpl.login("朱大大","123");

        System.out.println(result);

    }
}
