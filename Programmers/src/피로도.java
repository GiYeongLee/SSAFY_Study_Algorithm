public class 피로도 {

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
		System.out.println(solution(k, dungeons));
	}
	
	static int[] arr;
	static boolean[] isSelected;
	static int max = -1;
	
	public static int solution(int k, int[][] dungeons) {
        arr = new int[dungeons.length];
        isSelected = new boolean[dungeons.length];      
        permutation(0, dungeons, k);
        return max;
    }
	
	public static void permutation(int cnt, int[][] dungeons, int k) {
		if(cnt == dungeons.length) {
			check(dungeons, k);
			return;
		}
		for(int i = 0; i < dungeons.length; i++) {
			if(isSelected[i]) continue;
			arr[cnt] = i;
			isSelected[i] = true;
			permutation(cnt + 1, dungeons, k);
			isSelected[i] = false;
		}
	}

	public static void check(int[][] dungeons, int k) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(k >= dungeons[arr[i]][0]) {
				k -= dungeons[arr[i]][1];
				count++;
			}
			else break;
		}
		max = Math.max(max, count);
	}
}
