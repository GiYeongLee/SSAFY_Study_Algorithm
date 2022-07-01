import java.util.*;

public class 카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
                { 0, 0, 0, 3 } };
        System.out.println(Arrays.toString(solution(m, n, picture)));
    }
    
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) {
                    continue;
                } else {
                    numberOfArea++;
                    int count = 1;
                    visited[i][j] = true;
                    queue.add(new int[] { i, j });

                    while (!queue.isEmpty()) {
                        int curX = queue.peek()[0];
                        int curY = queue.poll()[1];

                        for (int dir = 0; dir < 4; dir++) {
                            int nextX = curX + dx[dir];
                            int nextY = curY + dy[dir];

                            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) {
                                continue;
                            }
                            if (visited[nextX][nextY] || picture[nextX][nextY] != picture[curX][curY]) {
                                continue;
                            }

                            count++;
                            visited[nextX][nextY] = true;
                            queue.add(new int[] { nextX, nextY });
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}