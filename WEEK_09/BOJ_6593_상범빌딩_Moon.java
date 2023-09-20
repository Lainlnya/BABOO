package BOJ_6593_상범빌딩;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static String[][][] building;
	static boolean[][][] visited;
	static int[] startPoint, endPoint;
	static Queue<Integer> queueL, queueR, queueC, queueDepth;
	static int L, R, C;

	// 상하좌우전후
	static int[] dl = { -1, 1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input 받기
		// L, R, C는 모두 1 이상 30 이하
		L = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		while (L != 0 && R != 0 && C != 0) {
			
			// #는 지나갈 수 없고 .은 지나갈 수 있고 S는 시작점 E는 출구
			building = new String[L][R][];
			for (int l = 0; l < L; l++)
				for (int r = 0; r < R; r++)
					building[l][r] = sc.next().split("");

			startPoint = new int[3];
			endPoint = new int[3];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					for (int k = 0; k < C; k++) {
						if (building[i][j][k].equals("S")) {
							startPoint[0] = i;
							startPoint[1] = j;
							startPoint[2] = k;
						} else if (building[i][j][k].equals("E")) {
							endPoint[0] = i;
							endPoint[1] = j;
							endPoint[2] = k;
						}
					}
				}
			}

			visited = new boolean[L][R][C];
			queueL = new LinkedList<>();
			queueR = new LinkedList<>();
			queueC = new LinkedList<>();
			queueDepth = new LinkedList<>();

			BFS(startPoint);
			
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			
		} // while

		sc.close();
	}

	public static void BFS(int[] start) {
		
		visited[start[0]][start[1]][start[2]] = true;
		queueL.add(start[0]);
		queueR.add(start[1]);
		queueC.add(start[2]);
		queueDepth.add(0);

		while (!queueC.isEmpty()) {
			
			int[] now = { queueL.poll(), queueR.poll(), queueC.poll() };
			int depth = queueDepth.poll();
			
			for (int i = 0; i < 6; i++) {

				int nl = now[0]+dl[i];
				int nr = now[1]+dr[i];
				int nc = now[2]+dc[i];
				
				// 건물 밖으로 나가지 않으며
				if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C) {
					// 이미 방문하지도 않았으며
					if (!visited[now[0]+dl[i]][now[1]+dr[i]][now[2]+dc[i]]) {
						// 길이 있으면
						if (building[nl][nr][nc].equals(".")) {
							visited[nl][nr][nc] = true;
							queueL.add(nl);
							queueR.add(nr);
							queueC.add(nc);
							queueDepth.add(depth+1);
						// 혹은 도착했다면
						} else if (building[nl][nr][nc].equals("E")) {
							System.out.println("Escaped in "+(depth+1)+" minute(s).");
							return;
						}
					}
				}
				
			} //for

		} //while
		
		// 만약 경로가 없으면
		System.out.println("Trapped!");
		return;

	}
}