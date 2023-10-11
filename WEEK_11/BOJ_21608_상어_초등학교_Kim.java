import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_21608_상어_초등학교_Kim {
	static int answer;
    static int seatNum;
    static ArrayList<Student> students; // 각 학생 당 좋아하는 학생 수를 저장하기 위한 리스트
    static int[][] resultSeat;
    static int[] dr = {0, 0, -1, 1}; // 하 상 좌 우
    static int[] dc = {1, -1, 0, 0};
    
    // 학생 클래스
    static class Student implements Comparable<Student> {
        int num; // 학생 번호
        List<Integer> favoriteStudent; // 좋아하는 학생 수

        Student(int num, List<Integer> favoriteStudent) {
            this.num = num;
            this.favoriteStudent = favoriteStudent;
        }

        @Override
        public int compareTo(Student o) {
            return num - o.num;
        }
    }

    // 좌석 클래스
    static class Seat implements Comparable<Seat> {
        int x, y, favoriteStudent, emptySpace;

        Seat(int x, int y, int favoriteStudent, int emptySpace) {
            this.x = x;
            this.y = y;
            this.favoriteStudent = favoriteStudent;
            this.emptySpace = emptySpace;
        }

        // 정렬 기준
        @Override
        public int compareTo(Seat other) {
        	// 인접한 칸에 많은 칸으로
            if (favoriteStudent != other.favoriteStudent) {
                return other.favoriteStudent - favoriteStudent;
            }

            // 비어있는 칸이 많은 칸으로
            if (emptySpace != other.emptySpace) {
                return other.emptySpace - emptySpace;
            }

            // 행번호가 작은 곳으로
            if (x != other.x) {
                return x - other.x;
            }

            // 열 번호가 가장 작은 칸으로
            return y - other.y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        seatNum = Integer.parseInt(br.readLine()); // 좌석 수
        students = new ArrayList<>();
        resultSeat = new int[seatNum][seatNum]; // 배치 좌석
        answer = 0;

        for (int i = 0; i < seatNum * seatNum; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> favorite = new ArrayList<>();

            // 좋아하는 학생 연결
            for (int j = 0; j < 4; j++) {
                favorite.add(Integer.parseInt(st.nextToken()));
            }
            students.add(i, new Student(num, favorite));
        }
        	
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            Seat seat = getSeat(student);
            // 결과 배열에 저장
            resultSeat[seat.x][seat.y] = student.num;
        }
        
        // 학생 num기준 정렬, getScore할 때 쓰려고
        Collections.sort(students);

        for (int i = 0; i < seatNum; i++) {
            for (int j = 0; j < seatNum; j++) {
                answer += getScore(i, j);
            }
        }

        System.out.println(answer);
    }

    // 좌석 배치
    public static Seat getSeat(Student student) {
        Seat curSeat = null;
        for (int i = 0; i < seatNum; i++) {
            for (int j = 0; j < seatNum; j++) {
                // 이미 앉아있으면 skip
                if (resultSeat[i][j] != 0) continue;
                // seat(x, y, 인접한 좋아하는 사람, 비어있는 자리)
                int adjustFav = calculateAdjacentFavorites(i, j, student);
                int emptySeats = calculateEmptySeats(i, j);

                Seat nxtSeat = new Seat(i, j, adjustFav, emptySeats);

                // 현재 좌석과 다음 좌석 비교
                // compareTo 사용하면 seat클래스의 비교 기준에 따라서 비교
                // 다음에 앉을 좌석이 내 자리가 되는거
                if (curSeat == null || curSeat.compareTo(nxtSeat) > 0) {
                    curSeat = nxtSeat;
                }
            }
        }
        return curSeat;
    }

    // 인접에 좋아하는 학생 수 계산
    public static int calculateAdjacentFavorites(int row, int col, Student student) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr >= 0 && nr < seatNum && nc >= 0 && nc < seatNum) {
            	// 해당 학생의 주변에 좋아하는 학생을 포함하고 있는지
                if (resultSeat[nr][nc] != 0 && student.favoriteStudent.contains(resultSeat[nr][nc])) {
                    count++;
                }
            }
        }

        return count;
    }
    
    // 비어있는 학생 수 계산
    public static int calculateEmptySeats(int row, int col) {
        int possibleCount = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            
            if (nr >= 0 && nr < seatNum && nc >= 0 && nc < seatNum) {
            	if (resultSeat[nr][nc] == 0) {
                    possibleCount++;
                }
            }
        }
        return possibleCount;
    }

    // 마지막으로 점수 계산할 때
    public static int getScore(int row, int col) {
        int currentStudent = resultSeat[row][col];
        
        // 위에서 정렬한 이유, num 순서를 계산하기 위해서
        Student student = students.get(currentStudent - 1);

        int score = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr >= 0 && nr < seatNum && nc >= 0 && nc < seatNum) {
                int neighborStudent = resultSeat[nr][nc];
                if(neighborStudent != 0 && student.favoriteStudent.contains(neighborStudent)) {
                    score++;
                }
            }
        }
        
        // 0이면 0, 1이면 1, 2부터는 10의 제곱이길래,,,!
        if (score == 0) return 0;
        if (score == 1) return 1;

        return (int)Math.pow(10, score - 1);
    }
}
