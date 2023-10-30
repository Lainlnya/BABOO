package BOJ_28107_회전초밥;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 손님의 수
		int M = sc.nextInt(); // 초밥의 수
		
		// 초밥을 먹고 싶은 손님의 리스트
		@SuppressWarnings("unchecked")
		PriorityQueue<Integer>[] pq = new PriorityQueue[200001];
		for (int i = 1; i <= 200000; i++) {
			pq[i] = new PriorityQueue<>();
		}
		
		// 손님들마다 먹고 싶은 초밥 말하기
		// 초밥에 먹고싶은 손님 리스트를 달아놓고
		// 초밥이 나올 때 마다 가장 앞번호의 손님을 pq에서 뽑아내어 초밥을 배분할 것.
		for (int i = 1; i <= N; i++) {
			int A = sc.nextInt(); // 먹고 싶은 초밥의 개수
			for (int j = 0; j < A; j++) {
				int sushi = sc.nextInt();
				pq[sushi].offer(i);
			}
		}
		
		// 초밥 배분
		int[] ans = new int[N+1]; // 각 손님들(index)이 몇 개의 초밥을 먹었는지 기록
		for (int i = 0; i < M; i++) {
			int sushi = sc.nextInt(); // 몇 번 초밥이 나왔는지
			if (!pq[sushi].isEmpty()) {
				int who = pq[sushi].poll(); // 그 초밥을 누가 먹는지
				ans[who]++;
			}
		}

		// 정답 출력
		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i]+" ");
		}

		sc.close();
	}
}