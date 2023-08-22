package src;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] d = new int[N - 1];
		int[] p = new int[N];
		for (int i = 0; i < N - 1; i++)
			d[i] = sc.nextInt(); //
		for (int i = 0; i < N; i++)
			p[i] = sc.nextInt(); 
		long min = p[0], ds = d[0]; //처음에 무조건 충전해야하므로초기값으로 넣어주기
		long result = 0;
		for (int i = 1; i < N - 1; i++) {
			if (min > p[i]) {
				result += Long.valueOf(min * ds); // 더 싼 주유소 발견시 그 전까지의 합 더해주기
				ds = d[i];
			} else {
				ds += d[i]; // 전에 주유소가 싸다면 거리만큼 더해주기 
			}

		}
		result += ds*min; //for문 통과 후 마지막 주유소에 충전 후 간 거리 계산안해줬으므로 마지막으로 더해주기
		System.out.println(result);
	}
}