package BOJ_7795_먹을것인가;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int[] Asize = new int[A];
			int[] Bsize = new int[B];
			
			st = new StringTokenizer(br.readLine());
			
			// A 사이즈 입력
			for (int j = 0; j < A; j++) 
				Asize[j] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			// B 사이즈 입력
			for (int k = 0; k < B; k++) 
				Bsize[k] = Integer.parseInt(st.nextToken());

			// 배열 정렬 
			Arrays.sort(Asize); 
			Arrays.sort(Bsize);
			
			//비교 
			int count = 0;
			for (int i = 0; i < Asize.length; i++) {
				for (int j = 0; j < Bsize.length;j++) {
					if (Asize[i] <= Bsize[j]) {
						break;
					} else
						count++;
				}
			}
			System.out.println(count);
		}
	}
}
