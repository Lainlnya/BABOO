package BOJ_5464_주차장;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		int N = sc.nextInt(); // 주차공간 N
		int M = sc.nextInt(); // 자동차 수 M
		int[] Rs = new int[N]; // 각 주차공간의 단위 무게당 요금 Rs
		for (int i = 0; i < N; i++) Rs[i] = sc.nextInt();
		int[] Wk = new int[M]; // 자동차의 무게 Wk
		for (int i = 0; i < M; i++) Wk[i] = sc.nextInt();
		
		// 풀이
		int[] parking = new int[N]; // 주차된 차량 정보
		int cars = 0;
		int fee = 0;
		Queue<Integer> waiting = new LinkedList<>(); // 기다리고 있는 차량 정보
		
		for (int i = 0; i < 2*M; i++) {
			int inOut = sc.nextInt(); // 차량 입출입 정보
			
			// 입차
			if (inOut > 0) {
				if (cars == N) waiting.add(inOut); // 주차장이 꽉 찼으면
				else { // 주차장 자리가 남아있으면
					for (int j = 0; j < N; j++) {
						if (parking[j] == 0) { // 빈 자리를 찾아서
							parking[j] = inOut; // 주차하고
							cars++; // 현재 차량 수 기록
							fee += Rs[j]*Wk[inOut-1]; // 요금 받기
							break;
						}
					}
				}
			} // 입차 끝
			
			// 출차
			if (inOut < 0) {
				if (waiting.size() != 0) { // 기다리는 차가 있으면
					for (int j = 0; j < N; j++) {
						if (parking[j] == -inOut) { // 주차돼있던 차 빼고
							parking[j] = waiting.poll(); // 기다리던 차 주차하고
							fee += Rs[j]*Wk[parking[j]-1]; // 요금 받기
						}
					}
				} else { // 기다리는 차가 없으면
					for (int j = 0; j < N; j++) {
						if (parking[j] == -inOut) { // 주차돼있던 차 빼고
							parking[j] = 0;
							cars--; // 현재 차량 수 기록
							break;
						}
					}
				}
			} // 출차 끝
			
		}
		
		System.out.println(fee);
		
		sc.close();
	}
}