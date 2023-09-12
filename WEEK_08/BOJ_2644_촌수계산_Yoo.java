package boj_촌수;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> list;
	static int answer = -1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 전체 사람 수
		int n = sc.nextInt();

		// 촌수 계산해야하는 사람 a <-> b 몇촌일까요
		int a = sc.nextInt();
		int b = sc.nextInt();

		// 부모 자식 관계수 -> 반복 돌 int
		int m = sc.nextInt();

		list = new ArrayList<>();
		visited = new boolean[n + 1];

		// 인접 리스트
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		// x , y x는 y의 부모번호
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 양방향 인접 리스트
			list.get(x).add(y);
			list.get(y).add(x);

		}

		dfs(a, b, 0);
		System.out.println(answer);

	}

	static void dfs(int start, int end, int count) {
		visited[start] = true;

		for (int i : list.get(start)) {
			if (!visited[i]) {
				if (i == end) {
					answer = count + 1;
					return;
				}

				// 시작점 바꾸고 카운트 +1
				dfs(i, end, count + 1);
			}
		}
	}
}

/*
 * 1: [2,3] 2: [1,7,8,9] 3: [1] 4: [5,6] 5: [4] 6: [4] 7: [2] 8: [2] 9: [2]
 * 
 * 7 --> 정점 2 발견 , dfs (2, 3, 1) 호출 -> dfs(1, 3, 2) 호출 -> 목표발견 끝
 */
