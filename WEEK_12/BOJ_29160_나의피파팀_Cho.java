package tree;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_29160_나의피파팀_Cho {
    static int[] bestTeam = new int[12];
    static PriorityQueue<Integer>[] bestPlayer = new PriorityQueue[12];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 11; i++) {
            bestPlayer[i] = new PriorityQueue<>(Collections.reverseOrder());
            bestPlayer[i].add(0);
        } // 포지션이 비었을 때 공석이면 0과 같다. 예외처리가 번거로우니 0을 전부 넣어둔다.
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int po = sc.nextInt();
            int status = sc.nextInt();
            bestPlayer[po].add(status);
        } //포지션 별로 최대힙 만들어서 선수 전부 넣기 완료
        for (int year = 0; year < K; year++) {
            makeTeam(); //3월에 팀 구성
            decreaseStatus(); //8월에 스탯 하락
            makeTeam(); //11월에 팀 재구성
        }
        int sum = 0;
        for (int i = 1; i <= 11; i++) {
            sum += bestTeam[i];
        } //팀스탯 합치기
        System.out.println(sum);

    } //main

    static void makeTeam() {
        for (int i = 1; i <= 11; i++) {
            if (bestTeam[i] < bestPlayer[i].peek()) {
                bestPlayer[i].add(bestTeam[i]);
                bestTeam[i] = bestPlayer[i].poll();
            } //bestPlayer 슬쩍보고 지금 팀보다 나으면 뽑고 아니면 말고
            // 이 때 뽑게 되면 지금 플레이어를 다시 넣어주어야한다.

        }
    }

    static void decreaseStatus() {
        for (int i = 1; i <= 11; i++) {
            if (bestTeam[i] > 0)
                bestTeam[i]--;
        } //0보다 크면 다 1씩 감소
    }
}
