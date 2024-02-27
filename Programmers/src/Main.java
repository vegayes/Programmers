
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] result = sol.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println(result);
    }

}

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        Map<String,String > userNick = new HashMap<>();

        //레코드 돌리기
        for(int i = 0; i < record.length; i++){
            String[] oneRecord = record[i].split(" ");

            if()

        }




        return answer;
    }
}





