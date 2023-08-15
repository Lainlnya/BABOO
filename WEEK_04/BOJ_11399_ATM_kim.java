package WEEK_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 20m
public class BOJ_11399_ATM_kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int personCount = Integer.parseInt(br.readLine());
        int[] ATM = new int[personCount];
        int[] result = new int[personCount]; // 결과를 담을 배열 선언
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < personCount; i++) {
            ATM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ATM); // 정렬 되었을 때 시간이 가장 최소로 걸리기 때문에 sort
        result[0] = ATM[0]; // 제일 첫 값
        for(int i = 1; i < personCount; i++) {
            result[i] = result[i - 1] + ATM[i]; // 누적해서 더해지기 때문에 이전에 걸린 시간과 현재 걸린 시간 더해줌
        }

        for (int plus : result) {
            answer += plus;
        }
        System.out.println(answer);

    }
}
