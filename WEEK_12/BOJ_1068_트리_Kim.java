package WEEK_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1068_트리_Kim {
    static int nodeNum, root, leaf;
    static int removeNode;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeNum = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[nodeNum];
        leaf = 0;

        for (int i = 0; i < nodeNum; i++) {
            tree.add(new ArrayList<Integer>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        for (int i = 0; i < nodeNum; i++) {
            int node = Integer.parseInt(st.nextToken());
            // -1이면 root노드이기 때문에 root 지정
            if (node == -1) {
                root = i;
            } else {
                tree.get(node).add(i);
            }
        }

        removeNode = Integer.parseInt(br.readLine());

        // 제거할 노드 방문처리하여 dfs 돌지 않도록
        visited[removeNode] = true;

        // root와 동일하면 그냥 0출력하고 return
        if (removeNode == root) {
            System.out.println(0);
            System.exit(0);
        }

        dfs(root);

        System.out.println(leaf);
    }

    static void dfs(int num) {
        boolean flag = true;

        for (int i = 0; i < tree.get(num).size(); i++) {
            if (visited[tree.get(num).get(i)]) continue;

            // 여기 들어왔다는 것은 leaf가 있다는 뜻이므로 flag false
            flag = false;

            // 방문처리
            visited[tree.get(num).get(i)] = true;

            dfs(tree.get(num).get(i));
        }
        // 그대로 flag true면 leaf증가
        if (flag) leaf ++;
    }
}

