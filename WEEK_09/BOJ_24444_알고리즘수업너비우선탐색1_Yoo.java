package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 알고수업 {

	static boolean visited[];
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int N, M, R;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int en = sc.nextInt();

			list.get(st).add(en);
			list.get(en).add(st);
		}

		for (int i = 1; i < N; i++) {
			Collections.sort(list.get(i));
		}
		bfs(R);
	}

	public static void bfs(int a) {
		Queue<Integer> queue = new LinkedList<>();
		int cnt = 1;
		int result[] = new int[N + 1];
		queue.add(a);
		visited[a] = true;
		result[a] = cnt++;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
					result[next] = cnt++;
				}
			}
		}
		for (int i = 1; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
