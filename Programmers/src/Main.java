
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

        Map<String,String > userNick = new HashMap<>();
        int count = 0;
        int index = 0;


        //레코드 돌리기
        for(int i = 0; i < record.length; i++){
            String[] oneRecord = record[i].split(" ");

            // 유저 아이디 마다 닉네임 저장
            if(oneRecord[0].equals("Enter") && !userNick.containsKey(oneRecord[1])){
                userNick.put(oneRecord[1], oneRecord[2]);
            }else if (oneRecord[0].equals("Change")||oneRecord[0].equals("Enter")){ // 변경 시, nickName 변경
                userNick.put(oneRecord[1], oneRecord[2]);
            }

            // 배열 값 확인
            if(oneRecord[0].equals("Enter")||oneRecord[0].equals("Leave")){
                count++;
            }
        }

        String[] answer = new String[count];

        // 출력하기
        for(int a = 0; a < record.length; a++){
            String[] option = record[a].split(" ");

            if(option[0].equals("Enter")){
                answer[index] = userNick.get(option[1])+"님이 들어왔습니다.";
                index++;
            }else if(option[0].equals("Leave")){
                answer[index] = userNick.get(option[1])+"님이 나갔습니다.";
                index++;
            }

        }

        return answer;
    }
}





