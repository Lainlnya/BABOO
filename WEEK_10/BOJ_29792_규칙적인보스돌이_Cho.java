import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        double[] dps = new double[N];
        for (int i = 0; i < N; i++)
            dps[i] = sc.nextDouble();
        Arrays.sort(dps);
        double[][] P = new double[K + 1][2];
        for (int i = 1; i <= K; i++) {
            P[i][0] = sc.nextDouble();
            P[i][1] = sc.nextDouble();
        }
        int maxMeso = 0;
        for (int i = N - 1; i > N - 1 - M; i--) {
            int[][] dp = new int[K + 1][901];

            for (int j = 1; j <= K; j++) {
                int killBossTime = (int) Math.ceil(P[j][0] / dps[i]);
                int earnMeso = (int) P[j][1];

                for (int k = 1; k <= 900; k++) {
                    if (k - killBossTime >= 0)
                        dp[j][k] = Math.max(dp[j-1][k - killBossTime] + earnMeso, dp[j - 1][k]);
                    else
                        dp[j][k] = dp[j - 1][k];
                }



            }
            maxMeso += dp[K][900];
        }
        System.out.println(maxMeso);

    } // main


}
