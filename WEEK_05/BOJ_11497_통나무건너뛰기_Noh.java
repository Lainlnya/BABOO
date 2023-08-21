package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11497_통나무건너뛰기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 통나무 개수
			int[] log = new int[N]; // 각 통나무의 높이 저장

			int max = 0;
			for (int i = 0; i < N; i++) {
				log[i] = sc.nextInt();
			} // 입력받기 끝!

			// 정규분포 모양으로 높이 저장할 배열
			int[] norm = new int[N];

//			버블 정렬 시도했으나 시간초과 ^^ ,, Arrays.sort 사용하니 바로 해결
//			for (int i = 0; i < N - 1; i++) {
//				for (int j = i; j < N; j++) {
//					if (log[i] > log[j]) {
//						int tmp = log[j];
//						log[j] = log[i];
//						log[i] = tmp;
//					}
//				}
//			}
			Arrays.sort(log);

			// N이 홀수
			if (N % 2 == 1) {
				int mid = N / 2;
				// 가운데 값 가장 높은 통나무
				norm[mid] = log[N - 1];
				int idx = 0;
				// 작은 값을 배열 왼쪽 끝 -> 오른쪽 끝 순서로 채움
				for (int i = 0; i < mid; i++) {
					norm[i] = log[idx++];
					norm[(N - 1) - i] = log[idx++];
				}
			}

			// N이 짝수
			if (N % 2 == 0) {
				int mid = N / 2;
				norm[mid] = log[N - 1];
				int idx = 0;
				// 작은 값을 배열 왼쪽 끝 -> 오른쪽 끝 순서로 채움
				for (int i = 0; i < mid; i++) {
					if (idx <= N) {
						norm[i] = log[idx++];
						norm[(N - 1) - i] = log[idx++];
					}
				}
			}

			// 난이도 구하기
			// 원형으로 생각하면 첫 번쨰 원소와 마지막 원소도 인접
			int difficulty = Math.abs(norm[N - 1] - norm[0]);

			for (int i = 0; i < N - 1; i++) {
				if (Math.abs(norm[i] - norm[i + 1]) > difficulty)
					difficulty = Math.abs(norm[i] - norm[i + 1]);
			}

			System.out.println(difficulty);

		} // 테스트 케이스 for문
	} // main
} // class
