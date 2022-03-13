import java.io.*;
import java.util.Arrays;

public class BJ_2804_크로스워드만들기 {

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String[] input = in.readLine().split(" ");

        int a = 0;
        int b = 0;
        int flag = 0;

        for (int i = 0; i < input[0].length(); i++) {
            for (int j = 0; j < input[1].length(); j++) {
                if (input[0].charAt(i) == input[1].charAt(j)) {
                    a = i;
                    b = j;
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }

        char[][] grid = new char[input[1].length()][input[0].length()];
        for (int i = 0; i < input[1].length(); i++) {
            Arrays.fill(grid[i], '.');
        }

        for (int i = 0; i < input[0].length(); i++) {
            grid[b][i] = input[0].charAt(i);
        }

        for (int i = 0; i < input[1].length(); i++) {
            grid[i][a] = input[1].charAt(i);
        }

        for (int i = 0; i < input[1].length(); i++) {
            for (int j = 0; j < input[0].length(); j++) {
                builder.append(grid[i][j]);
            }
            builder.append("\n");
        }

        builder.setLength(builder.length() - 1);
        System.out.println(builder.toString());
    }

}
