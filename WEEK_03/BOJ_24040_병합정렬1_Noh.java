package WEEK_03;

import java.util.Scanner;

public class BOJ_24040_병합정렬1_Noh {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt(); // 배열 크기
	static int K = sc.nextInt(); // 저장 횟수 비교할 값

	static int[] tmp;
	static int cnt; // 저장 횟수
	static int ans; // K번째 저장되는 값

	// arr[p-r] 오름차순 정렬
	public static void merge_sort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			merge_sort(arr, start, mid); // 전반부 정렬
			merge_sort(arr, mid + 1, end); // 후반부 정렬
			merge(arr, start, mid, end); // 병합
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = end;
		int t = 0;
		while (i <= mid && j <= k) {
			if (arr[i] <= arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}

		// 왼쪽 배열 부분이 남은 경우
		while (i <= mid) {
			tmp[t++] = arr[i++];
		}

		// 오른쪽 배열 부분이 남은 경우
		while (j <= k) {
			tmp[t++] = arr[j++];
		}
		// 결과를 arr에 저장
		i = start;
		t = 0;
		while (i <= end) {
			cnt++;
			if (cnt == K) {
				ans = tmp[t];
			}
			arr[i++] = tmp[t++];
		}
	}

	public static void main(String[] args) {

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} // 처음 배열 저장

		tmp = new int[N];

		cnt = 0;
		merge_sort(arr, 0, N - 1);
		if (cnt < K) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}