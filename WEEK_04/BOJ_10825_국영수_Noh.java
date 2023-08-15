package Silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_S4_10825_국영수 {
	static class Student {
		String name;
		int kor;
		int eng;
		int math;

		public Student(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 학생 수
		int N = sc.nextInt();

		Student[] students = new Student[N];
		for (int i = 0; i < N; i++) {
			String[] score = new String[4];
			for (int j = 0; j < 4; j++) {
				score[j] = sc.next();
			}
			students[i] = new Student(score[0], Integer.parseInt(score[1]), Integer.parseInt(score[2]),
					Integer.parseInt(score[3]));
		}

		// 정렬 조건 재정의
		Comparator<Student> cp = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				// 국어 점수 감소하는 순서대로
				if (s1.kor < s2.kor) {
					return 1;
				} // 국어 점수가 같다면
				else if (s1.kor == s2.kor) {
					// 영어 점수가 증가하는 순서대로
					if (s1.eng > s2.eng) {
						return 1;
					} // 국어 점수와 영어 점수가 같으면
					else if (s1.eng == s2.eng) {
						// 수학 점수가 감소하는 순서대로
						if (s1.math < s2.math) {
							return 1;
						} // 모든 점수가 같으면 
						else if (s1.math == s2.math) {
							// 이름이 사전 순으로 증가하는 순서대로
							return s1.name.compareTo(s2.name);
						}
					}
				}
				return -1;
			}
		};
		
		Arrays.sort(students, cp);
		for (int i = 0; i < N; i++) {
			System.out.println(students[i].name);
		}
	}
}
