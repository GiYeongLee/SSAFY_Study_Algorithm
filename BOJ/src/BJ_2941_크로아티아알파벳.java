import java.io.*;

public class BJ_2941_크로아티아알파벳 {

    public static void main(String[] args) throws Exception {

        // 크로아티아 알파벳 배열
        String[] arr = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int count = 0; // 알파벳 개수(영어 알파벳 + 크로아티아 알파벳)
        int move = 0; // 입력 문자열 인덱스를 추후 초기화하기 위한 변수

        char[] input = in.readLine().toCharArray(); // 입력

        for (int i = 0; i < input.length; i++) { // 입력 문자열 반복
            for (int j = 0; j < arr.length; j++) { // 크로아티아 알파벳 배열 반복
                for (int z = 0; z < arr[j].length(); z++) { // 크로아티아 알파벳 반복
                    if (input[i] != arr[j].charAt(z)) {
                        // 입력 문자열의 i번째 char과 크로아티아 알파벳의 i번째 char 비교
                        i = i - move; // 입력 문자열 인덱스를 초기화
                        move = 0;
                        break; // 다음 크로아티아 알파벳으로 이동
                    }

                    if (z == arr[j].length() - 1) {
                        // 크로아티아 알파벳과 끝까지 일치할 경우
                        for (int k = i - move; k <= i; k++) {
                            // 입력 문자열에서 크로아티아 알파벳에 해당되는 부분들을 0으로 초기화
                            input[k] = 0;
                        }
                        move = 0;
                        count++;
                    }

                    i++; // 입력 문자열 인덱스 이동
                    move++;

                    if (i >= input.length) {
                        // 입력 문자열이 끝났는데 마지막 문자가 크로아티아 알파벳에 포함되어 배열 범위를 넘어가는 경우를 방지
                        i = i - move;
                        move = 0;
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            // 입력 문자열에서 크로아티아 알파벳을 제외한 일반 알파벳 개수를 count 변수에 더해주기
            if (input[i] != 0) {
                count++;
            }
        }
        System.out.println(count);
    }

}