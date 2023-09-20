

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_24444_알고리즘수업_kim {
    static int nodeNum;
    static int lineNum;
    static int startP;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static Queue<Integer> queue;
    static StringBuilder sb;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        nodeNum = Integer.parseInt(st.nextToken());
        lineNum = Integer.parseInt(st.nextToken());
        startP = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new boolean[nodeNum + 1];
        queue = new LinkedList<>();
        result = new int[nodeNum + 1];

        for (int i = 0; i <= nodeNum; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        // 오름차순 정렬을 위한 Collections.sort
        for (int i = 1; i <= nodeNum; i++) {
            Collections.sort(list.get(i));
        }

        bfs(startP);

        for (int i = 1; i <= nodeNum; i++) {
            sb.append(result[i] + "\n");
        }
        
        System.out.println(sb);
    }

    public static void bfs(int startNum) {
        int cnt = 1;
        queue.offer(startNum);
        visited[startNum] = true;
        result[startNum] = cnt++;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int num : list.get(temp)) {
                if(!visited[num]) {
                    queue.offer(num);
                    visited[num] = true;
                    result[num] = cnt++;
                }
            }
        }
    }
}
