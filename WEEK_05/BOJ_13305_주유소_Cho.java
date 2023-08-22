package src;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] d = new int[N - 1];
		int[] p = new int[N];
		for (int i = 0; i < N - 1; i++)
			d[i] = sc.nextInt(); // 거리 받아오기
		for (int i = 0; i < N; i++)
			p[i] = sc.nextInt(); //주유소 가격 받아오기
		long min = p[0], ds = d[0]; //무조건 처음에 충전해야하므로 초기값으로 입력
		long result = 0;
		for (int i = 1; i < N - 1; i++) {
			if (min > p[i]) {
				result += Long.valueOf(min * ds); //주유소 최소값 갱신 시 그 때까지의 가격 최소값 * 거리 더해주기
				min = p[i];
				ds = d[i];
			} else {
				ds += d[i]; // 전 주유소가 더 쌀 경우에는 계속 더하기
			}

		}
		result += ds*min; // 마지막에 주유소에서 충전하여 간 거리를 안 더해줬으므로 더해주기
		System.out.println(result);
	}
}