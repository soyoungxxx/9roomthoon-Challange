import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		// 노드의 개수, 간선의 개수, 시작 노드 번호
		
		int[][] edges = new int[M][2];
		
		for (int i = 0; i < M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}
		// 간선 저장하는 배열 edges
		
		Arrays.sort(edges, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		// 오름차순 정렬
		
		boolean[] visited = new boolean[N+1];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}
		// 방문 여부 저장할 배열 + 그래프 구현

		Queue<Integer> queue = new LinkedList<>();
		int idx = K;
		int count = 0;
		
		queue.add(K);
		while (!queue.isEmpty()) {
			idx = queue.poll();
			count += 1;
			visited[idx] = true;
			
			List<Integer> tempNodes = graph.get(idx);
			if (tempNodes != null && !tempNodes.isEmpty()) {
				Collections.sort(tempNodes);
				for (int nextNode : tempNodes) {
					if (visited[nextNode] == false) {
						queue.add(nextNode);
						break;
					}
				}
			}
		}
		
		System.out.printf("%d %d\n", count, idx);
	}
}
