import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] pN;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        visited = new boolean[N + 1];
        //트리 순회를 위한 visited
        dp = new int[N + 1][2];
        //자기자신이 어댑터일때 아닐때 0,1에 기록한 dp
        pN = new int[N + 1];
        //부모 배열
        pN[1] = -1;
        visited[0] = true;
        // root 설정
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            dp[i][1] = 1;
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            list[num1].add(num2);
            list[num2].add(num1);

        }

        makeTree(list);

        System.out.println(Math.min(dp[1][0],dp[1][1]));
        //루트가 어댑터인것과 아닌것중 큰것 출력
    }

    public static void makeTree(ArrayList[] list) {
        Stack<Integer> rootStack = new Stack<>();
        rootStack.push(1);
        // root를 1로 설정
        while (!rootStack.isEmpty()) {
            int nowNode = rootStack.peek();
            //stack에서 꺼내보고 처음꺼내면 visited 트루만들고 부모 설정 및 stack에 추가
            if (visited[nowNode]) {
                checkAdapt(nowNode, list[nowNode]);
                rootStack.pop();
                continue;
            }
            // 이미 한번꺼내봣으면 필연적으로 본인자식들 계산 다됐으므로 dp 계산
            visited[nowNode] = true;
            for (Object child : list[nowNode]) {
                int cN = (int) child;
                if (!visited[cN]) {
                    pN[cN] = nowNode;
                    rootStack.push(cN);
                }
            } // if
        }

    } // while stack[nowNode]

    static void checkAdapt(int p, ArrayList<Integer> list) {
//		System.out.print("nowNode :" + p + "\n nowNode연결된 노드");

//		for (int i : list) {
//			System.out.print(i + " " );
//		}
//		System.out.println();
        for (int node : list) {
            if (pN[p] == node)
                continue;
            dp[p][0] += dp[node][1];
            dp[p][1] += Math.min(dp[node][0], dp[node][1]);
        }


    } // 자기 자식이 전부 얼리어댑터면 자기는 어댑터 x, 그 외의 경우에는 본인이 어댑터 본인이 어댑터면 +1 해서 dp에 저장
} // while[rootStack] 1을 루트로 정렬 완료
// 스택에 넣으면서 트리를 기준으로 전부 꺼내서 확인


