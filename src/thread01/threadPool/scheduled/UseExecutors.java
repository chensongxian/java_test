package thread01.threadPool.scheduled;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class UseExecutors {

	public static void main(String[] args) {

		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY,14);
		calendar.set(Calendar.MINUTE,9);
		calendar.set(Calendar.SECOND,0);

		Timer timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				System.out.println("执行");
			}
		},calendar.getTime(),1000);
		
		//cache fixed single
		
		
		
	}
}
