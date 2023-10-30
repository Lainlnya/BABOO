package BOJ_29160_나의FIFA팀가치는;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		@SuppressWarnings("unchecked")
		PriorityQueue<Integer>[] pq = new PriorityQueue[12];
		for (int i = 1; i <= 11; i++) {
			pq[i] = new PriorityQueue<>(Collections.reverseOrder());
		}
		
		int N = sc.nextInt(); // 선수의 수
		int K = sc.nextInt(); // 기간(년)
		
		for (int i = 0; i < N; i++) {
			pq[sc.nextInt()].offer(sc.nextInt());
		}
		
		int[] starting = new int[12];
		// 3월에 같은 포지션 중 선수 가치가 가장 높은 선수가 선발 선수가 된다.
		for (int j = 1; j <= 11; j++) {
			if (!pq[j].isEmpty() && starting[j] < pq[j].peek()) {
				pq[j].offer(starting[j]);
				starting[j] = pq[j].poll();
			}
		}
		for (int i = 1; i <= K; i++) {
			// 8월에 현재 팀에 있는 선발 선수의 선수 가치는 모두 1이 떨어진다.
			for (int j = 1; j <= 11; j++) {
				if (starting[j] > 0) {
					starting[j]--;
				}
			}
			// 11월에 2의 조건대로 선발 선수를 재구성한다.
			for (int j = 1; j <= 11; j++) {
				if (!pq[j].isEmpty() && starting[j] < pq[j].peek()) {
					pq[j].offer(starting[j]);
					starting[j] = pq[j].poll();
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= 11; i++) {
			ans +=starting[i];
		}
		System.out.println(ans);
		
		sc.close();
	}
}