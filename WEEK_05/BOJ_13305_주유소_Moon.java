package BOJ_13305_주유소;

import java.util.Scanner;

public class Main {
	/*
	 * 가장 저렴한 주유소에서 최종 목적지까지 가는 데 필요한 기름을 모두 넣고,
	 * 해당 주유소 이전까지의 주유소 중 가장 저렴한 주유소에서 해당 주유소까지 가는데 필요한 기름을 모두 넣고,
	 * ...
	 * 를 반복한다.
	 */
	static int[] price; // 각 주유소의 기름값/L
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받기
		int N = sc.nextInt();
		int[] dis = new int[N-1]; // 각 주유소 사이의 거리
		for (int i = 0; i < dis.length; i++) {
			dis[i] = sc.nextInt();
		}
		price = new int[N];
		for (int i = 0; i < price.length; i++) {
			price[i] = sc.nextInt();
		}
		
		int cheap = N-1; // 가장 싼 주유소의 index를 받을 변수
		int point = cheap-1; // 
		long charge = 0; // 총 기름값
		while (cheap != 0) {
			cheap = findMinidx(point); // 가장 싼 주유소의 index를 받아온다.
			long totalDis = 0;
			for (int i = cheap; i <= point; i++) {
				totalDis +=dis[i]; // 해당 주유소에서부터 목적지까지의 거리를 모두 더한다.
			}
			charge +=totalDis*price[cheap]; // 기름값을 곱해 총 기름값에 더해준다.
			point = cheap-1; // 해당 주유소 전에 대해 같은 과정을 반복한다.
		}
		
		System.out.println(charge);
		sc.close();
	}
	
	public static int findMinidx(int idx) {
		int min = 1000000000; // 가장 싼 주유소의 기름값/L를 받을 변수
		int minidx = 0; // 가장 싼 주유소의 index를 받을 변수
		for (int p = 0; p <= idx; p++) {
			if (price[p] < min) {
				min = price[p];
				minidx = p;
			}
		}
		return minidx; // 가장 싼 주유소의 index를 반환
	}
	
}