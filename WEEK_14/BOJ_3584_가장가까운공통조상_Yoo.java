package jajaja;

import java.util.Scanner;

public class BOJ_3584_가장가까운공통조상_Yoo {

	static int[] parent;
	static boolean[] visited;
	static int T, N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//testcase 입력
		T = sc.nextInt();

		// Testcase 반복문
		for (int tc = 0; tc < T; tc++) {

			// Node의 개수 입력
			N = sc.nextInt();

			//부모 배열, 방문 배열 생성
			parent = new int[N + 1];
			visited = new boolean[N + 1];

			for (int i = 0; i < N - 1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				// a가 b의 부모 노드(해당 인덱스의 부모)
				parent[b] = a;
			}

			// 마지막에 찾아야할 두 노드 주어진다!
			int f1 = sc.nextInt();
			int f2 = sc.nextInt();

			//huh 메소드 실행!
			huh(f1, f2);
		}
	}

	public static void huh(int A, int B) {

		// 한놈 부터 끝까지 탐색
		// 방문처리하고, A를 A의 부모로 설정해서 반복
		while (A > 0) {
			visited[A] = true;
			A = parent[A];
		}

		// 다른놈 탐색하다가 visited 만나면 그것이 답!
		while (B > 0) {
			if (visited[B] == true) {
				System.out.println(B);
				break;
			}
			B = parent[B];
		}

	}
}