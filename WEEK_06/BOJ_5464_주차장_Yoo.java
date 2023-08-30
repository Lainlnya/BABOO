package BOJ_5464_주차장;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		// N개 줄에 무게당 요금 배열
		int[] cost = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			cost[i] = sc.nextInt();
		}

		// M개 줄에 무게 배열
		int[] car = new int[M + 1];
		for (int i = 1; i <= M; i++) {
			car[i] = sc.nextInt();
		}

		// N개 주차 현황 배열
		int[] now = new int[N + 1];

		int result = 0;

		// 대기열
		Queue<Integer> queue = new LinkedList<>();

		run : for (int i = 0; i < 2 * M; i++) {
			int nowCar = sc.nextInt();

			// 들어오는 차
			if (nowCar > 0) {
				for (int j = 1; j < N + 1; j++) {
					if (now[j] == 0) {
						 // 주차 성공
						now[j] = nowCar;
						continue run;
					}
				}
				// 빈자리가 없으면 대기열 큐에 넣음
				queue.offer(nowCar); 
			} else { // 나가는 차라면
				for (int j = 1; j < N + 1; j++) {
					if (now[j] == nowCar * (-1)) {
						// 해당 자리 비우고 값 계산
						now[j] = 0; 
						result += cost[j] * car[nowCar * -1];
						
						//큐 있으면 맨 앞 밀어넣기
						if (!queue.isEmpty())
							now[j] = queue.poll();
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
