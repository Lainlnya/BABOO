package WEEK_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 10m
public class BOJ_7795_EatGetEaten_kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[Integer.parseInt(st.nextToken())]; // 생명체A
            int[] B = new int[Integer.parseInt(st.nextToken())]; // 생명체B
            int answer = 0;

            // 생명체 A저장
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            // 생명체 B저장
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 B 정렬
            Arrays.sort(B);

            for (int i = 0; i < A.length; i++) {
                // A가 B의 마지막보다 클 경우 전부 해당 되므로 B의 길이만큼 더함
                if (A[i] > B[B.length - 1]) {
                    answer += B.length;
                } else { // 아닐 경우 A가 B보다 큰 경우만 더해줌
                    for (int j = 0; j < B.length; j++) {
                        if (A[i] > B[j]) {
                            answer++;
                        }
                    }
                }
            }
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }
}
