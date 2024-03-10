
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] result = sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
       String result = sol.solution(new String[]{"Jane", "Kim"});
        System.out.println(result);
    }

}

class Solution {
    public String solution(String[] seoul) {
        String answer = "";

        for(int i = 0; i < seoul.length; i++){

            if(seoul[i].equals("Kim")){
                return "김서방은 "+i+"에 있다";
            }

        }

        return answer;
    }
}