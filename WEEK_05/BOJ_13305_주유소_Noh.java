package BOJ_13305_주유소;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 도시의 개수
		// 각 도시 사이의 거리
		long[] distance = new long[N - 1];
		// 각 도시의 주유소의 리터당 가격(마지막 가격은 사실상 필요X)
		long[] price = new long[N];

		for (int i = 0; i < N - 1; i++) {
			distance[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			price[i] = sc.nextInt();
		} // 입력받기 끝!(마지막 가격은 사실상 필요X)

		long cost = 0; // 최소비용

		// 첫 번째 도시에서 두 번째 도시까지는 무조건 기름 넣고 출발
		cost = price[0] * distance[0];
		
		long min = price[0];
		for (int i = 1; i < N - 1; i++) {

			// 최소 가격 min에 저장
			if (price[i] < min) {
				min = price[i];
			}

			cost += min * distance[i];
		}
		System.out.println(cost);
	} // main

} // class
