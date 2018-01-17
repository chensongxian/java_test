package thread01.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UseConcurrentMap {

	public static void main(String[] args) {
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		chm.put("k1", "v1");
		chm.put("k2", "v2");
		chm.put("k3", "v3");
		/*
		 * puIfAbsent，不存在key值时才会put进去
		 * 如果存在key值，才会返回旧值，不然直接返回null
		 */
		String result1=chm.putIfAbsent("k3","v33");
		String result2=chm.putIfAbsent("k4", "vvvv");

		System.out.println("result1:"+result1);
		System.out.println("result2:"+result2);
		//System.out.println(chm.get("k2"));
		//System.out.println(chm.size());
		
		for(Map.Entry<String, String> me : chm.entrySet()){
			System.out.println("key:" + me.getKey() + ",value:" + me.getValue());
		}
		
		
		
	}
}
