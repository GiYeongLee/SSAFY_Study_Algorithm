public class 스킬트리 {

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	
	public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        int[] check = new int[26];
        for(int i = 0; i < skill.length(); i++) {
        	check[skill.charAt(i) - 'A'] = i + 1;
        }
        
        for(int i = 0; i < skill_trees.length; i++) {
        	int level = 1;
            for(int j = 0; j < skill_trees[i].length(); j++) {
            	if(check[skill_trees[i].charAt(j) - 'A'] == 0) continue;
            	else if (check[skill_trees[i].charAt(j) - 'A'] == level) {
            		level++;
            		continue;
            	}
            	else {
            		answer--;
            		break;
            	}
            }
            answer++;
        }
        
        return answer;
    }

}
