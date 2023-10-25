package BOJ_29160_나의FIFA팀가치는;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static PriorityQueue<player>[] pList;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 선수의 수
		int N = sc.nextInt();
		// K년 12월이 되었을 때 팀의 선발 선수 가치의 합 구하기!
		int K = sc.nextInt();

		// 총 선수는 11명!
		pList = new PriorityQueue[12];
		for (int i = 0; i < 12; i++) {
			// 최대값이 우선이 되도록!
			pList[i] = new PriorityQueue<>(Collections.reverseOrder());
		}

		for (int i = 0; i < N; i++) {
			// i번째 선수의 포지션
			int iPosition = sc.nextInt();
			// i번째 선수의 가치
			int iValue = sc.nextInt();
			pList[iPosition].add(new player(iPosition, iValue));
		}

		// K년 12월 구성이 궁금하니까
		for (int i = 0; i < K; i++) {
			// 선수 구성 하자!
			Composition();
		}

		// K년 12월의 선수가치 총합 출력
		int totalValue = 0;
		for (int i = 1; i <= 11; i++) {
			if (!pList[i].isEmpty()) {
				player selectPlayer = pList[i].poll();
				totalValue += selectPlayer.value;
			}
		}
		System.out.println(totalValue);
	} // main

	static class player implements Comparable<player> {
		// 선수의 포지션, 가치
		int position, value;

		public player(int position, int value) {
			this.position = position;
			this.value = value;
		}

		@Override
		public int compareTo(player o) {
			return this.value - o.value;
		}
	} // player 객체

	// 선수 구성 메소드
	public static void Composition() {
		// 3월
		// 같은 포지션 선수 중 가치가 가장 높은 선수가 선발선수
		// 여러 명 있으면 아무나, 없으면 공백으로
		// 8월
		// 현재 팀에 있는 선발 선수의 선수 가치는 모두 1이 떨어짐
		// 선수 가치는 0보다 작아지지 않음
		// 11월
		// 같은 포지션 선수 중 가치가 가장 높은 선수가 선발 선수
		// 여러 명 있으면 아무나, 없으면 공백으로

		for (int i = 1; i <= 11; i++) {
			// 뽑을 선수가 있을 때
			if (!pList[i].isEmpty()) {
				// 선발선수는 가장 가치가 높은 선수
				player selectPlayer = pList[i].poll();
				// 선발선수의 가치는 모두 1이 떨어짐
				if (selectPlayer.value > 0)
					selectPlayer.value -= 1;
				pList[i].add(selectPlayer);
			}
		}
	}
} // class
