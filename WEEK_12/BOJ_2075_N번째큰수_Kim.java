package WEEK_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075_N번째큰수_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int boxSize = Integer.parseInt(br.readLine());
        // 큰것부터 우선순위큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 입력
        for (int i = 0; i < boxSize; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }

        // 줄세워서 해당 크기까지 poll한다음 찾기
        for (int i = 0; i < boxSize - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.peek());
    }
}

