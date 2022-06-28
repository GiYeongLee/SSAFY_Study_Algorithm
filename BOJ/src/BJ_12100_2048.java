import java.io.*;

public class BJ_12100_2048 {

    static int[] dir = new int[5];
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] grid_ori;
    static int N;
    static int max;

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(in.readLine());
        grid_ori = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] splited = in.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid_ori[i][j] = Integer.parseInt(splited[j]);
            }
        }

        permutation(0);
        System.out.println(max);
    }

    public static void permutation(int cnt) {
        if (cnt == 5) {
            func(dir);
            return;
        }

        for (int i = 0; i < 4; i++) {
            dir[cnt] = i;
            permutation(cnt + 1);
        }
    }

    public static void func(int[] dir) {
        int[][] grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = grid_ori[i][j];
                max = Math.max(max, grid[i][j]);
            }
        }

        for (int i = 0; i < 5; i++) {

            boolean[][] fixed = new boolean[N][N];

            switch (dir[i]) {

                case 0:
                    for (int m = 0; m < N; m++) {
                        for (int n = 0; n < N; n++) {
                            if (grid[m][n] == 0) {
                                continue;
                            }
                            int curX = m;
                            int curY = n;

                            while (true) {
                                int nextX = curX + dx[dir[i]];
                                int nextY = curY + dy[dir[i]];

                                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                                    break;
                                }
                                if (grid[nextX][nextY] == 0) {
                                    grid[nextX][nextY] = grid[curX][curY];
                                    grid[curX][curY] = 0;
                                    curX = nextX;
                                    curY = nextY;
                                    fixed[nextX][nextY] = fixed[curX][curY];
                                    fixed[curX][curY] = false;
                                    continue;
                                }
                                if (grid[nextX][nextY] != grid[curX][curY]) {
                                    break;
                                }
                                if (grid[nextX][nextY] == grid[curX][curY] && fixed[nextX][nextY] == false) {
                                    grid[nextX][nextY] *= 2;
                                    grid[curX][curY] = 0;
                                    fixed[nextX][nextY] = true;
                                    max = Math.max(grid[nextX][nextY], max);
                                    continue;
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    for (int m = N - 1; m >= 0; m--) {
                        for (int n = 0; n < N; n++) {
                            if (grid[m][n] == 0) {
                                continue;
                            }
                            int curX = m;
                            int curY = n;

                            while (true) {
                                int nextX = curX + dx[dir[i]];
                                int nextY = curY + dy[dir[i]];

                                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                                    break;
                                }
                                if (grid[nextX][nextY] == 0) {
                                    grid[nextX][nextY] = grid[curX][curY];
                                    grid[curX][curY] = 0;
                                    curX = nextX;
                                    curY = nextY;
                                    fixed[nextX][nextY] = fixed[curX][curY];
                                    fixed[curX][curY] = false;
                                    continue;
                                }
                                if (grid[nextX][nextY] != grid[curX][curY]) {
                                    break;
                                }
                                if (grid[nextX][nextY] == grid[curX][curY] && fixed[nextX][nextY] == false) {
                                    grid[nextX][nextY] *= 2;
                                    grid[curX][curY] = 0;
                                    fixed[nextX][nextY] = true;
                                    max = Math.max(grid[nextX][nextY], max);
                                    continue;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for (int n = 0; n < N; n++) {
                        for (int m = 0; m < N; m++) {
                            if (grid[m][n] == 0) {
                                continue;
                            }
                            int curX = m;
                            int curY = n;

                            while (true) {
                                int nextX = curX + dx[dir[i]];
                                int nextY = curY + dy[dir[i]];

                                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                                    break;
                                }
                                if (grid[nextX][nextY] == 0) {
                                    grid[nextX][nextY] = grid[curX][curY];
                                    grid[curX][curY] = 0;
                                    curX = nextX;
                                    curY = nextY;
                                    fixed[nextX][nextY] = fixed[curX][curY];
                                    fixed[curX][curY] = false;
                                    continue;
                                }
                                if (grid[nextX][nextY] != grid[curX][curY]) {
                                    break;
                                }
                                if (grid[nextX][nextY] == grid[curX][curY] && fixed[nextX][nextY] == false) {
                                    grid[nextX][nextY] *= 2;
                                    grid[curX][curY] = 0;
                                    fixed[nextX][nextY] = true;
                                    max = Math.max(grid[nextX][nextY], max);
                                    continue;
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (int n = N - 1; n >= 0; n--) {
                        for (int m = 0; m < N; m++) {
                            if (grid[m][n] == 0) {
                                continue;
                            }
                            int curX = m;
                            int curY = n;

                            while (true) {
                                int nextX = curX + dx[dir[i]];
                                int nextY = curY + dy[dir[i]];

                                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                                    break;
                                }
                                if (grid[nextX][nextY] == 0) {
                                    grid[nextX][nextY] = grid[curX][curY];
                                    grid[curX][curY] = 0;
                                    curX = nextX;
                                    curY = nextY;
                                    fixed[nextX][nextY] = fixed[curX][curY];
                                    fixed[curX][curY] = false;
                                    continue;
                                }
                                if (grid[nextX][nextY] != grid[curX][curY]) {
                                    break;
                                }
                                if (grid[nextX][nextY] == grid[curX][curY] && fixed[nextX][nextY] == false) {
                                    grid[nextX][nextY] *= 2;
                                    grid[curX][curY] = 0;
                                    fixed[nextX][nextY] = true;
                                    max = Math.max(grid[nextX][nextY], max);
                                    continue;
                                }
                            }
                        }
                    }
                    break;
            }
        }
    }
}
