package WEEK_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액_Kim {
    static int portionNum, minimum, startP, endP;
    static int[] portion;
    public static void main(String[] args) throws IOException {
        // -99, -2, -1, 4, 98
        // 반복문으로 기준점 잡고 그 뒤에꺼에서 BST
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        portionNum = Integer.parseInt(br.readLine());
        portion = new int[portionNum];
        // 최소 합을 찾기 위한 value
        minimum = Integer.MAX_VALUE;
        // 어느 지점에서 적은지를 찾기 위한 point들
        startP = 0; endP = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < portionNum; i++) {
            portion[i] = Integer.parseInt(st.nextToken());
        } // 입력끝

        // 정렬
        Arrays.sort(portion);

        // 하나의 지점을 기준으로 이진검색 시작
        for (int i = 0; i < portionNum; i++) {
            BST(i, i + 1, portionNum - 1);
        }

        System.out.println(portion[startP] + " " + portion[endP]);
    }

    // 이진검색 (기준지점, 시작, 끝)
    static void BST(int pin, int start, int end) {

        while (start <= end) {
            // 가운데 지정
            int mid = (start + end) / 2;

            // 기준 지점 + 중간 지점
            int sum = portion[pin] + portion[mid];

            // 최소값이랑 비교해서 작았을 때 start와 end 갱신
            if (minimum > Math.abs(sum)) {
                minimum = Math.abs(sum);
                startP = pin;
                endP = mid;
            }

            // 정렬되어 있으니까 만약에 sum이 음수면 시작 지점 변경, sum이 양수면 끝 지점 변경
            if (sum < 0)
                start = mid + 1;
            else
                end = mid - 1;
        }
    }
}
