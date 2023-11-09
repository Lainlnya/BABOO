package jajaja;

import java.util.Scanner;

public class BOJ_11812_K진트리_Yoo {

	static int K, Q;
	static long N, ans;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Node
		N = sc.nextLong();
		// 층 수
		K = sc.nextInt();
		// 노드 쌍개수
		Q = sc.nextInt();

		// 부모노드 구하는 공식
		// P = (N-2) /K+1

		for (int i = 0; i < Q; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();

			ans = 0;

			// 자식 무조건 한명일때는 직선 거리 구하면 돼!
			// math.abs 하니까 시간초과 뜸!
			if (K == 1) {
				if (x < y) {
					ans = y - x;
				} else {
					ans = x - y;
				}
			}

			else {

				// x와 y가 같아지는 순간까지
				while (x != y) {
					// 부모로 가는 프로젝트!
					if (x < y) {
						y = (y - 2) / K + 1;
					}

					else {
						x = (x - 2) / K + 1;
					}
					// 트라이 수 추가 ( 거리)
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
