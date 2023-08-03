package WEEK_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10262_주사위게임_Kim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ggung = new ArrayList<>(); // 꿍의 주사위 합을 위한 리스트 선언
        List<Integer> seok = new ArrayList<>(); // 석의 주사위 합을 위한 리스트 선언

        int K = 2; // 2줄로 입력 고정
        int win = 0, same = 0, result = 0, lose = 0;
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 각 a ~ b, c ~ d만큼의 범위를 더해주며 나올 수 있는 합 모두 리스트에 추가
            for(int i = a; i <= b; i++) {
                for (int j = c; j <= d; j++) {
                    if (K == 1) ggung.add(i + j);
                    else seok.add(i + j);
                }
            }
        }

        // 동일한 합의 개수를 알기 위해 sort
        Collections.sort(ggung);
        Collections.sort(seok);

        // 분모는 동일하기 때문에 분자만 비교
        // 예를 들어 석이 2일 때 꿍이 3이어야 이길 수 있기 때문에 각자의 확률의 분자를 구한 다음 더해줌
        for (int i = seok.get(0); i <= seok.get(seok.size() - 1); i++) {
            int tempSeok = Collections.frequency(seok, i); // 석이 2가 나올 확률(2의 개수)
            int temp = 0, tempSame = 0;

            for (int j = i; j <= ggung.get(ggung.size() - 1); j++) {
                int tempGgng = Collections.frequency(ggung, j);
                if (j == i) { // 만약 석과 꿍이 동일한 숫자가 나온다면 비긴 것이기 때문에 비기는 확률도 계산
                    tempSame += tempGgng;
                } else temp += tempGgng; // 비기지 않는다면 temp에 더해줌
            }
            win += (tempSeok * temp); // 석의 값에 대한 횟수 * 석이 꿍을 이길 수 있는 횟수를 다 더한 값
            same += (tempSeok * tempSame); // 석의 값에 대한 횟수 * 석과 꿍이 동일한 값이 나올 횟수를 더한 값
        }

        result = ggung.size() * seok.size(); // 나올 수 있는 전체 경우의 수
        lose = result - win - same; // 이길 확률 + 질 확률 + 비길 확률 = 전체 경우의 수

        // 결과값 프린트
        if (win == lose) {
            System.out.println("Tie");
        } else if (win < lose) {
            System.out.println("Emma");
        } else {
            System.out.println("Gunnar");
        }
    }

}