import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(br.readLine());
			M = M + c;
			while (M >= 60) {
				M -= 60;
				T += 1;
				if (T == 24) T = 0;
			}
		}
		System.out.printf("%d %d\n", T, M);
	}
}
