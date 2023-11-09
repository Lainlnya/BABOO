package BOJ_8012_한동이는영업사원;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	@SuppressWarnings("rawtypes")
	static ArrayList[] list;
	static int[] parents, depth;
	static boolean[] visited;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 도시의 개수
				
		// 인접 리스트
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<>();
		
		for (int i = 0; i < N-1; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			list[A].add(B);
			list[B].add(A);
		}
		
		// 부모 정보 기록
		parents = new int[N+1]; // 각 노드의 부모 정보
		depth = new int[N+1]; // 각 노드의 깊이
		visited = new boolean[N+1]; // DFS 중 방문 여부
		visited[1] = true;
		findParents(1); // 루트 노드에서부터 시작
		
		// 돌아보자
		int M = sc.nextInt(); // 돌아야 할 도시의 수
		int answer = 0;
		
		int end = sc.nextInt();
		for (int i = 0; i < M-1; i++) {
			int start = end; // 출발 도시(이전 시행에서의 도착 도시)
			end = sc.nextInt(); // 도착 도시
			
			answer +=LCA(start, end);
		}
		
		System.out.println(answer);
		sc.close();
	} // main
	
	public static int LCA(int a, int b) {
		// 초기화
		int dist = 0;
		
		while (a != b) {
			if (depth[a] > depth[b]) {
				a = parents[a];
				dist++;
			} else if (depth[a] < depth[b]) {
				b = parents[b];
				dist++;
			} else {
				// 깊이가 같은데 아직 같은 노드가 아니면 만날 때까지 올라가보자
				a = parents[a];
				b = parents[b];
				dist +=2;
			}			
		}
		
		return dist;
	}
	
	public static void findParents(int node) {
		for (int i = 0; i < list[node].size(); i++) {
			int nextNode = (int) list[node].get(i);
			if (!visited[nextNode]) {
				visited[nextNode] = true;
				parents[nextNode] = node;
				depth[nextNode] = depth[node] + 1;
				findParents(nextNode);
			}
		}
	} // findParents
}