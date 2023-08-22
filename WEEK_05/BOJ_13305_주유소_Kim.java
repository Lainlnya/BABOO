package WEEK_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13305_주유소_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityNum = Integer.parseInt(br.readLine()); // 도시의 개수
        long[] road = new long[cityNum - 1]; // 도시까지의 거리
        long[] city = new long[cityNum]; // 도시의 리터당 가격
        long answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cityNum - 1; i++) { // 도로의 길이 입력
            road[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cityNum; i++) { // 도시 리터당 가격 저장
            city[i] = Integer.parseInt(st.nextToken());
        }

        long minNum = city[0];
        for (int i = 0; i < cityNum - 1; i++) {
            if (minNum > city[i]) {
                minNum = city[i];
            }
            answer += (road[i] * minNum);
        }
        System.out.println(answer);
    }
}