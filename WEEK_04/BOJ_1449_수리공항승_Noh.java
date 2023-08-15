package Silver;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_S3_1449_수리공항승 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 물이 새는 곳 개수
		int N = sc.nextInt();
		// 테이프 길이
		int L = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		// 정렬하기!
		Arrays.sort(arr);

		// 출력할 정답 : 필요한 테이프 개수!
		int ans = 1;
		// 1개의 테이프로 커버 가능한 범위
		double tape = arr[0] - 0.5 + L;

		for (int i = 1; i < N; i++) {
			// 다음 물이 새는 곳이 테이프로 커버 가능한 범위 넘어가면
			if (tape < arr[i] + 0.5) {
				// 새로운 테이프 붙이고
				ans++;
				// 새로운 테이프로 커버 가능한 범위 저장
				tape = arr[i] - 0.5 + L;
			}
		}
		System.out.println(ans);
	}
}
