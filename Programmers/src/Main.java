
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] result = sol.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
       int result = sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        System.out.println(result);
    }

}

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 서로 다른 종류의 수를 최소화 시키고자 함.

        // 정렬 시킴

        // 1,2,2,3,3,4,5,5
        // 2,2,3,3,5,5,1,4

        Map<Integer, Integer> tan = new HashMap<>();


        for(int i = 0; i < tangerine.length; i++){
            if(!tan.containsKey(tangerine[i])){
                tan.put(tangerine[i], 1);
            }else{
                tan.put(tangerine[i],tan.get(tangerine[i])+1);
            }
        }

        List<Integer> listKeySet = new ArrayList<>(tan.keySet());

        Collections.sort(listKeySet, (value1, value2) -> (tan.get(value2).compareTo(tan.get(value1))));

        for(int key : listKeySet) {
            if( k > 0 ){
                answer++;

                k = k - tan.get(key);

            }else{
                break;
            }
        }

        return answer;
    }
}