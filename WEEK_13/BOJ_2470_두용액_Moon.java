package BOJ_2470_두용액;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 전체 용액의 수
		int[] potion = new int[N]; // 용액의 특성값
		for (int i = 0; i < N; i++) {
			potion[i] = sc.nextInt();
		}
		// 2467번 문제와 다르게 무작위 순서로 주어지므로 오름차순 정렬해준다.
		Arrays.sort(potion);
		
		// two pointer
		int p1 = 0;
		int p2 = N-1;
		
		// 0에 가장 가까워지는 때를 기록해둔다.
		int close = Math.abs(potion[p1] + potion[p2]);
		int[] ans = { p1, p2 };
		
		// 탐색 과정
		while (p1 < p2) {
			if (potion[p1]+potion[p2] < 0) {
				// 특성값의 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로 한 칸 이동
				p1++;
			} else {
				// 반대로 특성값의 합이 0보다 크면 오른쪽 포인터를 왼쪽으로 한 칸 이동
				p2--;
			}
			
			if (potion[p1] + potion[p2] == 0) {
				// 만약 특성값의 합이 0이면 기록
				// 탐색 종료
				close = 0;
				ans[0] = p1;
				ans[1] = p2;
				break;
			} else if (p1 != p2 && Math.abs(potion[p1] + potion[p2]) < close) {
				// 특성값의 합이 0은 아니지만 현재까지 찾은 특성값 합보다 0에 가깝다면 기록
				// 계속 탐색
				close = Math.abs(potion[p1] + potion[p2]);
				ans[0] = p1;
				ans[1] = p2;
			}
		}
		
		// 출력
		System.out.print(potion[ans[0]]+" "+potion[ans[1]]);
		
		sc.close();
	}
}