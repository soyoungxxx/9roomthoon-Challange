import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int bandage = 1, medicine = 7, painkiller = 14;
		int cnt = 0;
		
		while (N != 0) {
			cnt += 1;
			N -= painkiller;
			if (N < 0) N += painkiller;
			else continue;
			N -= medicine;
			if (N < 0) N += medicine;
			else continue;
			N -= bandage;
		}
		
		System.out.println(cnt);
	}
}
