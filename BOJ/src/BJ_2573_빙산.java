import java.io.*;
import java.util.*;

public class BJ_2573_빙산 {
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int num = 0;

    static int grid[][];
    static int M;
    static int N;

    static int a;
    static int b;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] splited = in.readLine().split(" ");

        M = Integer.parseInt(splited[0]);
        N = Integer.parseInt(splited[1]);
        grid = new int[M][N];

        for (int i = 0; i < M; i++) {
            splited = in.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(splited[j]);
                if (grid[i][j] != 0) {
                    num++;
                    a = i;
                    b = j;
                }
            }
        }

        int ans = 0;

        while (check()) {
            melt();
            ans++;
        }

        if (num == 0) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);
    }

    public static void melt() {
        int[][] temp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int x = i + dx[dir];
                        int y = j + dy[dir];

                        if (x < 0 || y < 0 || x >= M || y >= N) {
                            temp[i][j]--;
                            continue;
                        }

                        if (grid[x][y] == 0) {
                            temp[i][j]--;
                            continue;
                        }
                    }
                    if (temp[i][j] <= 0) {
                        temp[i][j] = 0;
                        num--;
                        continue;
                    }

                    a = i;
                    b = j;
                }
            }
        }
        grid = temp;
    }

    public static boolean check() {
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<int[]>();

        queue.offer(new int[] { a, b });

        count = 0;

        while (!queue.isEmpty()) {
            int curX = queue.peek()[0];
            int curY = queue.poll()[1];

            count++;
            visited[curX][curY] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nextX = curX + dx[dir];
                int nextY = curY + dy[dir];

                if (nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY] == true || grid[nextX][nextY] == 0) {
                    continue;
                }

                visited[nextX][nextY] = true;
                queue.offer(new int[] { nextX, nextY });
            }
        }

        if (count == num) {
            return true;
        } else {
            return false;
        }
    }
}
