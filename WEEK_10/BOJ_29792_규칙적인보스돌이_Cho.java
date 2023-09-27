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
        double[][] P = new double[K + 1][2]; // 체력은 0 메소는 1;
        for (int i = 1; i <= K; i++) {
            P[i][0] = sc.nextDouble();
            P[i][1] = sc.nextDouble();
        }
        int maxMeso = 0;
        for (int i = N - 1; i > N - 1 - M; i--) {
            int[][] dp = new int[K + 1][901];

            for (int j = 1; j <= K; j++) {
                int killBossTime = (int) Math.ceil(P[j][0] / dps[i]); //해당 보스 잡는데 걸리는 시간
                int earnMeso = (int) P[j][1]; //얻는 돈양

                for (int k = 1; k <= 900; k++) {
                    if (k - killBossTime >= 0)
                        dp[j][k] = Math.max(dp[j-1][k - killBossTime] + earnMeso, dp[j - 1][k]);
                    // 이 보스 잡은 것과 안잡은 것 비교해서 돈 버는게 많은 거 선택
                    else
                        dp[j][k] = dp[j - 1][k];
                    //boss잡기전에는 무조건 못잡으니까 그 전 dp참조
                }



            }
            maxMeso += dp[K][900];
        }
        System.out.println(maxMeso);

    } // main


}
