import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_미세먼지_안녕_Kim {
    static int row, column;
    static int[][]room; // 방크기
    static int second; // 시간
    static int upper, under; // 공청기 지점
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = 0;
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());
        room = new int[row][column];

        // 일단 공청기 지점 -1로 초기화
        upper = -1; under = -1;
        // 공청기 배열, 사실 배열 안쓰고 해도 될듯
        // 어차피 1열에 행 번호만 다른거라 행 번호 처음꺼 찾으면 거기다가 1 더한 지점 해주면 될 것 같은데
        // 일단 이렇게 풀었으니까,,
        int[] machinePoint = new int[2];
        int index = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < column; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    machinePoint[index] = i;
                    index++;
                }

            }
        }
        
        // 공청기 윗 부분 행 번호
        upper = machinePoint[0];
        // 공청기 아래부분 행 번호
        under = machinePoint[1];
        
        for (int i = 0; i < second; i++) {
        	// 미세먼지 확산 함수
        	makeDust();
        	// 위 방향
            upperWind(upper);
            // 아래 방향
            underWind(under);
        }

        // 공청기 지점 제외 더하기
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (room[i][j] != -1) {
                    answer += room[i][j];
                }
            }
        }

        System.out.println(answer);
    }
    // 반시계 방향
    public static void upperWind(int start) {
        int top = start;
        
        // 위 -> 아래
        for (int x = top - 1; x > 0; x--) {
            room[x][0] = room[x - 1][0];
        }
        
        // 우 -> 좌
        for (int y = 0; y < column - 1; y++) {
            room[0][y] = room[0][y + 1];
        }

        // 아래 -> 위
        for (int x = 0; x < top; x++) {
            room[x][column - 1] = room[x + 1][column - 1];
        }

        // 좌 -> 우
        for (int y = column - 1; y > 1; y--) {
            room[top][y] = room[top][y - 1];
        }
        
        // 시작 지점은 0
        room[top][1] = 0;
    }

    // 시계방향
    public static void underWind(int start){
        int bottom = start;

        // 아래 -> 위
        for (int x = bottom + 1; x < row - 1; x++) {
            room[x][0] = room[x + 1][0];
        }

        // 우 -> 좌
        for (int y = 0; y < column - 1; y++) {
            room[row - 1][y] = room[row - 1][y + 1];
        }
        
        // 위 -> 아래
        for (int x = row - 1; x > bottom; x--) {
            room[x][column - 1] = room[x - 1][column - 1];
        }

        // 좌 -> 우
        for (int y = column - 1; y > 1; y--) {
            room[bottom][y] = room[bottom][y - 1];
        }

        // 시작지점은 0
        room[bottom][1] = 0;
    }

    // 미세먼지 만들기
    public static void makeDust() {
        int[][] dustRoom = new int[row][column];
        
        // 4방향으로 뻗어갈 수 있기 때문에 설정
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
            	// 0보다 클 경우 
                if (room[i][j] > 0) {
                	
                	// 미세먼지 확산의 양
                    int amount = room[i][j] / 5;
                    // 몇 방향으로 뻗어갈 수 있는지를 확인하기 위한 count
                    int count = 0;

                    for (int k = 0; k < 4; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < row && nc >= 0 && nc < column && room[nr][nc] != -1) {
                            // 미세먼지 방에 확산의 양 추가, count 증가
                        	dustRoom[nr][nc] += amount;
                            count++;
                        }
                    }

                    // 기존 방에 공식으로 계산한 값 빼주기
                    room[i][j] -= amount * count;
                }
                
                // 해당 값도 미세먼지에 더해줘야하니까 전부 더해주기
                dustRoom[i][j] += room[i][j];
            }
        }
        
        // 배열 복사
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                room[i][j] = dustRoom[i][j];
            }
        }
    }
}
