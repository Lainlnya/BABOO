package BOJ_6593_상범빌딩;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static int L, R, C, ans;
	public static char[][][] building;
	public static int[][][] time;
	public static int sfloor, srow, scol, efloor, erow, ecol; // 시작점 좌표, 출구 좌표 저장
	// 상하좌우남북
	public static int[] dr = { -1, 1, 0, 0, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1, 0, 0 };
	public static int[] df = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 무한반복
		while (true) {
			L = sc.nextInt(); // 상범 빌딩의 층 수
			R = sc.nextInt(); // 한 층의 행의 개수
			C = sc.nextInt(); // 한 층의 열의 개수

			// L,R,C가 모두 0이면 강제종료
			if (L == 0 && R == 0 && C == 0)
				System.exit(0);

			building = new char[L][R][C]; // 상범빌딩 정보
			time = new int[L][R][C]; // 각 층별, 칸별 방문 정보

			for (int f = 0; f < L; f++) {
				for (int i = 0; i < R; i++) {
					String str = sc.next();
					for (int j = 0; j < C; j++) {
						building[f][i][j] = str.charAt(j);
						if (building[f][i][j] == 'S') {
							sfloor = f;
							srow = i;
							scol = j;
						}
						if (building[f][i][j] == 'E') {
							efloor = f;
							erow = i;
							ecol = j;
						}
					} // 열
				} // 행
				sc.nextLine();
			} // 층 -> 입력받기 끝

			ans = 0; // 탐색 횟수라고 생각하면 됨
			BFS(sfloor, srow, scol); // BFS는 최단거리

			// time이 0이면 도달 X
			if (ans == 0) {
				System.out.println("Trapped!");
			} else {
				System.out.println("Escaped in " + ans + " minute(s).");
			}
		} // (0,0,0) 들어오면 종료
	} // main

	public static void BFS(int f, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		// 큐에 시작점 좌표 넣고 방문에 걸린 시간 저장(시작점은 0)
		queue.add(new int[] { f, r, c });
		time[f][r][c] = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			// 도착점을 만나면
			if (building[now[0]][now[1]][now[2]] == 'E') {
				// 도착점을 올 때까지 탐색횟수 저장하고 종료
				ans = time[now[0]][now[1]][now[2]];
				return;
			}

			// 상,하,좌,우,남,북 탐색
			for (int idx = 0; idx < 6; idx++) {
				int nf = now[0] + df[idx];
				int nr = now[1] + dr[idx];
				int nc = now[2] + dc[idx];

				// 경계를 벗어나지 않으면서
				if (nf >= 0 && nf < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
					// 갈 수 있는 길(.)이나 도착점이면서 아직 방문하지 않았으면
					if ((building[nf][nr][nc] == '.' || building[nf][nr][nc] == 'E') && time[nf][nr][nc] == 0) {
						// 큐에 추가하고 방문에 걸린 시간 저장
						queue.add(new int[] { nf, nr, nc });
						time[nf][nr][nc] = time[now[0]][now[1]][now[2]] + 1;
					}
				}
			}
		}
	} // BFS
} // class
