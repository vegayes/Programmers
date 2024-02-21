import java.lang.reflect.Array;
import java.util.*;


class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] result = sol.solution(4);
        System.out.println(result);
    }

}

/*

1) n개
n
list [1] + [2] + [3] + [4]

2) 맨 마지막은 4개 순서대로
3) i +

 */

class Solution {
    public int[] solution(int n) {
        int[] answer = {};

        ArrayList<ArrayList<Integer>> listBox = new ArrayList<>(n);

        // 1) 리스트 만들어서
        for(int i = 0; i<n; i++){
            listBox.add(new ArrayList<>(i+1));
        }


        // 2) n개의 리스트 돌림
        for(int a = 0; a<listBox.size(); a++){

            // 2-1) 첫 번째 인덱스에 값 넣기
            listBox.get(a).add(a+1);

            // 2-2) 마지막 줄 
            if(a == listBox.size()-1){
                // 2-3) 마지막 줄 오른쪽 증가
                for(int lastLine = 1; lastLine <= listBox.get(a).size(); lastLine++){
                    listBox.get(a).add(a+1+lastLine);
                }
            }

            System.out.println(listBox);


        }


        return answer;
    }
}








class SolutionSplitString {
    public int solution(int n) {
        int answer = 0;

        String[] splitStr = Integer.toString(n).split("");

        for(int i = 0; i < splitStr.length; i++){
            answer += Integer.parseInt(splitStr[i]);
        }



        return answer;
    }
}

class Solutionlong {
    public long[] solution(int x, int n) {

        ArrayList<Long> arrList = new ArrayList<Long>();

        for (int i = 0; i < n; i++) {
            arrList.add((long) x * i + x);
        }

        long[] answer = arrList.stream().mapToLong(i -> i).toArray();

        return answer;
    }
}






/*2023-02-20*/
class SolutionSum {
    public boolean solution(int x) {
        boolean answer = false;

        int sum = 0;
        String stringInt = Integer.toString(x);
        String[] splitInt = stringInt.split("");

        System.out.println(Arrays.toString(splitInt));

        for(int i = 0; i < splitInt.length; i++) {
            sum += Integer.parseInt(splitInt[i]);
        }

        if(x % sum == 0){
            answer = true;
        }
        return answer;
    }
}


class SolutionSplit {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;

        // ArrayList로 변경
        List<String> spellList = Arrays.asList(spell);
        List<String> dicList = Arrays.asList(dic);

        int check = 0;

        // 1) 제작한 값 하나씩 돌기
        for(int i = 0; i < dicList.size(); i++){
          check = 0;
          for(int j = 0; j < spellList.size(); j++){
              // 2) 값 포함하는 지 확인
              if(dicList.get(i).contains(spellList.get(j))){
                  check++;
              }
          }
          if(check == spellList.size()){
                answer = 1;
          }
        }
        return answer;
    }
}

class SolutionNoReapeat {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int a = 0; a <arr.length; a++){
            if(a == 0){
                list.add(arr[a]);
                a++;
            }

            if(arr[a] != arr[a-1]){
                list.add(arr[a]);
            }
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}


class Solution_wallPaper {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        Map<Integer, Integer> xMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> yMap = new HashMap<Integer, Integer>();

        int minX = 0;
        int minY = 0;
        int maxX = 0;
        int maxY = 0;

        for(int x = 0; x < wallpaper.length; x++){
            int count = 0;
            String[] splitLine = wallpaper[x].split("");
            System.out.println(Arrays.toString(splitLine)+"\n");

            for(int y = 0; y<splitLine.length; y++){
                if(splitLine[y].equals("#")){
                    yMap.put(y,0);
                    count++;
                }
            }

            if(count > 0){
                xMap.put(x,0);

                count = 0;
            }

            // 끝난 경우
            if(x == wallpaper.length-1){
                System.out.println("끝남 ");
               minX = Collections.min(xMap.keySet());
               minY = Collections.min(yMap.keySet());

               maxX = Collections.max(xMap.keySet());
               maxY = Collections.max(yMap.keySet());
            }
        }
        answer = new int[] {minX, minY, maxX+1, maxY+1};

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}