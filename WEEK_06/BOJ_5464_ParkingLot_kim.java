package WEEK_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 20m
public class BOJ_5464_ParkingLot_kim {
    static int space, carN;
    static int[] spaceArr, carArr;
    static int[] parking;
    static Queue<Integer> waiting;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        space = Integer.parseInt(st.nextToken()); // 공간
        carN = Integer.parseInt(st.nextToken()); // 차개수
        parking = new int[space + 1]; // 주차장
        waiting = new LinkedList<>(); // 웨이팅 리스트
        spaceArr = new int[space + 1]; // 공간
        carArr = new int[carN + 1]; // 차량
        answer = 0;

        for (int i = 1; i <= space; i++) {
            spaceArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= carN; i++) {
            carArr[i] = Integer.parseInt(br.readLine());
        }

        carMap: for (int i = 0; i < carN * 2; i++) {
            int seq = Integer.parseInt(br.readLine()); // 일단 숫자 받기
            if (seq > 0) { // 양수여야 주차하겠다는 뜻
                for (int j = 1; j < space + 1; j++) {
                    if (parking[j] == 0) {
                        parking[j] = seq;
                        continue carMap;
                    }
                }
                waiting.offer(seq);
            } else { // 차량 뺄 때
                for (int j = 1; j < space + 1; j++) {
                    if (parking[j] == -seq) {
                        parking[j] = 0;
                        answer += spaceArr[j] * carArr[-seq];
                        if (!waiting.isEmpty()) { // 이때 웨이팅 리스트에 차 있으면 그 자리에 넣어주기
                            parking[j] = waiting.poll();
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
