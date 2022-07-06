import java.util.*;

public class 위장 {
    public static void main(String[] args) {
        String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
                { "green_turban", "headgear" } };
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (String[] temp : clothes) {
            if (map.containsKey(temp[1])) {
                map.put(temp[1], map.get(temp[1]) + 1);
            } else {
                map.put(temp[1], 1);
            }
        }
        
        int answer = 1;

        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }

        return answer - 1;
    }
}
