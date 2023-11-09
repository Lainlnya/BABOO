package jajaja;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11437_LCA_Yoo {
	static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int[] depth;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //노드의 개수 
        N = sc.nextInt();

        adj = new ArrayList[N + 1];
        
        //N개의 어레이 리스트 생성
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        visited = new boolean[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];

        // N개의 정점 입력받기
        for (int i = 0; i < N - 1; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adj[v1].add(v2);
            adj[v2].add(v1);
        }
        
        //루트에서 부터 dfs 돌리면서 depth입력 받기
        DFS(1, 0);

        
        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
        	int cat1 = sc.nextInt();
        	int cat2 = sc.nextInt();
        	
        	//두 정점의 가장 조상 찾아서 바로 출력하기!
        	int ans = LCA(cat1, cat2);
            System.out.println(ans);
        }
    }

    private static void DFS(int from, int deep) {
    	
    	//방문처리, depth 배열에 깊이 입력 넣기
        visited[from] = true;
        depth[from] = deep;

        //갱신 해주는데 방문하지 않은거 찾으면 부모 입력해주고 깊이 입력넣을 dfs 반복
        for (int to : adj[from]) {
            if (!visited[to]) {
                parent[to] = from;
                DFS(to, deep + 1);
            }
        }
    }

    private static int LCA(int a, int b) {
    	//깊이 같게 한다음 생각할거임!
    	
    	//깊이 다르면 깊은 곳을 (깊은곳의 부모)로 설정
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else
                b = parent[b];
        }
        
        // 혹시나 같다면 걍 a로 고
        if (a == b) return a;
        
        //이후 공통 조상 찾아가기 
        while (parent[a] != parent[b]) {
            a = parent[a];
            b = parent[b];
        }

        return parent[a];
    }
}
