package WEEK_07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6198_옥상정원꾸미기_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int[] park = new int[total];
        long answer = 0;

        // 입력
        for (int i = 0; i < total; i++) {
            park[i] = Integer.parseInt(br.readLine());
        }

        // 자기 자신보다 앞에 있는 빌딩 중에서 반드시 작아야만 보이기기 때문에 아래 반복문 수행
        for (int i = 0; i < total - 1; i++) {
            for (int j = i + 1; j < total; j++) {
                if (park[i] > park[j]) {
                    answer++;
                } else break;
            }
        }

        // 정답 출력
        System.out.println(answer);
    }
}
