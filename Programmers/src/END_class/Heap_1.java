package END_class;

import java.util.PriorityQueue;

public class Heap_1 {


    /*
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 1) 리스트의 값을 정렬함. 오름차순으로
        Arrays.sort(scoville);

        while(!checkAllValue(scoville, K)){
            int newFoodScoville = scoville[0] + (scoville[1] * 2) ;
            scoville[0] = newFoodScoville;

            int[] newArray = IntStream.range(0, scoville.length)
                    .filter(idx -> idx != 1)
                    .map(idx -> scoville[idx])
                    .toArray();

            // 새로운 배열을 기존 배열에 복사
            System.arraycopy(newArray, 0, scoville, 0, newArray.length);

            Arrays.sort(scoville);
            answer++;
        }
        return answer;
    }

    private static boolean checkAllValue(int[] array, int k) {
        int index = 0;

        // 배열의 모든 값이 k 이상인지 확인
        while (index < array.length) {
            if (array[index] < k) {
                return false;
            }
            index++;
        }
        return true;
    }
}

 */

    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            // 최소 힙 구현
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            for (int s : scoville) {
                heap.offer(s);
            }

            while (heap.peek() < K) {
                if (heap.size() < 2) {
                    return -1;
                }

                int newFoodScoville = heap.poll() + (heap.poll() * 2);
                heap.offer(newFoodScoville);
                answer++;
            }

            return answer;
        }
    }
}
