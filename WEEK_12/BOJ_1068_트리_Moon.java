package BOJ_1068_트리;

import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] parents;
	static boolean[] visited, isLeaf;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 노드의 개수
		parents = new int[N]; // 부모 노드 정보
		int root = -1; // 루트노드
		for (int i = 0; i < N; i++) {
			parents[i] = sc.nextInt();
			if (parents[i] == -1) {
				root = i;
			}
		}
		
		// 끊어주기
		int cut = sc.nextInt();
		if (cut == root) {
			// 만약 루트를 끊었다면 리프 노드는 0개 출력하고 바로 종료한다.
			System.out.println(0);
			System.exit(0);
		} else {
			parents[cut] = -1;
		}
		
		visited = new boolean[N]; // 노드 방문 여부 저장
		isLeaf = new boolean[N]; // 리프 노드 저장
		
		visited[root] = true;
		findLeaf(root);
		
		// 리프 노드의 개수 세기
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (isLeaf[i]) {
				ans++;
			}
		}
		
		// 출력
		System.out.println(ans);
		sc.close();
	}
	
	public static void findLeaf(int node) {
		// 노드에 방문하면 바로 isLeaf를 true로 만들어 준다.
		isLeaf[node] = true;
		for (int i = 0; i < N; i++) {
			// 방문한 적이 없고 현재 노드를 부모로 갖는 노드를 찾아
			if (!visited[i] && parents[i] == node) {
				// 방문 처리를 해주고, 현재 노드는 자식이 있는 것을 확인했으니 isLeaf를 false로 만들어 준다.
				visited[i] = true;
				isLeaf[node] = false;
				// 이 과정을 반복한다.
				findLeaf(i);
			}
		}
	}
}