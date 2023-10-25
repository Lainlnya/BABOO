package BOJ_25511_값이k인트리노드의깊이;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	public static int N, K, root, check;
	public static ArrayList<Integer>[] tree;
	public static boolean visited[];

	static class Node {
		int num, depth;

		public Node(int num, int depth) {
			this.num = num;
			this.depth = depth;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 정점의 수
		N = sc.nextInt();
		// 부여된 값 k의 노드의 깊이 출력!
		K = sc.nextInt();

		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		// 간선 정보 -> 부모 정점 p, 자식 정점 c 순서대로 주어짐
		for (int i = 0; i < N - 1; i++) {
			// 부모 정점
			int p = sc.nextInt();
			// 자식 정점
			int c = sc.nextInt();

			// 부모 -> 자식 방향만 기록
			tree[p].add(c);
		}

		// 내가 찾아야 할 값이 저장되어 있는 정점의 번호 얻기
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();

			if (n == K)
				check = i;
		}

		// 각 정점의 방문 정보를 저장
		visited = new boolean[N];
		// 루트(0번 정점)에 저장된 값
		BFS(new Node(0, 0));
	} // main

	public static void BFS(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			// 현재 뽑은 정점의 번호가 내가 찾는 번호이면
			if (curr.num == check) {
				// 그 정점의 깊이를 반환하고 종료
				System.out.println(curr.depth);
				return;
			}

			for (int n : tree[curr.num]) {
				// 자식 노드들 중 방문 하지 않았으면
				if (!visited[n]) {
					// 방문하고
					visited[n] = true;
					// 깊이 갱신해서 큐에 추가
					queue.add(new Node(n, curr.depth + 1));
				}
			}
		}
	} // BFS
} // class
