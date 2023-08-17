package BOJ_1449_수리공항승;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 물새는 곳 개수
		int N = sc.nextInt();

		// 테이프 길이 무한개있음!
		int L = sc.nextInt();

		int[] arr = new int[N];
		// 좌우간격 0.5 일단 생각

		// 입력받으시오
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		// 처음 테이프 붙이고 시작
		int cnt = 1;
		// 첫 시작점 고정
		int A = arr[0];

		for (int i = 1; i < N; i++) {
			// 있는 테이프 그냥 쓰기
			if (arr[i] < A + L)
				continue;
			// 테이프 한개 추가하고 시작지점 교체
			else {
				cnt++;
				A = arr[i];
			}
		}

		System.out.println(cnt);
	}// 메인문
}
