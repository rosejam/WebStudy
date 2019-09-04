package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnionFind {
	public static class Edge implements Comparable<Edge>{
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
	}
	public static int getParent(int[] p, int x) {
		if(p[x]==x) return x; //대표값까지 도달
		else return p[x]=getParent(p, p[x]); //p[x]에 대입하여서 Path compression까지 함께함
	}
	public static void unionParent(int[] p, int a, int b) {
		a=getParent(p,a);
		b=getParent(p,b);
		if(a<b) p[b]=a;
		else 	p[a]=b; //union할 때는 대소비교를 해주고 넣어야 한다!!!!
	}
	public static boolean findParent(int[] p, int a, int b) {
		a=getParent(p,a);
		b=getParent(p,b);
		if(a==b) 	return true; //같은 집합에 있다.
		else 		return false; //다른 집합에 있다.
	}
	public static void main(String[] args) {
		int n=7;
		int m=11;
		List<Edge> v = new ArrayList<Edge>();
		v.add(new Edge(1,7,12));
		v.add(new Edge(1,4,28));
		v.add(new Edge(1,2,67));
		v.add(new Edge(1,5,17));
		v.add(new Edge(2,4,24));
		v.add(new Edge(2,5,62));
		v.add(new Edge(3,5,20));
		v.add(new Edge(3,6,37));
		v.add(new Edge(4,7,13));
		v.add(new Edge(5,6,45));
		v.add(new Edge(5,7,73)); //a<-b, 한쪽으로 방향이 있다.
		
		Collections.sort(v);
		for(Edge e:v) System.out.println(e);
		//System.out.println(v.toString());
/*
(1,7)12
(4,7)13
(1,5)17
(3,5)20
(2,4)24
(1,4)28
(3,6)37
(5,6)45
(2,5)62
(1,2)67
(5,7)73		
*/		
		System.out.println();
		//Make-Set
		int[] p = new int[n]; //n+1개로 만들어서 0번방을 안써도됨 (그럼 아래 -1들을 생략할수 있음)
		for(int i=0; i<n; i++) p[i]=i;
		
		//
		int sum=0;
		for(int i=0; i<v.size(); i++) {
			if(!findParent(p, v.get(i).a -1, v.get(i).b -1)){
				System.out.println("->"+v.get(i));
				sum += v.get(i).distance;
				unionParent(p, v.get(i).a -1, v.get(i).b -1); //그래프가 사이클인지 확인할 수 있음
			}
		}
		System.out.println(sum);
	}
}
