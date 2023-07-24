package WEEK_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940_RcCar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            int speed = 0, result = 0;
            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                switch (Integer.parseInt(st.nextToken())) {
                    case 1:
                        int temp1 = Integer.parseInt(st.nextToken());
                        speed += temp1;
                        result += speed; // 2
                        break;
                    case 2:
                        int temp2 = Integer.parseInt(st.nextToken()); // 1
                        if (speed - temp2 < 0) speed = 0;
                        else speed -= temp2;
                        result += speed;
                        break;
                    case 0:
                        result += speed;
                        break;
                }
            }
            sb.append("#" + (i + 1) + " " + result + "\n");
        }
        System.out.println(sb);
    }
}
