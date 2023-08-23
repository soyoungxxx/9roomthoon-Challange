import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cnt = 0;
		
		int gameBoard[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) gameBoard[i][j] = sc.nextInt();
		}
		
		int d[] = {1, 0, -1, 0, 1, 1, -1, -1, 1};
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (gameBoard[x][y] == 1) continue;
				int sum = 0;
				for (int k = 0; k < 8; k++) {
					int nx = x + d[k], ny = y + d[k+1];
					if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if (gameBoard[nx][ny] == 1) sum += 1;
				}
				if (sum == K) cnt += 1;
			}
		}
		System.out.println(cnt);
	}
}
