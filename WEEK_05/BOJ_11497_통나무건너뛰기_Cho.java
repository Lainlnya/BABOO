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

			level = Math.max(level, namu[N-1]-namu[N-2]);
			//원 배열로 봤을 때 양 끝에 가장 작은것과 가장 큰 것이 있음 7개를 예로 들면
//   			7
//   		5		6
//   	3				4
//   		1		2
//   			0
//요런식으로 배열되어야 함 따라서 기본적으로 양옆과 2씩 차이나므로 2씩 차이나는거 비교
// 가장 작은 것과 가장 큰것은 idx 1차이나는 것과도 이웃하므로 맨 처음과 맨마지막에 비교해줌
			System.out.println(level);
		}

	}
}
