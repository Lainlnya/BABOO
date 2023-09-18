package BOJ_6118_숨바꼭질;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// 최단 경로 구하는 느낌?
	public static int N, M, a, b;
	public static List<Integer>[] farm;
	public static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 헛간의 개수
		M = sc.nextInt(); // 양방향 길의 개수

		farm = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			farm[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			// 양방향 길 저장
			farm[a].add(b);
			farm[b].add(a);
		}

		visited = new int[N + 1];
		BFS(1); // 1번부터 찾기 시작!

		// 최대 거리 구하기
		int num = 0; // 숨어야 하는 헛간 번호
		int max = 0; // 그 헛간까지의 거리
		int cnt = 0; // 그 헛간과 같은 거리를 갖는 헛간의 개수

		for (int i = 2; i < N + 1; i++) {
			// 부등호 포함 안하면 num이 같은 거리들 중 최소값이 됨
			if (visited[i] > max) {
				cnt = 0; // 최대값 갱신할 때마다 개수 갱신
				num = i;
				max = visited[i];
			}
			if (visited[i] == max) {
				cnt++;
			}
		}

		System.out.println(num + " " + max + " " + cnt);

	} // main

	public static void BFS(int snode) {
		// BFS는 선입선출
		Queue<Integer> queue = new LinkedList<>();
		// 큐에 시작 노드1 삽입하고
		queue.add(snode);

		// 큐에 노드가 없을 때 까지 반복
		while (!queue.isEmpty()) {
			int nowNode = queue.poll();

			// 인접 노드 중 방문하지 않은 노드 방문 BFS
			for (int idx : farm[nowNode]) {
				// 아직 방문하지 않았고, 시작노드가 아니면
				if (visited[idx] == 0 && idx != snode) {
					// 그 노드를 방문할 때까지 거리 = 현재 노드 방문할 때까지 거리 + 1
					visited[idx] = visited[nowNode] + 1;
					queue.add(idx);
				}
			}
		}
	} // BFS
} // class
