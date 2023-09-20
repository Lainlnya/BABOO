package BOJ_24444_알고리즘수업_너비우선탐색1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, M, R, a, b, order;
	public static List<Integer>[] graph;
	public static boolean[] visited;
	public static int[] ans;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 정점의 개수
		M = sc.nextInt(); // 간선의 개수
		R = sc.nextInt(); // 시작 정점

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		} // 양방향 간선 정보 입력 끝!

		// 인접 정점을 오름차순 방문
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(graph[i]);
		}

		visited = new boolean[N + 1]; // 방문 정보 기록
		ans = new int[N + 1]; // 인덱스(정점) 방문순서 저장 배열
		order = 1; // 방문 순서
		BFS(R); // 시작정점 R부터 BFS 시작

		// 정답 출력
		for (int i = 1; i < N + 1; i++) {
			sb.append(ans[i] + "\n");
		}

		System.out.println(sb);

	} // main

	public static void BFS(int node) {
		// BFS 큐로 구현
		Queue<Integer> queue = new LinkedList<>();
		// 시작노드 방문 기록
		visited[R] = true;
		queue.add(R);

		while (!queue.isEmpty()) {
			int nowNode = queue.poll();
			ans[nowNode] = order++;

			// 인접한 노드 중 아직 방문 하지 않은 노드 방문
			for (int next : graph[nowNode]) {
				if (visited[next] == false) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
	} // BFS
} // class
