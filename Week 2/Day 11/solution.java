import java.io.*;
import java.util.*;

class Main {
	public static int divide(int N, int num) {
		if (N % num == 0) return N / num;
		else return -1;
	}
	public static int minItem(int N, int A, int B) {
		int divA, divB, divAB;
		int min = -1;
		
		divA = divide(N, A);
		divB = divide(N, B);
		
		if (divA == -1) min = divB;
		else if (divB == -1) min = divA;
		else min = (divA < divB) ? divA : divB;
		
		int cpyN = N / B * B;
		int cnt = N / B;
		while(true) {
			if ((N - cpyN) % A == 0) {
				cnt += (N - cpyN) / A;
				break;
			}

			cpyN -= B;
			cnt -= 1;
			
			if (cpyN < 0) break;
		}
		
		if (cnt == -1) return min;
		else if (min == -1) return cnt;
		else min = (min < cnt) ? min : cnt;
		return min;
		
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int min = -1;
		
		min = minItem(N, A, B);
		System.out.println(min);
	}
}
