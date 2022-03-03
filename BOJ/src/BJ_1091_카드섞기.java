import java.io.*;

public class BJ_1091_카드섞기 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] P = new int[N]; // 초기 카드 순서
        int[] S = new int[N]; // 카드 섞는 규칙

        String[] splited = in.readLine().split(" "); // P 배열 입력
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(splited[i]);
        }
        splited = in.readLine().split(" "); // S 배열 입력
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(splited[i]);
        }

        int[] checkArr = P.clone(); // 초기 카드 순서를 따로 저장하여 카드를 섞는 도중 다시 초기 상태로 돌아온다면 Cycle이 존재
        int count = 0; // 카드 섞는 횟수

        while (check(P, N)) {
            int[] temp = new int[N];
            for (int i = 0; i < N; i++) { // 규칙에 맞게 배열 바꾸기
                temp[S[i]] = P[i];
            }
            if (checkCycle(temp, checkArr, N)) { // Cycle이 존재하는지 검사
                System.out.println(-1);
                return;
            }
            P = temp.clone();
            count++; // 섞은 횟수 증가
        }
        System.out.println(count);
    }

    public static boolean check(int[] P, int N) { // 카드가 목적에 맞게 섞였는지 검사하는 메서드
        for (int i = 0; i < N; i++) {
            if (P[i] != (i % 3))
                return true; // 아직 목적 달성이 안됬다면 false return
        }
        return false; // 목적에 달성했다면 true return
    }

    public static boolean checkCycle(int[] P, int[] checkArr, int N) { // Cycle이 있는지 검사하는 메서드
        for (int i = 0; i < N; i++) { // 초기 상태의 카드 순서와 동일하면 Cycle이 존재
            if (P[i] != checkArr[i])
                return false; // Cycle이 판정되지 않았다면 false return
        }
        return true; // Cycle이 존재한다면 true return
    }
}
