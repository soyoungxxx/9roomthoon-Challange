import java.io.*;
import java.util.*;

class Bomb {
	String state;
	int value;
	public Bomb() {
		value = 0;
	}
	public void findValue() {
		if (state.equals("0")) value += 1;
		else if (state.equals("@")) value += 2;
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Bomb b[][] = new Bomb[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				b[i][j] = new Bomb();
				b[i][j].state = sc.next();
			}
		}
		
		int d[] = {0, -1, 0, 1, 0, 0};
		int max = 0;
		for (int i = 0; i < K; i++) {
			int y = sc.nextInt() - 1;
			int x = sc.nextInt() - 1;
			
			for (int j = 0; j < 5; j++) {
				int dy = y + d[j];
				int dx = x + d[j+1];
				if (dy < 0 || dy >= N || dx < 0 || dx >= N) continue;
				b[dy][dx].findValue();
				if (b[dy][dx].value > max) max = b[dy][dx].value;
			}
		}
		
		System.out.println(max);
	}
}
