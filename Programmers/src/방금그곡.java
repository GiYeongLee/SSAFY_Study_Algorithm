public class 방금그곡 {
    public static void main(String[] args) {
        String m = "CC#BCC#BCC#BCC#B";
        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m, musicinfos));
    }
    
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String find = m.replaceAll("C#", "1").replaceAll("D#", "2").replaceAll("F#", "3").replaceAll("G#", "4")
                .replaceAll("A#", "5");
        int max = -1;
        for (String musicinfo : musicinfos) {
            StringBuilder builder = new StringBuilder();
            String[] splited = musicinfo.split(",");
            String orig = splited[3].replaceAll("C#", "1").replaceAll("D#", "2").replaceAll("F#", "3")
                    .replaceAll("G#", "4").replaceAll("A#", "5");

            String[] timeSplited = splited[0].split(":");
            int startTime = Integer.parseInt(timeSplited[0]) * 60 + Integer.parseInt(timeSplited[1]);
            timeSplited = splited[1].split(":");
            int endTime = Integer.parseInt(timeSplited[0]) * 60 + Integer.parseInt(timeSplited[1]);
            int playTime = endTime - startTime;

            if (playTime > orig.length()) {
                for (int i = 0; i < playTime / orig.length(); i++) {
                    builder.append(orig);
                }
                builder.append(orig.substring(0, playTime % orig.length()));
            } else {
                builder.append(orig.substring(0, playTime));
            }

            if (builder.toString().contains(find)) {
                if (max >= playTime) {
                    continue;
                }
                max = playTime;
                answer = splited[2];
            }
        }
        
        if (max == -1) {
            return "(None)";
        }

        return answer;
    }
}
