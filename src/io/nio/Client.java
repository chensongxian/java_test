package io.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/15
 */
public class Client {
    public static void main(String[] args) {
        //创建连接地址
        InetSocketAddress address=new InetSocketAddress("127.0.0.1",8765);

        //声明连接通道
        SocketChannel socketChannel=null;
        //创建缓冲区
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);

        try {
            //打开通道
            socketChannel=SocketChannel.open();
            //进行连接
            socketChannel.connect(address);

            while (true){
                //定义一个字节数组，使用系统录入功能
                byte[] bytes=new byte[1024];
                System.in.read(bytes);
                //把数据放入缓冲区
                byteBuffer.put(bytes);
                //对缓冲区进行复位
                byteBuffer.flip();
                //写出数据
                socketChannel.write(byteBuffer);
                //清空缓冲区
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socketChannel!=null){
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
