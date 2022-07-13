public class 가장큰정사각형찾기 {
    public static void main(String[] args) {
        int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = board[0][0];
        int n = board.length;
        int m = board[0].length;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j - 1], board[i - 1][j]), board[i][j - 1]) + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        return answer * answer;
    }
}
