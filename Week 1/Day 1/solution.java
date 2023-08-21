import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		double res = (double)w * (1 + ((double)r / 30));
		System.out.println((int)res);
	}
}
