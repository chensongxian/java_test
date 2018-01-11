package thread01.base;

import java.security.Policy;
import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 数据库连接池
 * @Author: csx
 * @Date: 2018/01/11
 */
public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();


    public ConnectionPool() {
        this(10);
    }

    /**
     * 连接池构造方法
     * @param initialSize
     */
    public ConnectionPool(int initialSize) {
        if (initialSize > 0) {
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }else{
            throw new RuntimeException("请设置线程池合理大小");
        }
    }


    /**
     * 是否连接池资源
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 添加后需要进行通知，这样其他消费者能够感知到链接池中已经归还了一个链接
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    /**
     * 在mills内无法获取到连接，将会返回null
     * @param mills
     * @return
     * @throws InterruptedException
     */
    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            // 完全超时
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }

                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }

                Connection result = null;
                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }


}
