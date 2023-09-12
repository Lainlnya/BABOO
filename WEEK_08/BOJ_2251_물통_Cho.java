
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BOJ_2251 {
    static int[] capacity = new int[3];
    static int[] currWater = new int[3];
    static boolean[][][] visited;
    static Set<Integer> CC = new TreeSet<>();
    //treeset으로 하면 중복 x 크기순으로 정렬도 해줌
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 3; i++)
            capacity[i] = sc.nextInt();
        currWater[2] = capacity[2];
        int A = currWater[0];
        int B = currWater[1];
        int C = currWater[2];
        // a b 비고 c 채워진 상태
        visited = new boolean[capacity[0]+1][capacity[1]+1][capacity[2]+1];
        // 완탐 들린곳은또 안들리기위한 visited a, b, c에 해당하는 값을 탐색했는지 안했는지 확인용
        dfs(A, B, C);
        // C가 꽉차있는 상태로 넣어줌
        for (int num : CC) {
            System.out.print(num + " ");
        }
    }

    public static void dfs(int A, int B, int C) {
        // 기저
        CC.add(A+C);
        //A가 비어야하므로 a에 남은거 c에 넣어줌

        // 재귀
        if (!visited[A][B][C]) {
            visited[A][B][C] = true;

            for (int i = 0; i < 3; i++) {
                if(currWater[i] !=0) {
                    currWater[0] = A;
                    currWater[1] = B;
                    currWater[2] = C;
                    pour(i, (i+1)%3);
                    //curr은 if 문 쉽게 돌리기 및 pour 에 쓸려고 만듬
                    dfs(currWater[0],currWater[1],currWater[2]);
                    currWater[0] = A;
                    currWater[1] = B;
                    currWater[2] = C;
                    pour(i, (i+2)%3);
                    dfs(currWater[0],currWater[1],currWater[2]);
                    //빈통이아닐때 거기 들어있는것을 다른 통에 넣는 두가지 시행해준것
                }
            }

        }

    }

    static void pour(int in, int put) {
        if (currWater[in] < capacity[put] - currWater[put]) {
            currWater[put] += currWater[in];
            currWater[in] = 0;
        } else {
            currWater[in] -= capacity[put] - currWater[put];
            currWater[put] = capacity[put];
        }
    } //다른 통에 넣는 로직 구현한 것.

}