package BOJ_13305_주유소;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 도시 개수
		int N = sc.nextInt();

		int[] dis = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			dis[i] = sc.nextInt();
		}

		int[] oil = new int[N];
		for (int i = 0; i < N; i++) {
			oil[i] = sc.nextInt();
		}

		long sum = 0;
		long oilStart = oil[0];
		
        //마지막은 oil가격 쓸데없음
		
		for (int i = 0; i < N - 1; i++) {
            //전꺼랑 비교해서 최근께 싸면 교체,, 전께 더 싸면 전꺼로 한번 더 긁기
			if (oilStart > oil[i]) {
				oilStart = oil[i];
			}
            //처음엔 일단 필요한만큼 출발
			sum += oilStart * dis[i];
		}
		System.out.println(sum);
	}
}
