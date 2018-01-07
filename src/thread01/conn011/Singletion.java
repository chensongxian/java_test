package thread01.conn011;
/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018-01-07
 */
public class Singletion {
	
	private static class InnerSingletion {
		private static Singletion single = new Singletion();
	}
	
	public static Singletion getInstance(){
		return InnerSingletion.single;
	}
	
}
