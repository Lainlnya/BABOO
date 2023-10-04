package WEEK_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_22115_창영이와커피_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coffeeNum = Integer.parseInt(st.nextToken()); // 커피 개수
        int caffine = Integer.parseInt(st.nextToken()); // 카페인
        int[] coffeeSet = new int[coffeeNum + 1];

        st = new StringTokenizer(br.readLine());

        // 커피세트 초기화
        for (int i = 1; i <= coffeeNum; i++) {
            coffeeSet[i] = Integer.parseInt(st.nextToken());
        }

        // 1부터 계산하기 위한 크기 배열
        int[] dp = new int[caffine + 1];
        // 최대값으로 초기화
        Arrays.fill(dp, 1000000000);

        // 0일때는 마시지 않아도 되기 때문에 0으로 초기화
        dp[0] = 0;

        int coffeeIndex = 1;
        while (coffeeNum-- > 0) {
            for (int i = caffine; i >= coffeeSet[coffeeIndex]; i--) {
                dp[i] = Math.min(dp[i], dp[i - coffeeSet[coffeeIndex]] + 1);
            }
            coffeeIndex++;
        }

        if (dp[caffine] > 100) System.out.println(-1);
        else System.out.println(dp[caffine]);
    }
}
