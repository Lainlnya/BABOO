import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22352_항체인식_kim {
	static int column;
	static int row;
	static int[][] vaccum;
	static int[][] result;
	static boolean[][] visited;
	static Queue<Integer> queue;
	static int[] dr = {0, 0, -1, 1}; // 상 하 좌 우
	static int[] dc = {1, -1, 0, 0}; // 상 하 좌 우
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		column = Integer.parseInt(st.nextToken()); // 세로
		row = Integer.parseInt(st.nextToken()); // 가로
		
		vaccum = new int[column + 1][row + 1]; // 백신 놓기 전
		result = new int[column + 1][row + 1]; // 백신 놓은 후
		visited = new boolean[column + 1][row + 1]; // 방문 배열
		queue = new LinkedList<>(); // queue
		
		// 기존 배열
		for (int i = 1; i <= column; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= row; j++) {
				vaccum[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 결과 배열
		for (int i = 1; i <= column; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= row; j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 단 한 번만 놓을 수 있기 때문에 처음에 같은거 찾은 이후에 break;
		aa: for (int i = 1; i <= column; i++) {
			for (int j = 1; j <= row; j++) {
				if (vaccum[i][j] != result[i][j]) {
					bfs(i, j);
					break aa;
					
				} 
			}
		}
		
		// 배열 내부의 값까지 비교할 수 있는 메서드 deepEquals
		 if (Arrays.deepEquals(vaccum, result)) 
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	// bfs
	public static void bfs(int x, int y) {
		int initial = vaccum[x][y];
		queue.offer(x);
		queue.offer(y);
		visited[x][y] = true;
		vaccum[x][y] = result[x][y]; // 가장 처음에 바꿀 값을 넣어줌
		
		while (!queue.isEmpty()) {
			int cx = queue.poll();
			int cy = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cx + dc[i];
				int ny = cy + dr[i];
				
				if (nx >= 1 && nx <= column && ny >= 1 && ny <= row) {
					if (!visited[nx][ny] && vaccum[nx][ny] == initial) {
						queue.offer(nx);
						queue.offer(ny);
						visited[nx][ny] = true;
						vaccum[nx][ny] = result[x][y]; // 처음에 찾았던 result 값으로 모두 변경해 줌
					}
				}
			}
		
			
		}
	}
}
