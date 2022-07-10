import java.io.*;
import java.util.*;

public class BJ_1655_가운데를말해요 {
    public static void main(String[] args) throws Exception {
        func();
    }

    public static void func() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        int N = Integer.parseInt(in.readLine());

        for (int i = 1; i <= N; i++) {
            list.add(Integer.parseInt(in.readLine()));
            Collections.sort(list);
            if (i % 2 == 0) {
                System.out.println(Math.min(list.get(i / 2), list.get(i / 2 - 1)));
            } else {
                System.out.println(list.get(i / 2));
            }
        }
    }
}
