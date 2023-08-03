package WEEK_02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13251_조약돌꺼내기_Kim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); // 조약돌 색상
        int[] arr = new int[M]; // 조약돌 색상 수 만큼의 배열 생성
        int total = 0, K = 0; // 전체 수를 계산하기 위한 total 변수와 랜덤하게 뽑을 수인 K 변수 선언
        double answer = 0; // 정답을 위한 변수 선언
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 횟수를 구하기 위해 total에 더하고, 각 수는 arr 배열에 저장
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        // 랜덤으로 뽑을 수 할당하기
        K = Integer.parseInt(br.readLine());

        // 만약 arr = [5, 7]이고 2개를 뽑는다고 가정했을 때
        // 뽑는 횟수만큼 arr[i]와 temp값이 적어지며 해당 확률을 answer에 곱해준다.
        for (int i = 0; i < M; i++) {
            if (arr[i] >= K) { // 5 >= 1
                int temp = total; // total = 12
                int temp2 = K; // 1

                double tempAnswer = 1;
                while (temp2-- > 0) {
                    tempAnswer *= (arr[i]-- / (double) temp--);
                }
                answer += tempAnswer;
            }
        }
        System.out.println(answer >= 1 ? 1 : answer);

    }
}
