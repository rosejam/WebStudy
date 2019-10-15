package 기출_모비스;

import java.util.Map.Entry;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution2 {
	public static String solution(int n, String[] plates, int[] odo, int k, int[] drives) {
		/*ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(plates[i]);
		}
		Collections.sort(list);*/
/*		TreeMap<String, Integer> map = new TreeMap<>();
		for(int i=0; i<n; i++) {
			map.put(plates[i], odo[i]);
		}*/
		//ArrayList<String> list = new ArrayList<>(map.keySet());
		PriorityQueue<String[]> q = new PriorityQueue<>(new Comparator<String[]>() { //그냥 새로 클래스를 만드는게 낫다.
			@Override
			public int compare(String[] o1, String[] o2) {
				int diff = Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
				if(diff == 0) return o1[0].compareTo(o2[0]);
				return diff;
			}
		});
		for(int i=0; i<n; i++) {
			q.add(new String[] {plates[i], odo[i]+""} );
		}
		
		for(int i=0; i<k; i++) {
			//;
//			int min = Integer.MAX_VALUE;
//			String carname = "";
//			//int carodo = ;
//			for(Entry<String, Integer> entry : map.entrySet()){
//				if(entry.getValue() < min) {
//					carname = entry.getKey();
//					min = entry.getValue();
//				}
//			}
			String[] car = q.poll();
			String d2 = Integer.parseInt(car[1])+drives[i] +"";
			//사용할 차와 그 주행거리 구함
			q.add(new String[] {car[0], d2});
			//map.put(carname, min+drives[i]);
		}
/*		String answer = "";
		int minn = Integer.MAX_VALUE;
		for(Entry<String, Integer> entry : map.entrySet()){
			if(entry.getValue() < minn) {
				answer = entry.getKey();
				minn = entry.getValue();
			}
		}*/
        return q.poll()[0];
    }
	//적산주행거리가 가장 작은 차량부터 고객들에게 대여
    public static void main(String[] args) {
    	int n = 6;
    	String[] P = {"AZ3618", "XP9657", "SP6823", "UH7515", "TV6621", "WZ8264"};
    	int[] odo = {20, 16, 18, 20, 24, 19};
    	int k = 8;
    	int[] drivers = {3, 7, 5, 8, 6, 5, 10, 2};
    	System.out.println(solution(n,P,odo,k,drivers));
	}
}