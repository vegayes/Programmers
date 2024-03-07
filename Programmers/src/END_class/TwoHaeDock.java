package END_class;

public class TwoHaeDock {

    class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";

            int skipCount = 0;
            String[] skipArr = new String[skip.length()];

            //1) skip 배열 만들기
            for(int a = 0 ; a<skipArr.length; a++){

                skipArr[a] = String.valueOf(skip.charAt(a));

            }

            // 2) 문자열 길이만큼 for문 돌림
            for(int i = 0; i < s.length(); i++){

                // 3) firstString 첫 index에 맞는 값 축적
                for(int count = 1; count <= index ; count++ ){
                    char str = (char)(s.charAt(i) + count);

                    for(int a = 0; a < skipArr.length; a++){
                        if(String.valueOf(str).equals(skipArr[a])){
                            skipCount++;
                        }
                    }
                }

                char asciiChar = (char)(s.charAt(i)+skipCount+index);


                if(asciiChar  > 'z'){
                    System.out.println("들러옴");
                    asciiChar = (char) (asciiChar - ('z' - 'a' + 1));
                }

                answer += asciiChar ;

                // 초기화
                skipCount = 0;
            }

            return answer;
        }
    }
}
