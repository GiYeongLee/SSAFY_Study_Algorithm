import java.io.*;
import java.util.*;

public class BJ_17413_단어뒤집기2 {
    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        String input = in.readLine();

        char[] output = new char[input.length()];

        Stack<Character> stack = new Stack<Character>();
        int move = 0;

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '<') {

                for (int j = i - move; j < i; j++) {
                    output[j] = stack.pop();
                }
                move = 0;

                while (input.charAt(i) != '>') {
                    output[i] = input.charAt(i);
                    i++;
                }
                output[i] = input.charAt(i);
                continue;
            }

            if (input.charAt(i) == ' ') {
                for (int j = i - move; j < i; j++) {
                    output[j] = stack.pop();
                }
                move = 0;
                output[i] = input.charAt(i);
                continue;
            }

            stack.push(input.charAt(i));
            move++;

        }

        for (int j = input.length() - move; j < input.length(); j++) {
            output[j] = stack.pop();
        }

        for (int i = 0; i < output.length; i++) {
            builder.append(output[i]);
        }

        System.out.println(builder);
    }
}
