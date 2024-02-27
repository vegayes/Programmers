package Ing_code;

import java.util.HashMap;
import java.util.Map;

public class Class_Code {

    /*
// 할인행사
일정 금액 지불 --> 10일 회원

하루에 한 가지 제품 할인 (회원 대상) : 하루 1개 구매

원하는 상품을 10일동안 모두 구할 수 있는 경우의 날짜 구하기
 */
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String,Integer> wantStation = new HashMap<>(want.length);

        // 1) 원하는 값 map으로 저장하기

        System.out.println(wantStation);

        // 2) discount만큼 확인해봄.
        for(int a = 0; a< discount.length; a++){

            System.out.println(a+"번째 실행");

            // 3) a번째 부터 시작
            for(int b = a; b < discount.length; b++){

                // 현재의 값
                String currentCheck = discount[a];
                System.out.println("현재 값  :" + currentCheck);
                // want 값이 있는지 확인
                if(wantStation.containsKey(currentCheck)){
                    Boolean wantCheck = wantStation.get(currentCheck) > 0;

                    System.out.println("원하는 값 체크 :" + wantCheck);

                    // 4) for
                    if(wantCheck){
                        System.out.println("맞음");
                        wantStation.put(currentCheck, wantStation.get(currentCheck)-1);
                        System.out.println("값 변경 :" + wantStation);
                    }else{ // 값이 없음
                        // for문 통과
                        break;
                    }
                }

                break;
            }

            System.out.println("다 통과");

            answer++;
        }


        return answer;
    }

    // 값 새로 만들기
//    public static Map<String,Integer> makeMap(String[] want, int[] number){
//        for(int i = 0; i < want.length; i++){
//            wantStation.put(want[i], number[i]);
//        }
//    }
}
