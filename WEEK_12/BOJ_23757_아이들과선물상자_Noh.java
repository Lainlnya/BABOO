package BOJ_23757_아이들과선물상자;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 선물 상자의 개수
		int box = sc.nextInt();
		// 아이들의 수
		int childNum = sc.nextInt();

		// 큰 숫자가 우선이 되도록 하기 위해서!
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 1; i <= box; i++) {
			// i번째 상자에 담겨있는 선물의 개수
			int cnt = sc.nextInt();
			pq.add(cnt);
		}

		for (int i = 1; i <= childNum; i++) {
			// i번째 아이가 원하는 선물의 개수
			int nowNeed = sc.nextInt();
			// 현재 선물이 가장 많이 담겨있는 상자에 담긴 선물의 개수
			int nowStock = pq.poll();

			// i번째 아이가 원하는 선물의 개수만큼 없다면
			if (nowStock < nowNeed) {
				// 0출력하고 종료
				System.out.println(0);
				return;
			} else {
				// 가져가고 남은 선물의 개수를 다시 큐에 넣어줌
				pq.add(nowStock - nowNeed);
			}
		}
		
		// 모든 아이들이 실망하지 않고 가져갔으면 1출력
		System.out.println(1);

	} // main
} // class
