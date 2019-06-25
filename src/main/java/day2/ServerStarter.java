package day2;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;

public class ServerStarter {
    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        RPC.Builder builder = new RPC.Builder(conf);
        builder.setInstance(new LoginServiceImpl())
                .setBindAddress("127.0.0.1")
                .setPort(10000)
                .setProtocol(LoginServiceInterface.class);
        RPC.Server server = builder.build();
        server.start();
    }
}
