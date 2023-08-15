package WEEK_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 40m
public class BOJ_1449_RepairMan_kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int leakNum = Integer.parseInt(st.nextToken()); // 새는 숫자
        int tape = Integer.parseInt(st.nextToken()); // 테이프 길이
        int[] leak = new int[leakNum]; // leak을 담을 배열
        int answer = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < leakNum; i++) {
            leak[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leak); // 정렬
        double first = leak[0] - 0.5; // 기준
        for (int i = 0; i < leakNum; i++) {
            if (leak[i] < (first + tape)) { // 기준 + 테이프 길이 보다 작으면 테이프 길이 내
                continue; // 그냥 지나침
            } else { // 길이 넘을 경우 answer 더해주고 기준 변경
                answer++;
                first = leak[i] - 0.5;
            }
        }

        System.out.println(answer);
    }
}
