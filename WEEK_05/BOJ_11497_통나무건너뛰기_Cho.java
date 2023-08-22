package src;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 0; testCase < T; testCase++) {
			int N = sc.nextInt();
			int[] namu = new int[N];
			for (int i = 0; i < N; i++) {
				namu[i] = sc.nextInt();
			}
			Arrays.sort(namu);
			int level = namu[1] - namu[0];
			int idx = 2;
			while (idx < N ) {
				level = Math.max(namu[idx] - namu[idx-2], level);
				idx++;
			}
			level = Math.max(level, namu[N-1]-namu[N-2]);
			System.out.println(level);
		}

	}
}
