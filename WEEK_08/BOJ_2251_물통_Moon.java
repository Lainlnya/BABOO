package BOJ_2251_물통;

import java.util.Scanner;

public class Main {
    
    static int[] limit = new int[3]; // 각 물통의 크기
    static boolean[][][] visited; // 그 물 상태가 나온 적 있는건지 확인해줘야 함
    static int[] answer = new int[201]; // 각 index와 L값을 짝지어 줌
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < limit.length; i++) limit[i] = sc.nextInt();
        visited = new boolean[201][201][201]; // 모든 상태에 대해 방문한 적 있는지를 기록
        
        water(0, 0, limit[2]); // 처음 상태
        
        // 출력
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0) {
                System.out.print(i+" ");
            }
        }
        
        sc.close();
    } //main
    
    public static void water(int a, int b, int c) {

        if (visited[a][b][c] == true) {
            return; // 이미 온 적 있으면 재귀 종료
        } else {
            visited[a][b][c] = true;
            if (a == 0) answer[c]++; // 온 적 없으면 방문표시 하고 조건에 맞는 상태는 기록
        }
        
        // A->B
        if (limit[1] >= a+b) water(0, a+b, c);
        else water(a+b-limit[1], limit[1], c);
        
        // A->C
        if (limit[2] >= a+c) water(0, b, a+c);
        else water(a+c-limit[2], b, limit[2]);
        
        // B->A
        if (limit[0] >= a+b) water(a+b, 0, c);
        else water(limit[0], a+b-limit[0], c);
        
        // B->C
        if (limit[2] >= b+c) water(a, 0, b+c);
        else water(a, b+c-limit[2], limit[2]);
        
        // C->A
        if (limit[0] >= a+c) water(a+c, b, 0);
        else water(limit[0], b, a+c-limit[0]);
        
        // C->B
        if (limit[1] >= b+c) water(a, b+c, 0);
        else water(a, limit[1], b+c-limit[1]);
        
    } //water
}