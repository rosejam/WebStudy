import java.sql.Time;
import java.util.HashSet;

public class Test {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		HashSet<Long> VV = new HashSet<>();
		for(long i=0; i<(long) Integer.MAX_VALUE*2; i++) {
			VV.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
