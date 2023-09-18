package BOJ_2644_촌수계산;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static Stack<Integer> stack = new Stack<>();
	static boolean[] visited;
	static int P;
	static ArrayList<Integer>[] rel;
	static StringBuilder sb = new StringBuilder();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		P = sc.nextInt(); // 사람 수
		int p1 = sc.nextInt()-1;
		int p2 = sc.nextInt()-1;
		int R = sc.nextInt(); // 연결 수
		rel = new ArrayList[P];
		for (int i = 0; i < P; i++) rel[i] = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			rel[a].add(b);
			rel[b].add(a);
		}
		
		visited = new boolean[P];
		visited[p1] = true;
		
		DFS(p1, p2, 0);
		if (sb.length() == 0) System.out.println(-1);
		else System.out.println(sb);

		sc.close();
	}
	
	public static void DFS(int start, int end, int depth) {
		if (start == end) {
			sb.append(depth);
			return;
		}
		
		for (int i = 0; i < rel[start].size(); i++) {
			if (visited[rel[start].get(i)] == false) {
				visited[rel[start].get(i)] = true;
				DFS(rel[start].get(i), end, depth+1);
			}
		}
	}
}