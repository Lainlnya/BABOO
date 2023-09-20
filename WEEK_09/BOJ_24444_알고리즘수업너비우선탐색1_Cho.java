import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[] Order;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        //입력받기
        Set<Integer>[] E = new TreeSet[N+1]; //어레이리스트 이용 연결 간선 표시
        Order = new int[N+1];
        for (int i = 0 ; i< N+1; i++) {
            E[i] = new TreeSet<>();
        }
        visited = new boolean[N+1];
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int connect1 = Integer.parseInt(st.nextToken());
            int connect2 = Integer.parseInt(st.nextToken());
            E[connect1].add(connect2);
            E[connect2].add(connect1);
        } //무방향 이기에 연결 간선 두 정점에 모두 표시
        bfs(E, R);
        for (int i = 1; i <= N ; i++)
            sb.append(Order[i]+"\n");
        System.out.println(sb);
    } //main 끝



    public static void bfs(Set<Integer>[] E, int R) {
        int count =1; //순서를 표시하기 위한  count
        visited[R] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(R);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            Order[u] = count++; //순서를 기록하기. 
            for (int v : E[u]) {
                if(!visited[v]) {
                    visited[v] =true;
                    queue.add(v);
                }
            } //bfs 기초 queue 만들고 넣고 선입선출

        }
    return;
    }
}
