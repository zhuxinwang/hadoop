package day4;


import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 朱新旺
 * @email zhuxinwang@aliyun.com
 * @date 2019/6/26 0026 21:24
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,LongWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //获取到一行文件的内容
        String line = value.toString();
        //切分这一行内容为单词数据
        String[] words = StringUtils.split(line," ");
        //遍历输出 <word,1>
        for (String word:words) {
            context.write(new Text(word),new LongWritable(1));
        }
    }
}
