package Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상범빌딩 {
	static int x;

	static int L, R, C;
	static boolean visited[][][];
	static char map[][][]; //진짜 맵
	static int map1[][][]; //이동거리 측정하기 위한 배열 생성
	static int dy[] = { -1, 0, 1, 0, 0, 0 };
	static int dx[] = { 0, 1, 0, -1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	static int move;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			L = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();

			//END 조건
			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			//초기화
			int startx = 0, starty = 0, startz = 0;
			int endx = 0, endy = 0, endz = 0;
//			move = 0;

			map = new char[L][R][C];
			map1 = new int [L][R][C];
			visited = new boolean[L][R][C];

			//Z, Y, X 로 입력받기
			for (int f = 0; f < L; f++) {
				for (int i = 0; i < R; i++) {

					String str = sc.next();
					for (int j = 0; j < C; j++) {
						char ch = str.charAt(j);
						map[f][i][j] = ch;

						// 시작 지점 입력
						if (ch == 'S') { 
							startz = f;
							startx = j;
							starty = i;
						// 도착 지점 입력
						} else if (ch == 'E') { 
							endz = f;
							endx = j;
							endy = i;
						}
					}
				}
			}
			BFS(startx, starty, startz);
			
			//E 있는 지점이 방문하지 않았으면 도착 못함
			if(!visited[endz][endy][endx]) {
				System.out.println("Trapped!");
			}
			//E 있는 지점 방문했으면 ! 그때의 최소 거리 값 출력
			else {
				System.out.println("Escaped in " + map1[endz][endy][endx] + " minute(s).");
			}
		}
	}

	public static void BFS(int x, int y, int z) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y, z, 0 });
		visited[z][y][x] = true;

		while (!q.isEmpty()) {
			
			int now[] = q.poll();
			int xx = now[0];
			int yy = now[1];
			int zz = now[2];

			for (int i = 0; i < 6; i++) {
				int nextX = xx + dx[i];
				int nextY = yy + dy[i];
				int nextZ = zz + dz[i];

				
				//범위 밖이면 컷
				if (nextX < 0 || nextY < 0 || nextZ < 0 || nextX > C - 1 || nextY > R - 1 || nextZ > L - 1)
					continue;
				
				//방문했거나 벽이면 컷
				if (visited[nextZ][nextY][nextX]||map[nextZ][nextY][nextX] == '#')
					continue;
				
				//방문할 수 있으면 이동하고 map1배열에서 +1
				if (map[nextZ][nextY][nextX] == '.' ||map[nextZ][nextY][nextX] == 'E') {
					visited[nextZ][nextY][nextX] = true;
					q.add(new int[] { nextX, nextY, nextZ });
//					move++;
					map1[nextZ][nextY][nextX] = map1[zz][yy][xx]+1;
				}
			}
		}	
	}
}
