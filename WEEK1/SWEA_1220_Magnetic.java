package WEEK1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1220_Magnetic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = 1;
        while (k++ <= 10) {
            int N = Integer.parseInt(br.readLine());
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    temp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                String nAs = "";
                for (int j = 0; j < N; j++) {
                    if (temp[j][i] != 0) {
                        nAs += temp[j][i];
                    }
                }
                for (int q = 0; q < nAs.length() - 1; q++) {
                    if ((String.valueOf(nAs.charAt(q)) + String.valueOf(nAs.charAt(q + 1))).equals("12")) {
                        answer++;
                        q++;
                    }
                }

            }
            sb.append("#" + (k - 1) + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
