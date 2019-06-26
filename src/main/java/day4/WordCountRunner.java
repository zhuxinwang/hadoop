package day4;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * 用来描述一个作业job（使用哪个mapper类，哪个reducer类，输入文件在哪，输出结果放哪）
 * 然后提价这个job给hadoop集群
 * @author 朱新旺
 * @email zhuxinwang@aliyun.com
 * @date 2019/6/26 0026 21:56
 * D:\code\study\hadoop\src\main\java\day4\WordCountRunner.java
 * day4.WordCountRunner
 */
public class WordCountRunner {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration conf = new Configuration();
        Job wcJob = Job.getInstance(conf);

        //设置wcJob中的资源躲在的jar包
        wcJob.setJarByClass(WordCountRunner.class);

        //wcJob要使用哪个mapper类
        wcJob.setMapperClass(WordCountMapper.class);
        //wcJob要使用哪个reducer类
        wcJob.setReducerClass(WordCountReducer.class);
        //wcJob的mapper类输出的kv数据类型
        wcJob.setMapOutputKeyClass(Text.class);
        wcJob.setMapOutputValueClass(LongWritable.class);

        //wcJob的reducer类输出的kv数据类型
        wcJob.setOutputKeyClass(Text.class);
        wcJob.setOutputValueClass(LongWritable.class);

        //指定要处理的原始数据的存储位置
        FileInputFormat.setInputPaths(wcJob,"hdfs://192.168.123.11:9000/wc/srcdata");

        //指定处理后的结果的存放路劲
        FileOutputFormat.setOutputPath(wcJob,new Path("hdfs://192.168.123.11:9000/wc/output1"));

        boolean res = wcJob.waitForCompletion(true);

        System.out.println(res);

    }
}
