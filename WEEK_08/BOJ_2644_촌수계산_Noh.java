package BOJ_2644_촌수계산;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static int N, p1, p2, C;
	public static ArrayList<Integer>[] graph;
	public static boolean[] visited;
	public static int cnt = -1, ans = 0; // 촌수 계산 및 정답
	public static boolean possible = false; // 사촌 가능 여부

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 전체 사람의 수
		p1 = sc.nextInt(); // 사람1
		p2 = sc.nextInt(); // 사람2
		C = sc.nextInt(); // 관계의 개수

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		} // 각 사람에 대한 인접리스트 초기화

		for (int i = 0; i < C; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			graph[p].add(c);
			graph[c].add(p);
		} // 부모 자식 간의 관계 저장

		DFS(p2, 0);

		if (possible)
			System.out.println(ans);
		else
			System.out.println(-1);

	} // main

	// cnt는 탐색 깊이(횟수)
	public static void DFS(int node, int cnt) {
		visited[node] = true;
//		System.out.println(node + " : " + cnt);
		
		if (node == p1) { // node가 내가 검색할 사람과 같으면
			possible = true; // 친적 관계 가능
			ans = cnt; // 그 때의 탐색횟수가 촌수
		}

		// 인접 노드 중 방문하지 않은 노드 방문 (재귀)
		for (int idx : graph[node]) {
			if (visited[idx] == false) {
				DFS(idx, cnt + 1);
			}
		}
	} // DFS

} // class
