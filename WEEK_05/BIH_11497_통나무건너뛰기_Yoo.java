package BOJ_11497_통나무;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// TestCase 입력받기
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			//단계 크기순 정렬!
			Arrays.sort(arr);

			//난이도 변수
			int level = 0;
			
			//작은거 처음 끝 가운데로 몰리는 과정으로 배치했음 => 처음끝 이어진거 생각배제 !
			
			/* 짝수일때 생각해보자 N =6 라면 
			[0][2][4] [5][3][1] 배치할 필요없이 생각 구현
			0하고 1 고려 할 필요없이 1차원 배열만 생각
			1. 처음 왼쪽 0 2 4 짝수 배열 값 비교해서 차이값 max 찾기
			2. 그 다음 4하고 5 미리 비교하고 가기 (제일 뒤에 두개 비교)	
			3. 오른쪽 똑같이 1 3 5 홀수 배열 값 비교해서 max 최신화
			*/
			if (N % 2 == 0) {
				//1번과정 왼쪽 짝수배열 비교 0-2 2-4 4-6
				for (int i = 1; i < N / 2; i++) {
					int hoxy = arr[2 * i] - arr[2 * (i - 1)];
					if (hoxy > level) {
						level = hoxy;
					}
				}
				//2번과정
				if (arr[N - 1] - arr[N - 2] > level) {
					level = arr[N - 1] - arr[N - 2];
				}
				//3번과정 오른쪽 홀수배열 비교 1-3 3-5 5-7
				for (int i = 1; i < N / 2; i++) {
					int hoxy1 =arr[2 * i + 1] - arr[2 * (i - 1) + 1];
					if (hoxy1 > level) {
						level = hoxy1;
					}
				}
				System.out.println(level);
			}
			/* 홀수일때 생각해보자 N =7 라면 
			[0][2][4] [6] [5][3][1] 배치할 필요없이 생각 구현
			0하고 1 고려 할 필요없이 1차원 배열만 생각
			1. 처음 왼쪽 0 2 4 6 짝수 배열 값 비교해서 차이값 max 찾기
			2. 그다음 오른쪽 1 3 5 홀수배열 비교 해서 max 값 최신화
			3. 그다음 5하고 6 가장 제일 뒤에 두개 비교해서 최신화
			*/
			else {
				for (int i = 1; i < N / 2 + 1; i++) {
					int hoxy2 = arr[2 * i] - arr[2 * (i - 1)];
					if (hoxy2 > level) {
						level = hoxy2;
					}
				}
				for (int i = 1; i < N / 2; i++) {
					int hoxy3 = arr[2 * i + 1] - arr[2 * (i - 1) + 1];
					if (hoxy3 > level) {
						level = hoxy3;
					}
				}
				if (arr[N - 1] - arr[N - 2] > level) {
					level = arr[N - 1] - arr[N - 2];
				}
				System.out.println(level);
			}
		}

	}
}
