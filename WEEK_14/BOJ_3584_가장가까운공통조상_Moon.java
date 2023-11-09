package BOJ_3584_가장가까운공통조상;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int A, B;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		tc: for (int testCase = 1; testCase <= T; testCase++) {
			// testCase 시작
			
			int N = sc.nextInt(); // 트리를 구성하는 노드의 수
			int[] parents = new int[N+1]; // 각 노드의 부모 정보를 담아둔다.
			
			for (int i = 1; i < N; i++) {
				// 노드 번호는 1이상 N이하의 정수
				int P = sc.nextInt(); // 부모
				int C = sc.nextInt(); // 자식
				
				parents[C] = P; // 부모 정보 기록
			}
			
			List<Integer> listA = new ArrayList<>();
			List<Integer> listB = new ArrayList<>();
			
			// 가장 가까운 공통 조상을 구할 두 노드
			A = sc.nextInt();
			B = sc.nextInt();
			
			// 만약 그냥 같은 노드가 들어왔다면 종료
			if (A == B) {
				System.out.println(A);
				System.exit(0);
			}
			
			listA.add(A);
			listB.add(B);
			
			while (true) {
				A = parents[A];
				B = parents[B];
				
				listA.add(A);
				listB.add(B);
				
				if (listA.contains(B)) {
					System.out.println(B);
					continue tc;
				} else if (listB.contains(A)) {
					System.out.println(A);
					continue tc;
				}
			}
			
		} //testCase
		sc.close();
	}
}