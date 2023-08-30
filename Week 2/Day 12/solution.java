import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] house = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				house[i][j] = sc.nextInt();
				visited[i][j] = false;
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (house[i][j] == 1 && visited[i][j] == false) {
					visited[i][j] = true;
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[]{i, j});
					
					while(!queue.isEmpty()) {
						int[] current = queue.poll();
						
						for (int d = 0; d < 4; d++) {
							int y = current[0] + dy[d];
							int x = current[1] + dx[d];
							if (y < 0 || y >= N || x < 0 || x >= N) continue;
							if (house[y][x] == 1 && visited[y][x] == false) {
								visited[y][x] = true;
								queue.add(new int[]{y, x});
							}
						}
					}
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
