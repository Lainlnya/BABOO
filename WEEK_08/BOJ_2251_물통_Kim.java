package WEEK_08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2251_물통_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aBin = Integer.parseInt(st.nextToken());
        int bBin = Integer.parseInt(st.nextToken());
        int cBin = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();

        boolean[][][] visited = new boolean[aBin + 1][bBin + 1][cBin + 1];

        queue.add(new int[]{0, 0, cBin});

        while (!queue.isEmpty()) {
            int[] check = queue.poll();
            if(!visited[check[0]][check[1]][check[2]]) {
                visited[check[0]][check[1]][check[2]] = true;

                // 정답이 가능한 경우 => a가 0일때 => 그때 C를 담기
                if (check[0] == 0) answer.add(check[2]);

                // 이제 모든 케이스 비교
                // A랑 B
                if (check[0] + check[1] > aBin) {
                    queue.add(new int[]{aBin, check[0] + check[1] - aBin, check[2]});
                } else queue.add(new int[]{check[0] + check[1], 0, check[2]});

                if (check[0] + check[1] > bBin) {
                    queue.add(new int[]{check[0] + check[1] - bBin, bBin, check[2]});
                } else queue.add(new int[]{0, check[0] + check[1], check[2]});

                // A랑 C
                if (check[0] + check[2] > aBin) {
                    queue.add(new int[]{aBin, check[1], check[0] + check[2] - aBin});
                } else queue.add(new int[]{check[0] + check[2], check[1], 0});

                if (check[0] + check[2] > cBin) {
                    queue.add(new int[]{check[0] + check[2] - cBin, check[1], cBin});
                } else queue.add(new int[]{0, check[1], check[0] + check[2]});

                // B랑 C
                if (check[1] + check[2] > bBin) {
                    queue.add(new int[]{check[0], bBin, check[1] + check[2] - bBin});
                } else queue.add(new int[]{check[0], check[1] + check[2], 0});

                if (check[1] + check[2] > cBin) {
                    queue.add(new int[]{check[0], check[1] + check[2] - cBin, cBin});
                } else queue.add(new int[]{check[0], 0, check[1] + check[2]});
            }

        }

        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
}
