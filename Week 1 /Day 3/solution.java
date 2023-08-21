import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int sum = 0;
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String oper = st.nextToken();
			int b = Integer.parseInt(st.nextToken());
			
			if (oper.equals("+")) sum += a + b;
			else if (oper.equals("-")) sum += a - b;
			else if (oper.equals("*")) sum += a * b;
			else sum += a / b;
		}
		
		System.out.println(sum);
	}
}
