import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] pN;
    //index번호의 부모가 pN[index]에 들어가는 배열
    static int[] leng;
    //루트로 부터의 거리
    static int[] depth;
    //루트로부터 깊이

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(bf.readLine());
        pN = new int[N + 1];
        leng = new int[N + 1];
        depth = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        //부모노드 저장 배열, 위로 올라갈때 더해줘야하는 길이 배열(정점에 기록) 만들기
        Map<String, Integer> map = new HashMap<>();
        // 연결된 것 중어느 것이 자식이고 어느 것이 부모노드 인지 모르기 때문에 만들어줌
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            map.put(num1 + "-1" + num2, l);
            map.put(num2 + "-1" + num1, l);
            list[num1].add(num2);
            list[num2].add(num1);

            //연결된 거 기록
        }
        makeTree(map, list);
        list = null;
        int M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int sum = leng[n1] + leng[n2];
            while (n1 != n2) {
                if (depth[n1] > depth[n2]) {
                    n1 = pN[n1];
                } else if (depth[n1] == depth[n2]) {
                    n1 = pN[n1];
                    n2 = pN[n2];
                } else {
                    n2 = pN[n2];
                }

            } //둘이 다르면 조상 만날 때까지 거슬러올라가기, 깊이가다르면 일단 깊이를 맞춰주고 같이 올려줌

            sum -= 2* leng[n2];
            //n1이 부모까지 가는거리 + n2가 공통조상까지 가는 거리
            //n1, n2값의 복사본을 쓰는게 아니라 n1, n2값이 변하기 때문에 미리 sum에 n1, n2를 더해논것
            //그리고 마지막으로 루트에서 공통조상까지의 거리를 2번 빼면 완료
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    } //main

    public static void makeTree(Map<String, Integer> map, ArrayList[] list) {
        Stack<Integer> rootStack = new Stack<>();
        rootStack.add(1);
        //root를 1로 설정
        while (!rootStack.isEmpty()) {
            int nowNode = rootStack.pop();
            for (Object child : list[nowNode]) {
                int childNode = (int) child;
                if (childNode != pN[nowNode]) {
                    depth[childNode] = depth[nowNode] +1;
//                    System.out.println("childnode : " + childNode + "nowNode : " + nowNode + "leng[nowNode] :" + leng[nowNode]);
                    leng[childNode] = leng[nowNode] + map.get(childNode + "-1" + nowNode);
                    pN[childNode] = nowNode;
                    rootStack.add(childNode);
                } //if
            }

        } //while stack[nowNode]
    } // while[rootStack] 1을 루트로 정렬 완료
    // 스택에 넣으면서 트리를 기준으로 전부 꺼내서 확인
    // 루트로부터 거리를 계산해서 leng[childNode]에 넣어줌
}


