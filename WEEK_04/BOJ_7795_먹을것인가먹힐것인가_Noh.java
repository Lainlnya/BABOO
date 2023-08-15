package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S3_7795_먹을것인가먹힐것인가 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 테스트케이스 개수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// A의 수
			int N = sc.nextInt();
			// B의 수
			int M = sc.nextInt();

			int[] A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			int[] B = new int[M];
			for (int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			Arrays.sort(A);
			Arrays.sort(B);

			// A가 B보다 큰 쌍의 개수
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// A[i]가 B[j]보다 작으면 그 뒤는 비교할 필요 없음
					if (A[i] <= B[j]) {
						break;
					} else
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
