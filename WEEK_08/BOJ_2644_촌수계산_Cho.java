import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2644 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        Set<Integer>[] gagyedo = new HashSet[N + 1];
        for (int i = 0; i <= N; i++)
            gagyedo[i] = new HashSet<>();
        // arraylist써도 되지만 여기서는 hash set을 사용
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            gagyedo[child].add(parent);
        } // 입력받기 끝 추적은 부모를 찾는 과정이기 때문에 자식 -> 부모 방향으로 넣어줌
        // 문제에서 부모는 1명이라고 명시하여 set, arraylist등을 사용할 필요는 없음 다만 그냥 2명이상 연결되는 경우에도 사용할 수
        // 있도록 연습용

        ArrayList<Integer> p1Parent = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        p1Parent.add(p1);
        stack.add(p1);

        while (!stack.isEmpty()) {

            for (int person : gagyedo[stack.pop()]) {
                stack.push(person);
                p1Parent.add(person);
            }
        } // 스택이 빌때까지 하나씩 가계도를 올라가며 p1부모라인 만들기 stack 확장for문 사용필요 없지만 나중에 어려운 문제용 연습

        stack.add(p2);
        int chonsu = 0;
        if (p1Parent.contains(p2)) {
            chonsu += p1Parent.indexOf(p2);
            System.out.println(chonsu);
            System.exit(0);
        }
        while (!stack.isEmpty()) {
            chonsu++;
            for (int person : gagyedo[stack.pop()]) {
                if (p1Parent.contains(person)) {
                    chonsu += p1Parent.indexOf(person);
                    System.out.println(chonsu);
                    System.exit(0);
                }
                stack.push(person); //한명의 가계도 만든다음에 다른 한사람의 부모를 계속보다가 한명의 가계도 라인을 만나면 그시점에서 계산
                // p1의 부모어레이의 index를 활용해서 계산

            }

        } //dfs 기초구조
        {

        }
        System.out.println(-1);
        // p1부모라인 //p2 부모라인 체크
    }
}
