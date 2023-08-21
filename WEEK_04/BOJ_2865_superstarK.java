import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		double[] people = new double[N+1]; // 1번이 idx 1에 들어가기 위해 n+1 크기 배열로 선언
		people[0] = Double.MIN_VALUE;
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				int idx = sc.nextInt();
				double score = sc.nextDouble();
				people[idx] = Math.max(people[idx], score);
			} 
		} // 받아온 전체 data 순회하면서 가장 큰 값만 남김, 모든 장르에서 최고점만 각각의 사람에게 남아있음
		Arrays.sort(people); // 받아온 최고점수에 대해서 sort
		double sumScore = 0;
		for (int i = N ; i > N-K ; i--) {
			sumScore += people[i];
		} // 본선 진출 가능한 멤버까지 최고점들의 합을 구함
		System.out.printf("%.1f", sumScore); // 소수점 1자리까지 출력
	}
}
