import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어_Kim {
	static int placeSize; // 공간의 크기
    static int[][] place; // 공간
    static boolean[][] visited; // 방문여부 확인
    static int sharkX, sharkY, time = 0, sharkSize = 2; // // 상어의 위치, 시간, 현재 크기
    static int[] dr = {1, -1, 0, 0}; // 좌 우 상 하
    static int[] dc = {0, 0, 1, -1};
    
    static class Fish implements Comparable<Fish> {
        int x, y, distance;
        Fish(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Fish o) {
            // 1. 가장 가까운 순서, 2. 가장 위(x), 3. 가장 왼쪽(y)
            if (distance == o.distance) {
                // 2. 가장 위
                if (x == o.x) {
                    // 3. 가장 왼쪽
                    if (y == o.y) {
                        return 0;
                    }
                    return y - o.y;
                } else {
                    return x - o.x;
                }
            } else {
                // 가장 가까운 곳
                return distance - o.distance;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        placeSize = Integer.parseInt(br.readLine());
        place = new int[placeSize][placeSize];
        visited = new boolean[placeSize][placeSize];

        // 입력
        for (int i = 0; i < placeSize; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < placeSize; j++) {
                place[i][j] = Integer.parseInt(st.nextToken());
                // 제일 처음 아기 상어의 위치 저장
                if (place[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }
        }

        bfs(sharkX, sharkY);
        System.out.println(time);
    }

    public static void bfs(int x, int y) {
    	// 아기상어가 먹은 먹이 개수 저장
    	int eaten = 0;

        while (true) {
        	// LinkedList보다 그냥 성능이 좋다고 해서 써보았습니다..
            Queue<Fish> queue = new ArrayDeque<>();
            // 잡아먹은 먹이 리스트
            List<Fish> preyList = new ArrayList<>();
            visited = new boolean[placeSize][placeSize];

            queue.add(new Fish(x, y, 0));
            visited[x][y] = true;

            while(!queue.isEmpty()) {

                Fish target = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = target.x + dr[i];
                    int nc = target.y + dc[i];

                    if (nr >= 0 && nr < placeSize && nc >= 0 && nc < placeSize) {
                    	// 현재 아기 상어의 크기보다 먹이의 크기가 작거나 같아야 지나갈 수 있음
                        if (!visited[nr][nc] && place[nr][nc] <= sharkSize) {
                            visited[nr][nc] = true;
                            queue.offer(new Fish(nr, nc, target.distance + 1));
                            // 0이 아니고 아기 상어의 크기보다 작아야 먹을 수 있음
                            if (place[nr][nc] != 0 && place[nr][nc] < sharkSize) {
                                // 먹이리스트에 저장
                            	preyList.add(new Fish(nr, nc, target.distance + 1));
                            }
                        }
                    }
                }
            }

            // 먹을 수 있는 먹이 없으면 out
            if (preyList.isEmpty()) {
                break;

            } else {
            	// preyList에 fish 들어가있으므로 sort 했을 경우, 정렬 기준에 따라 sort
                Collections.sort(preyList);
                Fish eatenFish = preyList.get(0);

                // 거리만큼 시간에 더해주기
                time += eatenFish.distance; 
                // 먹은 개수 증가
                eaten++;

                // 기존은 0으로 변경하고
                place[x][y] = 0;
                
                // 먹이 먹은 지점을 아기상어의 위치로 다시 변경
                x = eatenFish.x;
                y = eatenFish.y;
                place[x][y] = 9;

                // 먹은 크기와 상어의 크기가 같아야만 크기가 증가할 수 있음
                // 이때 먹었으니까 먹이는 리셋
                if (sharkSize == eaten) {
                    sharkSize++;
                    eaten = 0;
                }
            }

        }
    }
}
