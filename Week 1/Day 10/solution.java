import java.io.*;
import java.util.*;

class commandCount {
	boolean[] visited = new boolean[2];
	int num;
	String command;
	
	public commandCount() {
		Arrays.fill(visited, false);
	}
}

class Main {
	public static int checkScore(commandCount[][] count, int y, int x, int N, int who) {
		int cnt = 1; // return 해줄 값
		count[y][x].visited[who] = true; // 첫 번째 요소에 check
		
		while(true) {
			int dx = 0, dy = 0;
			if (count[y][x].command.equals("L")) dx = -1;
			else if (count[y][x].command.equals("R")) dx = 1;
			else if (count[y][x].command.equals("U")) dy = -1;
			else if (count[y][x].command.equals("D")) dy = 1;
			// dy dx 값 설정
			
			int num = count[y][x].num;
			// x, y가 계속 바뀌기 때문에 변수에 값 저장
			
			for (int i = 0; i < num; i++) {
				x += dx; y += dy;
				
				if (x < 0) x = N - 1;
				else if (x >= N) x = 0;
				
				if (y < 0) y = N -1;
				else if (y >= N) y = 0;
				
				if (count[y][x].visited[who] == true) {
					return cnt;
				}
				count[y][x].visited[who] = true;
				cnt += 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int gy = sc.nextInt() - 1, gx = sc.nextInt() - 1;
		int py = sc.nextInt() - 1, px = sc.nextInt() - 1;
		commandCount[][] count = new commandCount[N][N];
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count[i][j] = new commandCount();
				String input = sc.next();
				int l = input.length();
				count[i][j].num = Integer.parseInt(input.substring(0, l - 1));
				count[i][j].command = input.substring(l - 1, l);
			}
		}
		
		int gScore = checkScore(count, gy, gx, N, 0);
		int pScore = checkScore(count, py, px, N, 1);
		
		if (gScore > pScore) System.out.printf("goorm %d\n", gScore);
		else System.out.printf("player %d\n", pScore);
	}
}
