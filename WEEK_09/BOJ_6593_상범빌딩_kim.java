

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593_상범빌딩_kim {
    static int floor;
    static int row;
    static int column;
    static char[][][] sangbum;
    static boolean[][][] visited;

    static int[] dl = {0, 0, 0, 0, 1, -1}; // z좌표
    static int[] dr = {1, -1, 0, 0, 0, 0}; // x좌표 동서남북상하
    static int[] dc = {0, 0, -1, 1, 0, 0}; // y좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            floor = Integer.parseInt(st.nextToken()); // 층 수
            row = Integer.parseInt(st.nextToken()); // 행
            column = Integer.parseInt(st.nextToken()); // 열

            if (floor == 0 && row == 0 && column == 0) break; // 입력의 끝을 찾아내기 위한 조건

            sangbum = new char[floor + 1][row + 1][column + 1];
            visited = new boolean[floor + 1][row + 1][column + 1];

            // 입력
            Point start = null;
            Point end = null;
            for (int i = 0; i < floor; i++) {
                for (int j = 0; j < row; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < column; k++) {
                        sangbum[i][j][k] = line.charAt(k);

                        if (sangbum[i][j][k] == 'S')
                            start = new Point(i, j, k , 0);
                        if (sangbum[i][j][k] == 'E')
                            end = new Point(i, j, k, 0);
                    }
                }
                br.readLine(); // 공백 라인 처리
            }
            int result = bfs(start, end);

            if (result == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + result + " minute(s).");

        }
    }

    public static int bfs(Point start, Point end) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.z][start.x][start.y] = true; 

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.equals(end)) // 만약에 end point랑 p가 동일할 경우, 거리를 반환
                return p.dist;

            for (int i = 0; i < 6; i++) {
                int nz = p.z + dl[i];
                int nx = p.x + dr[i];
                int ny = p.y + dc[i];

                if (nz >= 0 && nz < floor && nx >= 0 && nx < row && ny >= 0 && ny < column ) {
                    if (!visited[nz][nx][ny] && sangbum[nz][nx][ny] != '#') {
                        queue.offer(new Point(nz, nx, ny, p.dist + 1)); // queue 하나 넣을 때마다 거리 1추가
                        visited[nz][nx][ny] = true;
                    }
                }
            }
        }
        return -1; // default는 -1 반환
    }

    // point 클래스
    static class Point {
        int z;
        int x;
        int y;
        int dist;

        public Point(int z, int x, int y, int dist) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public boolean equals(Point other) {
            return this.z == other.z && this.x == other.x && this.y == other.y;
        }
    }
}
