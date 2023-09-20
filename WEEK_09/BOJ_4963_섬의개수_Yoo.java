package Practice;

import java.util.*;

public class 섬의개수 {

	static int w, h;
	static boolean[][] visited;
	static int map[][];
	static int cnt;
	static int dx[] = {0,1,0,-1,-1,-1,1,1};
	static int dy[] = {1,0,-1,0,-1,1,1,-1};

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			//end 조건
			if (w == 0 && h == 0) {
				break;
			}

			map = new int[h][w];
			visited = new boolean[h][w];

			//입력 파트
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//매번 cnt 초기화
			cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					
					//방문하지 않았거나 map 1일경우 BFS 가즈아
					//만났기 때문에 cnt++
					//대각선에 있는것도 처음에 만난 섬이 다 방문처리 해버렸기 때문에 들어가지 못함
					if (!visited[i][j] && map[i][j] == 1) {
						BFS(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void BFS(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int now[] = q.poll();
			int nowx = now[0];
			int nowy = now[1];

			for (int i = 0; i < 8; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];

				//범위 안에 있고
				if (nextx >= 0 && nexty >= 0 && nextx < h && nexty < w) {
					//방문하지 않았고 맵이 1일때 들어갈 수 있음
					if (visited[nextx][nexty]==false && map[nextx][nexty] == 1) {
						q.add(new int[] { nextx, nexty });
						visited[nextx][nexty] = true;
					}
				}
			}
		}
	}
}