package BOJ_14699_관악산등산;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input 받는 과정
		int N = sc.nextInt(); // 쉼터의 수
		int M = sc.nextInt(); // 길의 수
		// 각 쉼터의 높이
		int[] alt = new int[N];
		for (int i = 0; i < N; i++) {
			alt[i] = sc.nextInt();
		}
		// 쉼터를 연결하는 길
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt()-1;
			int B = sc.nextInt()-1;
			if (alt[A] > alt[B])
				list.get(B).add(A);
			else
				list.get(A).add(B);
			// 각 list.get(i)에는 i에서 올라갈 수 있는 쉼터의 번호가 기록되어있다.
		}
		
		// 이제 풀어야지
		int[] answer = new int[N];

		// 계산
		for (int n = 0; n < N; n++) {
			
			int max = 0;
			int maxidx = -1;
			
			for (int i = 0; i < N; i++) {
				if (answer[i] == 0 && alt[i] > max) {
					max = alt[i];
					maxidx = i;
				}
			}
			
			if (maxidx == -1) break;
			
			answer[maxidx] = 1;
			
			if (list.get(maxidx).size() > 0) {
				for (int i = 0; i < list.get(maxidx).size(); i++) {
					if (answer[list.get(maxidx).get(i)] +1 > answer[maxidx]) {
						answer[maxidx] = answer[list.get(maxidx).get(i)] +1;
					}
				}
			}

		}

		// 출력
		for (int i = 0; i < N; i++) {
			System.out.println(answer[i]);
		}
		
		sc.close();
	}
}