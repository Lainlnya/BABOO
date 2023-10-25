import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 트리의 정점 개수
		int n = sc.nextInt();

		list = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		// 간선 a,b의 정보 (n-1)개
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list[a].add(b);
			list[b].add(a);
		}

		// q = 질의 개수
		int q = sc.nextInt();

		// t가 1이면 단절점이냐고 묻는거, 2면 단절선인지 묻는거
		for (int i = 0; i < q; i++) {
			int t = sc.nextInt();
			int k = sc.nextInt();

			// t 가 1일때 단절점 인가요??
			if (t == 1) {
				int cnt = 0;
				for (int tmp : list[k]) {
					cnt++;
				}

				if (cnt >= 2) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}

			}
			// t==2 단절선은 무조건 맞음
			else {
				System.out.println("yes");
			}

		}

	}
}
