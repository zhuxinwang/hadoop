package day1;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * HDFS 客户端
 */
public class HdfsClient {
    public static void main(String[] args) {
        try {
            download();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传
     * @throws IOException
     */
    private static void upload() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.123.11:9000/");
        FileSystem fs = FileSystem.get(conf);
        Path destFile = new Path("hdfs://192.168.123.11:9000/test.png");
        FSDataOutputStream os = fs.create(destFile);
        FileInputStream is = new FileInputStream("D:\\Data\\BaiduNetdiskDownload\\04【第四阶段】大数据技术-Hadoop2.x\\hadoop02\\hadoop02\\open流程2.png");
        IOUtils.copy(is,os);

    }

    /**
     * 下载
     * @throws IOException
     */
    private static void download() throws IOException {
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://192.168.123.11:9000/");
        FileSystem fs = FileSystem.get(conf);
        FSDataInputStream is = fs.open(new Path("hdfs://192.168.123.11:9000/test.png"));
        FileOutputStream os = new FileOutputStream("D://test.png");
        IOUtils.copy(is,os);
    }
}
