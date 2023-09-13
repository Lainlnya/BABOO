package BOJ_1189_컴백홈;

import java.util.Scanner;

public class Main {
	
	static int R, C, K, cnt;
	static String[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 }; //상하좌우
	static int[] dc = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		
		map = new String[R][C];
		for (int r = 0; r < R; r++) {
			map[r] = sc.next().split("");
		}
		
		visited = new boolean[R][C];
		visited[R-1][0] = true;
		goHome(R-1, 0, 1); // (R-1, 0)에서 출발
		
		System.out.println(cnt);
		
		sc.close();
	}
	
	public static void goHome(int r, int c, int depth) {

		if (depth == K) { // 원하는 거리까지 왔는데
			if (r == 0 && c == C-1) { // 원하는 도착점이면
				cnt++; // 정답 ++
				return;
			} else return; // 아니면 그냥 return
		}
		
		for (int i = 0; i < dr.length; i++) {
			if (r+dr[i] < R && r+dr[i] >= 0 && c+dc[i] < C && c+dc[i] >= 0 
					&& !map[r+dr[i]][c+dc[i]].equals("T") 
					&& !visited[r+dr[i]][c+dc[i]]) {
				// 지도를 벗어나지 않으며, 막힌 길이 아니며, 왔던 곳이 아니면-> 직진
				visited[r+dr[i]][c+dc[i]] = true;
				goHome(r+dr[i], c+dc[i], depth+1);
				visited[r+dr[i]][c+dc[i]] = false;
			}
		}
	}
}