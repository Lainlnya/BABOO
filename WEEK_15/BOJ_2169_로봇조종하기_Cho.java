package Study_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class BOJ_2169_로봇조종하기_Cho  {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0 ; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j =0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dpL = new int[N][M];
        int[][] dpR = new int[N][M];
        //왼쪽방향으로가는 배열, 오른쪽으로 가는 배열 만들기(같은 곳 방문 불가능하므로 한방향으로만 움직인다생각해도된다)
        dpR[0][0] = map[0][0];
        dpL[0][0] = map[0][0];
        for (int i = 1 ; i < M; i++) {
            dpR[0][i] = dpR[0][i-1] + map[0][i];
            dpL[0][i] = -1000000;
        } //dpL[0] 값을 0으로 냅두었더니 참조안해야 하는데 참조해서 dp값에 혼란을 줌 불가능 한 값 넣어두어서 해결
        for (int i = 1; i < N; i++) {
            dpR[i][0] = Math.max(dpL[i-1][0], dpR[i-1][0]) + map[i][0];
            dpL[i][M-1] = Math.max(dpL[i-1][M-1], dpR[i-1][M-1]) + map[i][M-1];
            for (int j = 1; j < M ; j++)
                dpR[i][j] = Math.max(Math.max(dpL[i-1][j], dpR[i-1][j]), dpR[i][j-1]) + map[i][j];
            for (int j = M-2 ; j >= 0 ; j--)
                dpL[i][j] = Math.max(Math.max(dpL[i-1][j], dpR[i-1][j]), dpL[i][j+1]) + map[i][j];
        } // dpL, dpR 부분 만들기
        // 오른쪽 가는 건 오른쪽으로 가는 dp 바로 전꺼와 자기 위의 dp값 비교해서 큰 거 선택
        // 왼쪽으로 가는 건 왼쪽으로 가는 dp 바로 전꺼와 자기 위의 dp값 비교해서 큰 거 선택
        System.out.println(Math.max(dpR[N-1][M-1], dpL[N-1][M-1]));
    }
}
