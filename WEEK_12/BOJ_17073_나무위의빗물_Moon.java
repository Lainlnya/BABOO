package BOJ_17073_나무위의빗물;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	static List<Integer>[] list;
	static int[] parents, childNum;
	static boolean[] visited;
	static Stack<Integer> stack = new Stack<>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 트리의 노드 수
		int W = sc.nextInt(); // 1번 노드에 고인 물의 양
		
		// 연결 리스트 받아오기
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			int U = sc.nextInt();
			int V = sc.nextInt();
			list[U].add(V);
			list[V].add(U);
		}

		/*
		 * 빗물은 결국 자식 노드가 없는 노드까지 내려가야 움직이지 않는 상태가 된다.
		 * 따라서 리프 노드의 수를 구해, 처음 빗물의 양을 리프 노드의 수로 나누어준다.
		 */

		// 각 노드의 부모 노드를 기록할 배열
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		// DFS 순회하는 동안 방문 여부를 기록할 배열
		visited = new boolean[N+1];
		
		stack.push(1);
		visited[1] = true;
		DFS();
		
		// 부모 노드의 배열에 기록된 횟수만큼 자식 노드를 가지고 있다는 뜻
		int cnt = 0;
		childNum = new int[N+1];
		for (int i = 1; i <= N; i++) {
			childNum[parents[i]]++;
		}
		
		// 자식 노드의 수가 0인 노드의 수를 세어줌.
		for (int i = 1; i <= N; i++) {
			if (childNum[i] == 0) {
				cnt++;
			}
		}
		
		// 처음 빗물의 양을 리프 노드(자식 노드의 수가 0인 노드)의 수로 나누어 준다.
		System.out.println((double)W/cnt);
		
		sc.close();
	}
	
	// 트리를 DFS 순회하며 각 노드의 부모 노드를 기록하는 method
	public static void DFS() {
		while (!stack.isEmpty()) {
			int node = stack.pop();
			for (int i = 0; i < list[node].size(); i++) {
				if (!visited[list[node].get(i)]) {
					stack.push(list[node].get(i));
					visited[list[node].get(i)] = true;
					parents[list[node].get(i)] = node;
				}
			}
		}
	}
}
