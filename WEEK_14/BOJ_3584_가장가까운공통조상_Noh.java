package BOJ_3584_가장가까운공통조상;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static int N, ans1, ans2, ans, a, b;
	public static int[] parent;
	public static Stack<Integer> aStack, bStack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트 케이스 개수
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 트리를 구성하는 노드의 수
			N = sc.nextInt();

			// 부모 정보 저장할 배열
			parent = new int[N + 1];

			// 간선정보(N-1개) 입력받기 (A 부모 -> B 자식)
			for (int i = 0; i < N - 1; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();

				// 내 부모가 누군지 저장!
				parent[c] = p;
			}
			// 가까운 공통 조상을 구할 두 노드
			a = sc.nextInt();
			b = sc.nextInt();

			// a 노드의 조상 전부 저장
			aStack = new Stack<>();
			// 내가 다른 노드의 조상이 될 수 있다는 것을 고려
			aStack.add(a);
			DFS(a, aStack);

			// b 노드의 조상 전부 저장
			bStack = new Stack<>();
			// 내가 다른 노드의 조상이 될 수 있다는 것을 고려
			bStack.add(b);
			DFS(b, bStack);

			search(aStack, bStack);
			System.out.println(ans);

		} // tc for문
	} // main

	public static void DFS(int n, Stack<Integer> stack) {
		// 부모 정보가 0이면 루트니까 긑
		if (parent[n] == 0)
			return;

		// 루트 만날때까지 내 조상 stack에 저장
		stack.add(parent[n]);
		DFS(parent[n], stack);
	} // DFS

	public static void search(Stack<Integer> aStack, Stack<Integer> bStack) {
		// 0으로 초기화해서 while문 안에 들어갈 수 있도록 설정
		int nowA = 0, nowB = 0;

		while (nowA == nowB) {
			// 같으면 공통조상이니까 ans에 저장
			ans = nowA;
			// 각 스택이 비어있지 않다면 서로 다른 조상이 나올 때 끝
			if (!aStack.isEmpty())
				nowA = aStack.pop();
			if (!bStack.isEmpty())
				nowB = bStack.pop();
		}

	} // search

} // class
