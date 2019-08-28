package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
..........[6]
.....13.....73..12
[3].28.............[0]
..24............67.17
....[1].62.........[4]
...................20
...............45....
..........[5]..37..[2]      
0베이스*/
public class KruskalTest {
/*	public static class Edge implements Comparable<Edge>{
		int a; //
		int b; //정점
		int distance; //간선의 가중치or거리
		Edge(int a, int b, int distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(distance, o.distance);
		}
		@Override
		public String toString() {
			return "(a=" + a + ", b=" + b + ") distance=" + distance;
		}
	}*/
	public static int N=7;
	public static List<int[]> v;
	public static int[] p;
	public static int findSet(int x) { //getParent와 동일, p를 위에 선언했으므로 아규먼츠에서 삭제
		if(p[x]==x) return x;
		else return p[x]=findSet( p[x]);
	}
	public static void union(int[] p, int a, int b) {
		a=findSet(a);
		b=findSet(b);
		if(a<b) p[b]=a;
		else 	p[a]=b; //이 대소비교는 상관X
	}
/*	public static boolean findParent(int[] p, int a, int b) {
		a=findSet(p,a);
		b=findSet(p,b);
		if(a==b) 	return true; //같은 집합에 있다.
		else 		return false; //다른 집합에 있다.
	}*/
	
	public static int kruskal() {
		Collections.sort(v, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]); //가중치 기준 소팅
			}
		});
		for(int[] e:v) System.out.println(Arrays.toString(e));

		System.out.println();
		//Make-Set
		p = new int[N+1]; //+1
		for(int i=0; i<N+1; i++) p[i]=i; //+1
		
		//
		int sum=0;
		for(int i=0; i<v.size(); i++) {
			//if(!findParent(p, v.get(i).a -1, v.get(i).b -1)){
			if(findSet(v.get(i)[0])!=findSet(v.get(i)[1])) {
				System.out.println("->"+Arrays.toString(v.get(i)));
				sum += v.get(i)[2];
				union(p, v.get(i)[0], v.get(i)[1]); //그래프가 사이클인지 확인할 수 있음
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		v = new ArrayList<>();
		v.add(new int[]{1,7,12});
		v.add(new int[]{1,4,28});
		v.add(new int[]{1,2,67});
		v.add(new int[]{1,5,17});
		v.add(new int[]{2,4,24});
		v.add(new int[]{2,5,62});
		v.add(new int[]{3,5,20});
		v.add(new int[]{3,6,37});
		v.add(new int[]{4,7,13});
		v.add(new int[]{5,6,45});
		v.add(new int[]{5,7,73}); //a<-b, 한쪽으로 방향이 있다.
		System.out.println(kruskal());
	}
}
