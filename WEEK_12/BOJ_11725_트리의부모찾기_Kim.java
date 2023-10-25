package WEEK_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기_Kim {
    static int nodeNum;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        nodeNum = Integer.parseInt(br.readLine());
        tree = new ArrayList<ArrayList<Integer>>();
        visited = new boolean[nodeNum + 1];
        parents = new int[nodeNum + 1];

        // 초기화
        for (int i = 0; i <= nodeNum; i++) {
            tree.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < nodeNum - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        dfs(1);

        for (int i = 2; i < parents.length; i++) {
            sb.append(parents[i] + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;

        for (int vertex : tree.get(start)) {
            if (!visited[vertex]) {
                parents[vertex] = start;
                dfs(vertex);
            }
        }
    }
}
