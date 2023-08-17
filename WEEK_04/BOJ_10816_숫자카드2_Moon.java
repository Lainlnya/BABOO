package BOJ_10816_숫자카드2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 상근이
		int N = Integer.parseInt(bf.readLine());
		int[] cardN = new int[N];
		String[] str = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			cardN[i] = Integer.parseInt(str[i]);
		}
		
		// 카드
		int M = Integer.parseInt(bf.readLine());
		int[] cardM = new int[M];
		str = bf.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			cardM[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(cardN);
		
		for (int i = 0; i < M; i++) {
			int u = upper(cardN, cardM[i]);
			int l = lower(cardN, cardM[i]);
			bw.write(String.valueOf(u-l));
			
			if (i < M-1) {
				bw.write(" ");
			}
			
		}
		
		bw.flush();
	}
	
	// 같은 수가 나오는 부분 중 가장 오른쪽의 index를 반환 (binary search)
	public static int upper(int[] arr, int target) {
		int p = 0;
		int r = arr.length;
		int q = (p+r)/2;
		
		while (p < r) {
			if (arr[q] > target) {
				r = q;
				q = (p+r)/2;
			} else {
				p = q+1;
				q = (p+r)/2;
			}
		}
		
		return p;
	}
	
	// 같은 수가 나오는 부분 중 가장 왼쪽의 index를 반환 (binary search)
	public static int lower(int[] arr, int target) {
		int p = 0;
		int r = arr.length;
		int q = (p+r)/2;
		
		while (p < r) {
			if (arr[q] >= target) {
				r = q;
				q = (p+r)/2;
			} else {
				p = q+1;
				q = (p+r)/2;
			}
		}
		
		return p;
	}
	
}