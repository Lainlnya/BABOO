package BOJ_1068_트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
	public static int N, root, deleteNum, ans;
	public static ArrayList<Integer>[] tree;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 노드의 개수 (50보다 작거나 같은 자연수)
		N = sc.nextInt();

		tree = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			int parent = sc.nextInt();
			// 부모가 -1이라면 루트
			if (parent == -1)
				root = i;
			else {
				tree[parent].add(i);
			}
		} // 트리 정보 저장

		// 노드 방문 정보 저장
		visited = new boolean[N];

		// 지울 노드의 번호
		deleteNum = sc.nextInt();

		// root가 지울 노드의 번호면 리프노드는 없음
		if (root == deleteNum)
			System.out.println(0);
		else {
			DFS(root);
			System.out.println(ans);
		}

	}// main

	public static void DFS(int num) {
		visited[num] = true;
		// 자식 노드의 개수
		int childCnt = 0;

		for (int n : tree[num]) {
			// 자식 노드 중 아직 방문 안했고, 삭제 할 노드가 아니라면
			if (!visited[n] && n != deleteNum) {
				// 자식 노드의 개수 증가 시키고
				childCnt++;
				// 탐색
				DFS(n);
			}
		}
		// 자식 노드가 없으면 -> 리프노드임!
		if (childCnt == 0)
			ans++;
	} // DFS

} // class
