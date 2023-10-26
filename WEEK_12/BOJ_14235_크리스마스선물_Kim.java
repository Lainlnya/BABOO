package WEEK_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 10m
public class BOJ_14235_크리스마스선물_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int totalNum = Integer.parseInt(br.readLine());
        
        // 큐 조건 선언 -> reverse로
        PriorityQueue<Integer> giftBox = new PriorityQueue<Integer>((i, j) -> j - i);

        for (int i = 0; i < totalNum; i++) {
            st = new StringTokenizer(br.readLine());

            // 충전할 선물이 있으면
            if (st.countTokens() > 1) {
                int giftNum = Integer.parseInt(st.nextToken());
                for (int j = 0; j < giftNum; j++) {
                    giftBox.offer(Integer.parseInt(st.nextToken()));
                }
                // a가 0이 들어오면
            } else {
                // 줄 선물이 없으면
                if (giftBox.isEmpty()) {
                    sb.append(-1 + "\n");
                } else {
                    int gift = giftBox.poll();
                    sb.append(gift + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
