package Study_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_3584_가장가까운공통조상_Cho {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(bf.readLine());
        //테스트 케이스 담는 배열


        //부모 정보 담는 배열
        for (int repeat = 0 ; repeat <T; repeat++) {
            int N = Integer.parseInt(bf.readLine());
            int[] pN = new int[N+1];
            for (int i = 0 ; i <N-1 ; i++) {
                st = new StringTokenizer(bf.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                pN[child] = parent;
            }
            st = new StringTokenizer(bf.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            Set<Integer> num1Parents = new TreeSet<>();
            num1Parents.add(num1);
            while (pN[num1] != 0) {
                num1Parents.add(pN[num1]);
                num1 = pN[num1];
            } //num1의 부모 전부 넣어놓은 set num1Parents만들기

            while (!num1Parents.contains(num2)) {
                num2 = pN[num2];

            } //구조적으로 반드시 같은 부모가 존재함
            System.out.println(num2);
        }

    }
}
