package END_class;

import java.util.PriorityQueue;

public class Heap_2 {


    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = {0,0};

            /*
             * | 숫자 : 큐에 주어진 숫자 삽입
             *
             * D 1 : 큐에서 최댓값을 삭제
             *
             * D -1 : 큐에서 최솟값을 삭제
             *
             * 큐가 비어있음 = [0,0]
             *             => [최댓값 , 최솟값]
             */

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); // 최대 힙

            for (String operation : operations) {
                String[] option = operation.split(" ");

                if (option[0].equals("I")) {
                    int num = Integer.parseInt(option[1]);
                    minHeap.offer(num);
                    maxHeap.offer(num);
                } else if (option[0].equals("D")) {
                    if (!minHeap.isEmpty()) {
                        if (option[1].equals("1")) {
                            // 최대값 삭제
                            int maxElement = maxHeap.poll();
                            minHeap.remove(maxElement);
                        } else if (option[1].equals("-1")) {
                            // 최솟값 삭제
                            int minElement = minHeap.poll();
                            maxHeap.remove(minElement);
                        }
                    }
                }
            }

            if (!minHeap.isEmpty()) {
                answer[0] = maxHeap.peek();
                answer[1] = minHeap.peek();
            }

            return answer;
        }
    }
}
