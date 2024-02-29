
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(10,2);
        System.out.println(result);
    }

}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // - 가로길이 >= 세로 길이

        // brown은 테두리에만 있으므로 모서리의 값 빼면
        // 10-4 = 6
        // 6을 4로 나눔 = 1..2  -> 세로
        // 2를 2로 나눔 = 1 -> 가로 추가
        // 2 + 모서리 2  = 4
        // 2 + ( 2/2 ) = 3

        // 24-4 = 20
        // 20 /4 = 5
        // 가로 5 + 2
        // 세로 5 + 1


        return answer;
    }
}