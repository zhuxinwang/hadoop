package day4;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 朱新旺
 * @email zhuxinwang@aliyun.com
 * @date 2019/6/26 0026 21:48
 */
public class WordCountReducer extends Reducer<Text, LongWritable,Text,LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        //定义一集累加计数器
        long count = 0;
        for(LongWritable value:values){
            count += value.get();
        }
        //输出<单词：count>键值对
        context.write(key,new LongWritable(count));

    }
}
