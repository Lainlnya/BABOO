import java.util.*;

import java.util.ArrayList;
import java.util.Stack;

public class BOJ_2617 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int M = sc.nextInt();
    static int noMiddleCount = 0;
    static int count;
    static int middlePoint = (N + 1) / 2; //가운데 지점 미리 계산
    static boolean[] checked = new boolean[N + 1];
    static boolean[] visited;
    static Set<Integer>[] bigger = new HashSet[N + 1];
    static Set<Integer>[] smaller = new HashSet[N + 1];
    // 더 무거운게 middlePoint보다 많은지, 더 가벼운게 middlePoint보다 많은지 확인을 위해 두개 만듬
    // 어레이리스트로 했더니 나쁜녀석들이 같은 구슬 실험해서 예외만들어놨음
    static Stack<Integer> stack = new Stack<>();
    //dfs 기초 구조를 위한 스택
    public static void main(String[] args) {
        for (int i = 0; i < N + 1; i++) {
            bigger[i] = new HashSet<>();
            smaller[i] = new HashSet<>();
        }
        for (int i = 0; i < M; i++) {
            int gusel1 = sc.nextInt();
            int gusel2 = sc.nextInt();
            bigger[gusel1].add(gusel2);
            smaller[gusel2].add(gusel1);
        } // 입력 끝

        for (int i = 1; i <= N; i++) {
            count = 0;
            visited = new boolean[N + 1];
            visited[i] = true;
            dfsBig(i);
        } //큰거 bfs
        for (int i = 1; i <= N; i++) {
            if (!checked[i]) {
                count = 0;
                visited = new boolean[N + 1];
                visited[i] = true;
                dfsSmall(i);

            } //작은거 bfs

        }
        System.out.println(noMiddleCount);

    } // main

    public static void dfsBig(int number) {
        for (int num : bigger[number]) {
            count++;
            visited[num] = true;
            stack.push(num);
        } // if
        while (!stack.isEmpty()) {
            int presentNum = stack.pop();

            for (int num : bigger[presentNum]) {
                if (!visited[num]) {
                    count++;
                    visited[num] = true;
                    stack.push(num);
                } // if
            } // for
            if (count >= middlePoint) {
                checked[number] = true;
                noMiddleCount++;
                stack.clear();
                return;
            }
        } // while
    }

    public static void dfsSmall(int number) {
        for (int num : smaller[number]) {
            count++;
            visited[num] = true;
            stack.push(num);
        } // if
        while (!stack.isEmpty()) {
            int presentNum = stack.pop();

            for (int num : smaller[presentNum]) {
                if (!visited[num]) {
                    count++;
                    visited[num] = true;
                    stack.push(num);
                } // if
            }
            if (count >= middlePoint) {
                checked[number] = true;
                noMiddleCount++;
                stack.clear();
                return;
            } // for
        } //dfs 기초 구조 그대로, 스택에 방문안한거 하나씩 열어보면서 stack에 추가 stack이 비면 나옴
        // stack다 비우기 전에 이미 가볍거나 무거운게 절반이상있으면 그 시점에서 중간값이 될 수 없는거 꺼내고 nomiddlePoint++
    }

}

