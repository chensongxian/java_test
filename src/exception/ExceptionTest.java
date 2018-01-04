package exception;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/01/04
 */
public class ExceptionTest {
    @Test
    public void testException(){
        String path = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            Thread.sleep(10);
             String result=br.readLine();
        } catch (IOException|InterruptedException e) {
            e.printStackTrace();
        }
    }
}
