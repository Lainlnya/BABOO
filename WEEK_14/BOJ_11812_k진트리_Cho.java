package Study_baekjoon;

import java.util.Scanner;

public class BOJ_11812_k진트리_Cho {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        long N =sc.nextLong();
        //범위상 long으로 받아오기
        int K = sc.nextInt();
        int Q = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        //구조가 고정되므로 그냥 바로 트리 구조 생각

        for (int i = 0 ; i < Q ; i++) {
            long num1 = sc.nextLong()-1;
            long num2 = sc.nextLong()-1;
            //실제 root는 0이어야 트리구조가 잘 돌아가기 때문에 1씩빼서 생각

            //초기 계산량 보정을 위한 방법 num1 에 작은수를 num2에는 큰 수를 할당
            long depth = 0;
            if ( K ==1) {
                depth = Math.abs(num1-num2);
                sb.append(depth+"\n");
                continue;
            }
            while (num1 != num2) {
                depth++;
                if (num1 > num2) {
                    num1 = (num1 - 1) / (long) K;
                } else {
                    num2 = (num2 - 1) / (long) K;
                }
            }
            sb.append(depth+ "\n");
        } //for Q
        System.out.println(sb);
    } // main
}
