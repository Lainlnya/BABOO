package BOJ_14235_크리스마스선물;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = sc.nextInt(); // 방문 횟수
		for (int i = 0; i < N; i++) {
			int A = sc.nextInt();
			if (A == 0) {
				// A가 0이면 가진 선물 중 가치가 가장 큰 선물부터 나눠준다.
				// 따라서 PriorityQueue(역순)를 사용한다.
				if (pq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				// 0이 아니면 거점지에서 A개의 선물을 충전한다.
				for (int j = 0; j < A; j++) {
					pq.offer(sc.nextInt());
				}
			}
		}
		
		sc.close();
	}
}