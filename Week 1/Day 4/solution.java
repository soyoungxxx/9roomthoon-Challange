import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 0, maxidx = 0;
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum += num[i];
			if (num[i] > max) {
				max = num[i];
				maxidx = i;
			}
		}
		
		int down = maxidx - 1, up = maxidx + 1;
		int downmax = maxidx, upmax = maxidx;
		int flag = 0;
		
		while (down >= 0 || up < N) {
			if (down >= 0) { // 아래로 내려가면서 비교
				if (num[downmax--] >= num[down--]) continue;
				else {
					flag = 1;
					break;
				}
			}
			if (up < N) { // 위로 올라가면서 비교
				if (num[upmax++] >= num[up++]) continue;
				else {
					flag = 1;
					break;
				}
			}
		}
		if (flag == 0) System.out.println(sum);
		else System.out.println("0");
	}
}
