
public class Hello2 {

	public static void main(String[] args) {
		char[] ca = {'1','1','0'};
		//char[] -> String
		String s = String.valueOf(ca); //110 캐릭터어레이를 스트링으로 ~~
		System.out.println(s);
		System.out.println(s+1); //붙이는 연산
		//String -> Long
		Long ss = Long.valueOf(s,2); //110
		System.out.println(ss);
		System.out.println(ss+1);
		
		System.out.println(s.split("")[0]); //스트링.split("")은 .toCharArray()

	}

}
