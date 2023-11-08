package BOJ_11812_K진트리;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 노드의 개수
		long N = sc.nextLong();
		// K진 트리
		int K = sc.nextInt();
		// 거리를 구해야 하는 노드 쌍의 개수
		int cnt = sc.nextInt();

		for (int i = 0; i < cnt; i++) {
			long node1 = sc.nextLong();
			long node2 = sc.nextLong();

			long dist = 0;
			// 1진트리면 그냥 두 노드의 차이가 거리
			if (K == 1) {
				System.out.println(Math.abs(node1 - node2));
			} else {
				// 내 부모노드에 저장된 숫자는(curr-2) / K + 1
				// 두 노드의 부모 -> 최소 공통 조상을 만날 때까지 거리 계산하면서 올라오기
				while (node1 != node2) {
					// 한 번씩 거슬러 올라올 떄 마다 거리 증가시켜줌
					dist++;
					// 값이 더 작은 노드가 depth가 작거나 같은 depth를 가짐!
					if (node1 < node2)
						node2 = (node2 - 2) / K + 1;
					else
						node1 = (node1 - 2) / K + 1;
				}
				System.out.println(dist);
			}
		}
	} // main
} // class
