import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int L = sc.nextInt() - 1; //양 옆 0.5씩 의미가 없기에 1빼서 길이 저장
		int[] boomArr = new int[N]; //N 길이 배열 선언
		int max = 0;
		for (int i = 0; i < N; i++) {
			boomArr[i] = sc.nextInt(); // 폭파 지점들 기록
			max = Math.max(max, boomArr[i]); //폭파 최대 지점 기록
		}

		int[] lengArr = new int[max + 1]; // 테이프 붙이기 위한 폭파 최대 지점까지의 배열 선언
		for (int i = 0; i < N; i++)
			lengArr[boomArr[i]] = 1; // 폭파 된 부분들 기록
		
		int count = 0;
		for (int i = 1; i <= max; i++) {
			if (lengArr[i] == 1) {
				count++; //뚫려있는 부분 만나면 테이프 1개 추가
				for (int j = i; j <= i + L; j++) {
					if (j <= max)
						lengArr[j] = 0; // 테이프 길이만큼의 지역 모두 보수로 인한 => 0 처리
				}
			}

		}
		System.out.println(count);
	}
}
