package 문제풀이3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution_D4_7701_염라대왕의이름정렬_서울9반_김동주_끝_ { //이름의 길이가 짧을수록 이 앞에 있었고, 같은 길이면 사전 순으로 앞에 있었다. //같은 이름은 한개만 남겨놓기
    public static int TC,N;
    //public static Name[] names2;
    public static Set<String> names;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_D4_7701.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            N = Integer.parseInt(br.readLine()); //이름 개수
            
            names = new TreeSet<>(new Comparator<String>() { //!!!!문제에 주어진 대로 조건을 작성 후 입력을 넣기
				@Override
				public int compare(String o1, String o2) {
					int l1=o1.length();
					int l2=o2.length();
					if(l1==l2) return o1.compareTo(o2); //2. 길이가 같을 때는 string비교
					return Integer.compare(l1, l2); //1. 길이비교
				}
			});
            
            for(int n=0; n<N; n++) {
                String line = br.readLine();
                names.add(line);
            }
            //1. 트리셋에 입력다받음(중복 제거 및 알파벳순)
 
/*            ArrayList<String> namelist = new ArrayList<>(names); //2. 셋을 리스트로
            Collections.sort(namelist, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length(); //3. 길이로 정렬
                }
            });*/ //이부분은 위에 comperator 설정으로 끝난다.
            List<String> namelist = new ArrayList<>(names);
            
            sb.append("#"+tc+"\n");
            //한줄에 하나씩 출력하기
            for(int s=0; s<namelist.size(); s++) {
                sb.append(namelist.get(s)+"\n");
            }
        }
        System.out.print(sb);
    }
 
}
