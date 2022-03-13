import java.io.*;

public class BJ_2567_색종이2 {

    public static void main(String[] args) throws Exception {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int[][] grid = new int[102][102];

        int N = Integer.parseInt(in.readLine());

        for (int t = 0; t < N; t++) {
            String[] splited = in.readLine().split(" ");
            int a = Integer.parseInt(splited[0]);
            int b = Integer.parseInt(splited[1]);

            for (int i = a; i < a + 10; i++) {
                for (int j = b; j < b + 10; j++) {
                    grid[i][j] = 1;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        int x = i + dx[dir];
                        int y = j + dy[dir];
                        if (grid[x][y] == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

}
