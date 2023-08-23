package BOJ_12018_YonseiTOTO;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // N 수업 수
        int M = sc.nextInt(); // M 마일리지
        int[] cut = new int[N]; // cut 그래서 몇점 써야 그 수업 들을 수 있는지
        
        for (int subject = 0; subject < N; subject++) {
            int people = sc.nextInt(); // people 각 수업 신청한 수강생 수
            int limit = sc.nextInt(); // limit 수강인원 제한
            
            int[] bet = new int[people]; // bet 그 신청한 수강생들이 마일리지를 몇점 썼는지
            for (int i = 0; i < people; i++) {
                bet[i] = sc.nextInt();
            }
            Arrays.sort(bet);
            
            if (limit <= people) cut[subject] = bet[people-limit];
            // 만약 정원보다 신청자수가 많거나 같으면, 막차 탄 사람이 쓴 마일리지 값을 저장한다.
            else cut[subject] = 1;
            // 정원이 가득차지 않았다면, 최소 마일리지인 1을 저장한다.
            
        } //subject
        
        Arrays.sort(cut); // 각 수업을 듣기 위해 필요한 최소 마일리지 값을 저장한 배열을 오름차순으로 정렬한다.
        
        int sub = 0;
        // 필요한 마일리지가 적은 수업부터 신청한다.
        while (M >= cut[sub]) {
        	M -=cut[sub]; // 마일리지를 사용한다.
        	sub++; // 신청한 수업 수 ++
        	if (sub == cut.length) break; // 존재하는 수업을 모두 신청했을 경우 break한다.
        }
        
        System.out.println(sub);
        
        sc.close();
    }
}