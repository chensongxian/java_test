package io.nio.fileChannel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/15
 */
public class FileChannelDemo {
    /**
     * 使用Buffer读写数据一般遵循以下四个步骤：
     * 1. 写入数据到Buffer
     * 2. 调用flip()方法
     * 3. 从Buffer中读取数据
     * 4. 调用clear()方法或者compact()方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile=new RandomAccessFile("F:\\idea\\java_test\\src\\io\\nio\\fileChannel\\a.txt","rw");
            FileChannel inChannel=accessFile.getChannel();
            //创建一个48字节的buffer
            ByteBuffer buffer=ByteBuffer.allocate(48);
            //读取进buffer
            int read = inChannel.read(buffer);
            while (read!=-1){
                System.out.println("Read:"+read);
                //让buffer准备被读取
                buffer.flip();
                while (buffer.hasRemaining()){
                    //读取一个字节
                    System.out.println((char) buffer.get());
                }
                //清空缓存，再次被读取
                buffer.clear();
                read=inChannel.read(buffer);
            }
            accessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
