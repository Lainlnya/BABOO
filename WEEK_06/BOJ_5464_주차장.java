package baek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5464_주차장 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] Rs = new int[N];
        int[] weight = new int[M + 1];
        for (int i = 0; i < N; i++) {
            Rs[i] = sc.nextInt();
        }
        for (int i = 1; i <= M; i++) {
            weight[i] = sc.nextInt();
        } //받아오기
        int total = 0;
        int[] place = new int[N]; //주차장 공간 만들기
        int size = 0; //빈 자리 개수
        Queue<Integer> queue = new LinkedList<>();
        for (int repeat = 0; repeat < M * 2; repeat++) {
            int num = sc.nextInt();
            if (num > 0) {
                if (size < N) {
                    for (int i = 0; i < N; i++) {
                        if (place[i] == 0) {
                            place[i] = num;
//                            System.out.printf("%d %d", size, num);
                            total += weight[num] * Rs[i];
                            size++;
                            break; //앞에서 부터 빈자리에 넣어주기 그 시점에서 계산;
                        }
                    }
                } // size if
                else {
                    queue.add(num); //빈 자리 없으면 queue에 넣어주기
                }

            } //num>0 if
            else {
                for (int i = 0; i < N; i++) {
                    if (place[i] == -num) {
                        if (!queue.isEmpty()) {
                            place[i] = queue.poll();
                            total += weight[place[i]] * Rs[i];
                            break; //공간 비워주기, queue에 뭔가있다면 바로 집어 넣기
                        } else {
                            place[i] = 0;
                            size--;
                            break; // 아니면 공간만 비워주기
                        }

                    }
                }

            } //num <= 0

        }
        System.out.println(total); //계 산
    }
}
