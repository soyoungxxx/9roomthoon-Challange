import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] house = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int[] score = new int[32];
		// count[0][i] => i+1번을 가진 건물의 총 개수
		// count[0][i] => i+1번을 가진 건물 단지의 총 개수
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				house[i][j] = sc.nextInt();
				visited[i][j] = false;
			}
		}
		
		int[] dy = {0, -1, 0, 1};
		int[] dx = {-1, 0, 1, 0};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == false && house[i][j] != 0) {
					visited[i][j] = true;
					Queue<int []> queue = new LinkedList<>();
					queue.add(new int[]{i, j});
					
					int cnt = 1;
					int M = house[i][j];
					
					while(!queue.isEmpty()) {
						int[] current = queue.poll();
						
						for (int d = 0; d < 4; d++) {
							int y = current[0] + dy[d];
							int x = current[1] + dx[d];
							if (y < 0 || y >= N || x < 0 || x >= N) continue;
							if (visited[y][x] == false && house[y][x] == M) {
								visited[y][x] = true;
								cnt += 1;
								queue.add(new int[]{y, x});
							}
						}
					}
					if (cnt >= K) score[M]++;
				}
			}
		}
		int maxIndex = 0;
		for (int i = 31; i > -1; i--) {
			if (score[i] > score[maxIndex]) maxIndex = i;
		}
		System.out.println(maxIndex);
	}
}
