
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_29160_나의FIFA팀가치는_Yoo {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 선수 수
		int n = sc.nextInt();
		// 반복 년
		int year = sc.nextInt();

		// 우선순위 큐 11개
		PriorityQueue<Integer>[] queues = new PriorityQueue[11];

		// 11개 내림차순
		for (int i = 0; i < 11; i++) {
			queues[i] = new PriorityQueue<>((x, y) -> y - x);
		}

		// 선수 번호, 가치 입력넣기
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int price = sc.nextInt();

			queues[num - 1].add(price);
		}

		// 년수 반복
		for (int i = 0; i < year; i++) {
			// 11번까지 체크
			for (int j = 0; j < 11; j++) {
				// 비어 있지 않을 때
				if (!queues[j].isEmpty()) {
					int a = queues[j].poll();
					// 0이면 더이상 내려갈 숫자 없음
					if (a > 0) {
						queues[j].add(a - 1);
					}
				}
			}
		}

		// 답 구하기
		int ans = 0;
		for (int i = 0; i < 11; i++) {
			if (!queues[i].isEmpty()) {
				ans += queues[i].poll();
			}
		}
		System.out.println(ans);
	}
}
