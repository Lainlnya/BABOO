package BOJ_14235_크리스마스선물;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int n, cnt;
	// 가진 선물 중 가장 가치가 큰 선물을 선물해주므로 우선순위큐 사용
	public static PriorityQueue<Integer> pq;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 높은 숫자가 우선이 되도록 Collections.reverseOrder()
		pq = new PriorityQueue<>(Collections.reverseOrder());

		// 아이들과 거점지를 방문한 횟수
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			// 0이면 아이들 만나서 선물 준 것, 아니면 거점지에서 action개의 선물 충전
			cnt = sc.nextInt();
			if (cnt == 0) {
				// 큐가 비어 있으면 선물이 없으므로 -1출력
				if (pq.isEmpty()) {
					System.out.println(-1);
				} else {
					// 아이들에게 준 선물의 가치 출력
					int value = pq.poll();
					System.out.println(value);
				}
			}
			// 거점지에 방문했다면
			else {
				// cnt에는 충전한 선물의 개수
				for (int j = 0; j < cnt; j++) {
					// 충전하는 선물의 가치
					int value = sc.nextInt();
					pq.add(value);
				}
			}
		}

	} // main
} // class
