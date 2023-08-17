package BOJ_1449_수리공항승;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/*
	 * 20분
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물이 새는 곳의 개수
		int L = sc.nextInt(); // 테이프의 길이
		
		int[] leak = new int[N]; // 물이 새는 곳
		for (int i = 0; i < N; i++) {
			leak[i] = sc.nextInt();
		}
		Arrays.sort(leak);
		
		if (L < 2) {
			System.out.println(N);
		} else {
			// 여기부터
			int ans = 0;
			int i = 0;
			while (i < N) {
				int j = 0;
				W2: while (leak[i+j] - leak[i] <= L-1) {
					j++;
					if (i+j >= N) break W2;
				}
				ans++;
				i +=j;
			}
			
			System.out.println(ans);
			// 여기까지
		}
		
		sc.close();
	}
}