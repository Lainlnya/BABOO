package WEEK_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역_Kim {
    static int width;
    static int[][] area;
    static int min, max;
    static int answer;
    static boolean [][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 좌 상 우 하
    static int[] dy = {0, 1, 0, -1}; // 좌 상 우 하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        width = Integer.parseInt(br.readLine());
        StringTokenizer st;
        area = new int[width][width];
        visited = new boolean[width][width];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        // 입력
        for (int i = 0; i < width; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, area[i][j]);
                max = Math.max(max, area[i][j]);
            }
        }

        for (int water = 0; water <= max; water++) {
            int safe = 0;

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && area[i][j] > water) {
                        dfs(i, j, water);
                        safe++;
                    }
                }
            }
            answer = Math.max(safe, answer);

            for (int i = 0; i < width; i++) {
                Arrays.fill(visited[i], false);
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int x, int y, int min) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < width && ny >= 0 && ny < width) {
                if (!visited[nx][ny] && area[nx][ny] > min) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, min);
                }
            }
        }
    }
}
