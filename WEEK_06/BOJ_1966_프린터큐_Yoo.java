package BOJ_1966_프린터큐;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 테케
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int count = 0;
			// 자료의 개수
			int N = sc.nextInt();
			// 찾으려는 자료
			int M = sc.nextInt();
			
			LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
			
			int i = 0;
			while (i < N) {
				// 인덱스, 우선순위
				Integer[] arr = { i, sc.nextInt() };
				// 큐에 추가
				queue.add(arr);
				i++;
			}

			// 맨 첫번째 꺼내기
			// 나올수 있으면 꺼내고 (인덱스 일치 -> 다음 문제로)
			// 나올 수 없으면 뒤로 보내기

			while (!queue.isEmpty()) {
				//처음꺼 꺼내기
				Integer[] now = queue.poll();
				boolean popCan = true;

				for (Integer[] q : queue) {
					// 우선순위가 더 높으면
					if (q[1] > now[1])
						popCan = false;
				}
				// 우선순위가 더 높은 원소가 없으면

				if (popCan) {
					count++;
					if (now[0] == M) {
						sb.append(count).append("\n");
						break;
					}

				} else
					queue.add(now);
			}
		}
		System.out.print(sb);
	}
}

