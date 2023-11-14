package WEEK_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584_가장가까운공통조상_Kim {
    static int caseNum, nodeNum;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++){
            nodeNum = Integer.parseInt(br.readLine());
            visited = new boolean[nodeNum + 1];
            parent = new int[nodeNum + 1];

            for (int j = 0; j < nodeNum - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // y의 부모는 x
                parent[y] = x;
            }

            st = new StringTokenizer(br.readLine());
            int findX = Integer.parseInt(st.nextToken());
            int findY = Integer.parseInt(st.nextToken());
            System.out.println(LCA(findX, findY));
        }
    }

    static int LCA(int x, int y) {
        while (x > 0) {
            visited[x] = true;
            x = parent[x];
        }

        while (y > 0) {
            if (visited[y]) {
                return y;
            }
            y = parent[y];
        }

        return 0;
    }
}
