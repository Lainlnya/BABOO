package BOJ_2470_두용액;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 투포인터 -> 가능성이 없는 것을 버리는 알고리즘
		// 주어진 용액들을 혼합했을 때, 그 혼합용액의 특성값이 0에 가장 가깝도록 만드는 두 용액
		// 오름차순 출력, 두 개 이상이면 아무거나 하나 출력

		// 전체 용액의 수
		int N = sc.nextInt();
		// N개의 용액의 특성값 저장(오름차순으로 입력됨)
		int[] sol = new int[N];
		for (int i = 0; i < N; i++) {
			sol[i] = sc.nextInt();
		}

		Arrays.sort(sol);
		// 왼쪽에서 시작하는 포인터, 오른쪽에서 시작하는 포인터
		int start = 0, end = N - 1;
		// 정답으로 출력할 두 용액
		int ans1 = 0, ans2 = 0;

		// 정답으로 저장한 두 용액의 0과의 차이, 최대값으로 초기화
		int min = Integer.MAX_VALUE;

		// 두 포인터가 가리키는 곳이 같아지면 종료
		while (start < end) {
//			System.out.println(start + " " + end); // 포인터 변화모습 디버깅

			// 두 포인터가 가리키는 용액의 특성값을 더했을 때
			int tmp = sol[start] + sol[end];
			// 0에 가까워야 하니까 절댓값 계산
			int sum = Math.abs(tmp);
			// 지금 만들어져있는 최소 혼합 용액보다 작으면
			if (sum < min) {
				// 갱신하고
				min = sum;
				// ans1, ans2에 저장
				ans1 = sol[start];
				ans2 = sol[end];
			}

			// 두 용액의 특성값이 양수이면 end포인터 감소
			if (tmp > 0)
				end--;
			// 음수 이면 start포인터 증가
			else
				start++;

		}
		// 결과 출력
		System.out.println(ans1 + " " + ans2);

	} // main
} // class
