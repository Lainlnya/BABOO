package BOJ_19940_피자오븐;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			
			int N = sc.nextInt();
			int make = 0;
			int[] push = new int[5];
			
			// 1 <= N <= 10,000,000 이므로
			// N이 매우 큰 상황을 대비해 한번에 60분 버튼을 눌러줄 횟수를 구한다.
			push[0] +=(N/60);
			make +=(push[0]*60);
			
			while (make != N) {
				
				// 모든 case를 나눠 계산한다.
				if (N - make > 35) {
					push[0]++;
					make += 60;
				} else if (N - make > 5) {
					push[1]++;
					make += 10;
				} else if (make - N > 5) {
					push[2]++;
					make -= 10;
				} else if (N > make) {
					push[3]++;
					make++;
				} else if (make > N) {
					push[4]++;
					make--;
				}

			} // while
			
			for (int i = 0; i < 5; i++) {
				sb.append(push[i]);
				if (i == 4) sb.append("\n");
				else sb.append(" ");
			}
			
		} //testCase
		
		System.out.println(sb);

		sc.close();
	}
}