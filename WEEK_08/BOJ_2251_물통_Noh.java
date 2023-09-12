package BOJ_2251_물통;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int[] volume;
	public static ArrayList<Integer> ans;
	public static boolean visited[][][];
	// 물을 옮길 수 있는 경로 6가지(A: 0, B: 1, C: 2}
	// A -> B, A -> C, B -> A, B -> C, C -> B, C -> A,
	public static int[] send = { 0, 0, 1, 1, 2, 2 };
	public static int[] receive = { 1, 2, 0, 2, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		volume = new int[3];
		volume[0] = sc.nextInt(); // 물통 1의 부피
		volume[1] = sc.nextInt(); // 물통 2의 부피
		volume[2] = sc.nextInt(); // 물통 3의 부피

		// 방문 배열
		visited = new boolean[volume[0] + 1][volume[1] + 1][volume[2] + 1];
		ans = new ArrayList<Integer>(); // 정답 저장할 곳 -> 정렬

		// 가장 처음값 (0,0,volume[2])도 조건 만족
		ans.add(volume[2]);

		BFS(new int[] { 0, 0, volume[2] });

		// 오름차순 정렬
		Collections.sort(ans);
		for (int n : ans) {
			System.out.print(n + " ");
		}
	} // main

	public static void BFS(int[] state) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(state);
		visited[state[0]][state[1]][state[2]] = true;

		while (!queue.isEmpty()) {
			state = queue.poll();
			// 나올 수 있는 경우의 수 모두 확인가능
			// System.out.println(Arrays.toString(state));

			for (int i = 0; i < 6; i++) {
				int[] tmp = state.clone();
				// 받는 통 = 원래 가지고 있던 양 + 주는 통에 있는 물의 양
				tmp[receive[i]] += tmp[send[i]];

				// 주는 통은 다 준다 생각하고
				tmp[send[i]] = 0;
				// 만약 받는 통이 넘치면
				if (tmp[receive[i]] > volume[receive[i]]) {
					// 넘치는 만큼 다시 돌려주면
					tmp[send[i]] = tmp[receive[i]] - volume[receive[i]];
					// 최대로 차있음
					tmp[receive[i]] = volume[receive[i]];
				}

				// 물 옮기는 과정 볼 수 있음!
				// System.out.println(send[i] + " " + receive[i] + Arrays.toString(tmp));

				// 지금 물 저장된 상태가 처음 나왔으면
				if (visited[tmp[0]][tmp[1]][tmp[2]] == false) {
					// 방문했다고 표시하고
					visited[tmp[0]][tmp[1]][tmp[2]] = true;
					// 다시 물 옮기는 과정 반복
					BFS(tmp);
					// 첫 번째 물통이 비어있고, 세 번째 물통에 있는 양이 ans에 저장되어 있지 않으면
					if (tmp[0] == 0 && !ans.contains(tmp[2])) {
						ans.add(tmp[2]); // 저장
					}
				}
			}
		}
	} // BFS

} // class
