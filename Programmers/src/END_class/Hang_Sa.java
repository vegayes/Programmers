package END_class;

import java.util.HashMap;

public class Hang_Sa {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        // 1) discount의 시작 위치
        for(int i = 0; i < discount.length-9; i++){

            int count = 0;

            // 1-1) map 초기화
            for(int a = 0; a<want.length; a++){
                map.put(want[a], number[a]);
            }

            // 2) 시작의 값의 key를 가지고 있는게 있니?
            if(map.containsKey(discount[i])){
                // 2-1) 있으면 시작 값을 기준으로
                for(int b = i; b<discount.length; b++){
                    if(map.containsKey(discount[b])){

                        map.put(discount[b],map.get(discount[b])-1);

                        if(map.get(discount[b]) == 0){
                            map.remove(discount[b]);
                        }
                        count++;
                    }else{

                        break;
                    }

                }
            }

            if(count == 10){
                // 내용 다 없애기
                map.clear();
                answer++;
            }

        }

        return answer;
    }
}
