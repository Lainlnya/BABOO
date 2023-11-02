package BOJ_2467_용액;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] potion = new int[N];
		for (int i = 0; i < N; i++) {
			potion[i] = sc.nextInt();
		}
		
		int p1 = 0;
		int p2 = N-1;
		int close = Math.abs(potion[p1] + potion[p2]);
		int[] ans = { p1, p2 };
		
		while (p1 < p2) {
			if (potion[p1]+potion[p2] < 0) {
				p1++;
			} else {
				p2--;
			}
			
			if (p1 != p2 && Math.abs(potion[p1] + potion[p2]) < close) {
				close = Math.abs(potion[p1] + potion[p2]);
				ans[0] = p1;
				ans[1] = p2;
			}
		}
		
		System.out.print(potion[ans[0]]+" "+potion[ans[1]]);
		
		sc.close();
	}
}