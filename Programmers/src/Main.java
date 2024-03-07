
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] result = sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
       String result = sol.solution("aukks", "wbqd", 5);
        System.out.println(result);
    }

}

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            for(int j = 0; j < index; j++){
                ch += 1;

                if(ch > 'z') {
                    ch -= (char)('z'-'a'+1);
                }

                if(skip.contains(String.valueOf(ch))){
                        j--;
                }
            }
            answer += ch;
        }

        return answer;
    }
}
