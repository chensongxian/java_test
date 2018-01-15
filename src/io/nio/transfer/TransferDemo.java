package io.nio.transfer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/15
 */
public class TransferDemo {
    public static void main(String[] args) {
        RandomAccessFile fromFile=null;
        FileChannel fromChannel=null;

        RandomAccessFile toFile=null;
        FileChannel toChannel=null;
        try {
            fromFile=new RandomAccessFile("F:\\idea\\java_test\\src\\io\\nio\\transfer\\from.txt","rw");
            fromChannel=fromFile.getChannel();

            toFile=new RandomAccessFile("F:\\idea\\java_test\\src\\io\\nio\\transfer\\to.txt","rw");
            toChannel=toFile.getChannel();
            long position=0;
            long count=fromChannel.size();
//            toChannel.transferFrom(fromChannel,position,count);
            fromChannel.transferTo(position,count,toChannel);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fromFile!=null){
                try {
                    fromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fromChannel!=null){
                try {
                    fromChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(toFile!=null){
                try {
                    toFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(toChannel!=null){
                try {
                    toChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
