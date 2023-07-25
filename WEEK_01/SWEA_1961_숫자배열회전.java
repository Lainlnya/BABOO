import java.util.Scanner;

public class NumberSpin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i=0; i<T; i++) {
			// 내용
			int N = sc.nextInt(); // N by N 행렬
			
			int[][] arr = new int[N][N]; // 초기에 입력받을 행렬
			int[][] arr90 = new int[N][N]; // 90도 회전
			int[][] arr180 = new int[N][N];
			int[][] arr270 = new int[N][N];
			
			for (int p=0; p<N; p++) {
				for (int q=0; q<N; q++) {
					arr[p][q] = sc.nextInt();
				}
			} // 행렬 입력받기
			
			// 90도 회전
			for (int p=0; p<N; p++) {
				for (int q=0; q<N; q++) {
					arr90[q][N-p-1] = arr[p][q];
				}
			}
			
			
			// 180도 회전
			for (int p=0; p<N; p++) {
				for (int q=0; q<N; q++) {
					arr180[N-p-1][N-q-1] = arr[p][q];
				}
			}
			
			// 270도 회전
			for (int p=0; p<N; p++) {
				for (int q=0; q<N; q++) {
					arr270[N-q-1][p] = arr[p][q];
				}
			}
			
			// 출력
			System.out.println("#"+(i+1));
			for (int p=0; p<N; p++) {
				for (int q=0; q<N; q++) {
					System.out.print(arr90[p][q]);
				}
				System.out.print(" ");
				for (int q=0; q<N; q++) {
					System.out.print(arr180[p][q]);
				}
				System.out.print(" ");
				for (int q=0; q<N; q++) {
					System.out.print(arr270[p][q]);
				}
				System.out.println(" ");
			}
		}
		sc.close();
	}
} //18min