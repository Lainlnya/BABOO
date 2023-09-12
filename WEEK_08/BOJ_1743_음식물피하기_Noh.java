package BOJ_1743_음식물피하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int N, M, K;
	public static int[][] food;
	public static boolean[][] visited;
	// 상하좌우 탐색을 위해서 저장
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int cnt = 1, max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 통로의 세로 길이
		M = sc.nextInt(); // 통로의 가로 길이
		K = sc.nextInt(); // 음식물 쓰레기의 개수

		// 음식물 정보 저장 (0:없음, 1:있음)
		food = new int[N + 1][M + 1];
		// 방문 정보 저장
		visited = new boolean[N + 1][M + 1];

		// 가장 긴 거리
		// 음식물이 떨어진 좌표값 1로 변경
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			food[r][c] = 1;
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				// 방문하지 않은 좌표들 중 음식이 있는 좌표일 때
				if (!visited[i][j] && food[i][j] == 1) {
					cnt = 0; // 각 경우마다 음식물 개수 초기화
					BFS(i, j);
				}
				// 가장 큰 음식물 크기 저장
				if (cnt > max)
					max = cnt;
			}
		}
		System.out.println(max);
	} // main

	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		// 큐에 좌표정보 add
		queue.add(new int[] { i, j });
		// 방문정보 저장
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			int[] nowLocation = queue.remove();
			cnt++;
			// 상하좌우 탐색
			for (int idx = 0; idx < 4; idx++) {
				int nr = nowLocation[0] + dr[idx];
				int nc = nowLocation[1] + dc[idx];
				// 좌표가 유효하다면
				if (nr >= 0 && nc >= 0 && nr < N + 1 && nc < M + 1) {
					// 음식물이 있다면 ++, 방문하지 않았다면
					if (food[nr][nc] == 1 && visited[nr][nc] == false) {
						visited[nr][nc] = true;
						queue.add(new int[] { nr, nc });
					}
				}
			}
		}

	} // BFS
} // class
