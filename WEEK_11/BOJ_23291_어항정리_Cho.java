import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, K, min, max, pastIdx, startIdx;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<Integer>[] uh;
    static ArrayList<Integer> minIdx = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        uh = new ArrayList[N];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            uh[i] = new ArrayList<>();
            int fishs = sc.nextInt();
            uh[i].add(fishs);


        } // 입력 끝
        int count = 0;
        int diff = minMaxFish();
//        System.out.println(minMaxFish());
        while (diff > K) {
            for (int uhNumber : minIdx)
                uh[uhNumber].set(0, uh[uhNumber].get(0) + 1); //어항에 물고기 추가
            magic1();
            moveFish1();
            magic2();
            moveFish2();

            count++;
            diff = minMaxFish();

        }
        System.out.println(count);

    }//main

    static int minMaxFish() {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, uh[i].get(0));
            if (min > uh[i].get(0)) {
                min = uh[i].get(0);
                minIdx.clear();
                minIdx.add(i);

            } else if (min == uh[i].get(0)) {
                minIdx.add(i);
            } // 최소 어항 기록
        }
        return max - min;

    } // 최대 어항 기록 최소 최대 차이 구하는 용

    static void magic1() {
        pastIdx = 0;
        startIdx = 1;
        int h = uh[pastIdx].size(); //반복 사이즈 정하기
        while (startIdx + h - 1 < N) {
            for (int repeat = startIdx - 1; repeat >= pastIdx; repeat--) {
                for (int i = 0; i < h; i++) {
                    uh[startIdx + i].add(uh[repeat].get(i));
                } //돌려서 올려놓는거 반복 행 열이 교환 되는 느낌으로 생각하면 조금 더 쉬움 물몬 그래도 어려움


            }
            pastIdx = startIdx;
            startIdx += h;
            h = uh[pastIdx].size(); //넘치기 전까지 옮겨야하기 때문에 과거 지점 시작지점 돌리게 될 높이 새로저장해서 while 반복

        }


    } //magic1

    static void moveFish1() {
        int[] tmpUh = new int[N];
        int idx = 0;
        for (int i = pastIdx; i < N; i++) {
            for (int j = 0; j < uh[i].size(); j++) {
                tmpUh[idx] = uh[i].get(j);
                for (int delta = 0; delta < 4; delta++) {
                    int newI = i + dr[delta];
                    int newJ = j + dc[delta];

                    if (newI >= pastIdx && newJ >= 0 && newI < N && newJ < uh[newI].size()) {
                        if (uh[newI].get(newJ) >= uh[i].get(j)) {

                            tmpUh[idx] += (uh[newI].get(newJ) - uh[i].get(j)) / 5;

                        } else {
                            tmpUh[idx] -= (uh[i].get(j) - uh[newI].get(newJ)) / 5;
                        } //과거 시작지점부터 끝까지 진행된다는 점을 생각해서 진행. i가 가로, j가 세로
                        // j값이 i에 따라 다르고 j값이 어디까지일지 확실히 알기 어렵기 때문에 ArrayList 활용
                    }
                } //delta
                idx++;
            }// j for
        }// i for
        for (int i = 0; i < N; i++) {
            uh[i].clear();
            uh[i].add(tmpUh[i]); //계산을 바로하면 영향을 받기 때문에 바로하지 않고 복사본을 만들고 옮겨줌
//            System.out.print(uh[i].get(0) + "   ");
        }
    } //moveFish and sort

    static void magic2() {
        pastIdx = 0;
        startIdx = N / 2;
        int h = 1;
        int idx = 0;

        while (idx < 2) {
            for (int j = h-1; j >= 0; j--) {
                int sIdx = 1; // 시작 끝 지점이 바뀌기 때문에 읽어오는 것과 쓰는 것의 방향을 바꾸는 용도
                for (int i = startIdx ; i <N; i++) {
                    uh[i].add(uh[startIdx-sIdx++].get(j));

                }


            }
            pastIdx = startIdx;
            startIdx = N/4 *3;
            h = uh[pastIdx].size();
            idx++;
        } //마법2는 연습용으로 이렇게 했지만 사실 돌리는 횟수가 두번으로 고정이고 시작 끝 지점도 알기 쉬워서 하고싶은대로 해도 됨

//        for (int i = pastIdx; i < N; i++) {
//            for (int num : uh[i]) {
//                System.out.print(num + " ");
//
//            }
//            System.out.println();
//
//        }
    }
    static void moveFish2() {
        int[] tmpUh = new int[N];
        int idx = 0;
        for (int i = pastIdx; i < N; i++) {
            for (int j = 0; j < uh[i].size(); j++) {
                tmpUh[idx] = uh[i].get(j);
                for (int delta = 0; delta < 4; delta++) {
                    int newI = i + dr[delta];
                    int newJ = j + dc[delta];

                    if (newI >= pastIdx && newJ >= 0 && newI < N && newJ < uh[newI].size()) {
                        if (uh[newI].get(newJ) >= uh[i].get(j)) {

                            tmpUh[idx] += (uh[newI].get(newJ) - uh[i].get(j)) / 5;

                        } else {
                            tmpUh[idx] -= (uh[i].get(j) - uh[newI].get(newJ)) / 5;
                        }
                    } //moveFish1() 과 크게 다르지 않음 높이가 4로 고정에, 가로 길이는 N/4로 고정이라 훨씬 구현이 쉬움
                    // 공부차 그냥 가로 세로 길이가 다를 때도 적용할 수 있게 만듬
                } //delta
                idx++;
            }// j for
        }// i for
        for (int i = 0; i < N; i++) {
            uh[i].clear();
            uh[i].add(tmpUh[i]);
        }
    } //moveFish and sort


}
