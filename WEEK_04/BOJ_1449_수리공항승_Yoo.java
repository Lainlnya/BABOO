
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 개수 입력
		int N = sc.nextInt();

		// 테이프 길이
		int L = sc.nextInt();

		int[] arr = new int[N];
	

		//배열입력받기
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		//처음 시작지점에 테이프 붙이고 시작
		int cnt = 1;
		// 처음 시작지점을 A로 지정
		int A = arr[0];

		for (int i = 1; i < N; i++) {
			// 테이프 길이안에 있으면 pass
			if (arr[i] < A + L)
				continue;
			// 길이 넘어가면 새로 붙이면서 시작지점 교체
			else {
				cnt++;
				A = arr[i];
			}
		}

		System.out.println(cnt);
	}
}
