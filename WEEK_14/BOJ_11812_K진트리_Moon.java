package BOJ_11812_K진트리;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		long N = sc.nextLong(); // 총 N개의 노드
		int K = sc.nextInt(); // K진 트리
		int Q = sc.nextInt(); // 거리를 구해야하는 노드 쌍의 개수 Q
		
		tc: for (int testCase = 1; testCase <= Q; testCase++) {
			// 노드 번호에 1을 더하고 K로 나눠주면 부모 노드 번호가 나온다.
			
			// 거리를 구해야하는 노드 쌍
			long A = sc.nextLong()-1;
			long B = sc.nextLong()-1;
			
			// 혹시 K가 1은 아닌지?
			if (K == 1) {
				long dep = Math.abs(A-B);
				sb.append(dep+"\n");
				continue tc;
			}
			
			// 실망하며 제대로 구하자
			// 초기화
			int dist = 0;
			
			// 같은 노드에서 만날 때까지 올라온다.
			while (A != B) {
				dist++;
				if (A > B) {
					A = (A-1)/(long)K;
				} else {
					B = (B-1)/(long)K;
				}
			}
			
			sb.append(dist+"\n");
		} // tc
		
		System.out.println(sb);
		sc.close();
	}
}