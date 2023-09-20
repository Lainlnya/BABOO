package BOJ_24444_알고리즘수업너비우선탐색1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static boolean[] visited;
	static ArrayList<Integer>[] link;
	static Queue<Integer> queue = new LinkedList<>();
	static int cnt = 0; // 임의의 정점에 방문할 때 마다 ++해줄 integer
	static int[] order;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 정점의 수
		int M = sc.nextInt(); // 간선의 수
		int R = sc.nextInt()-1; // 시작 정점
		
		link = new ArrayList[N];
		for (int i = 0; i < N; i++) link[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			link[a].add(b);
			link[b].add(a);
		}
		for (int i = 0; i < N; i++) Collections.sort(link[i]);
		
		visited = new boolean[N];
		order = new int[N]; // 방문 순서를 저장해 줄 배열
		visited[R] = true; // 시작 정점 방문처리 하고 시작
		order[R] = ++cnt; // 각 정점에 방문할 때마다 ++
		BFS(R); // BFS while문 파트로 들어간다
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) sb.append(order[i]).append("\n");
		System.out.println(sb);
		
		sc.close();
	}
	
	public static void BFS(int now) {

		for (int i = 0; i < link[now].size(); i++) {
			if (!visited[link[now].get(i)]) {
				queue.add(link[now].get(i));
				visited[link[now].get(i)] = true;
				order[link[now].get(i)] = ++cnt;
			}
		}
		
		if (!queue.isEmpty()) BFS(queue.poll()); // while문 처럼 작동한다.
		else return;
		
	}
}