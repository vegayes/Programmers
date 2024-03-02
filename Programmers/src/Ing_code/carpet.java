package Ing_code;

public class carpet {

    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};

            // - 가로길이 >= 세로 길이

            // brown은 테두리에만 있으므로 모서리의 값 빼면
            // 10-4 = 6
            // 6을 4로 나눔 = 1..2  -> 세로(1) ,가로(1) 칸
            // => 나머지로 2 ==> 2를 2로 나눔=> 1 = 1+1
            // 노랑 2 => 가로가 몇? 2 =>
            //  2+ 2 = 4
            // 1+ 2= 3

            // 24-4 = 20
            // 20 %4 = 4...0 세로(4) 가로(4)
            // 0 / 2 = 0
            // 노랑 가로 : 24 / 4 = 6
            // 세로





            return answer;
        }
    }
}
