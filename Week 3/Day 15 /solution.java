import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] p = new int[N+1];
		int[] c = new int[N+1];
		long ans = 0;
		
		for (int i = 1; i <= N; i++) {
			p[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		
		List<double[]> cost = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			cost.add(new double[]{(double) c[i] / p[i], (double) p[i]});
		}
		Collections.sort(cost, (a, b) -> Double.compare(b[0], a[0]) != 0 ?
																		Double.compare(b[0], a[0]) :
																		Double.compare(b[1], a[1]));
		
		for (int i = 0; i < N; i++) {
			double[] pair = cost.get(i);
			double value = pair[0];
			double amount = pair[1];
			double buy = Math.min(amount, K);
			K -= buy;
			ans += value * buy;
		}
		System.out.println((long) Math.floor(ans));
	}
}
