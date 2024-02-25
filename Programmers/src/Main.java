
import java.lang.reflect.Array;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int result = sol.solution(10,40,5);
        System.out.println(result);
    }

}

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;

<<<<<<< HEAD
=======
        
>>>>>>> 5a8632976d91f0c4101f620588cc2db379a4848c
        int[] countArray = new int[3];

        for(int i = 0; i < countArray.length; i++){
            int count = 0; // 진행 값
            int num = 0; // 누적
            while(num < 10){
                System.out.println("들어옴");
                if(i == 0){
                    // n을 더함
                    if(num == 0){
                        // 처음
                        num = x + n;
                        break;
                    }else{
                        num += n;
                    }
                    count++;
                }

                System.out.println("num:" + num);

            }

            countArray[i] = count;
        }



        return answer;
    }
}

class SolutionPersonal {
    // 성격유형 검사
    // - 매우동의 , 매우 비동의 : 3
    // - 동의, 비동의 : 2
    // - 약간 동의, 약간 비동의 : 1
    // - 모르겠음 : 0
    // 각 유형에서 더 높은 점수를 받은 것을 따름.
    // 동일한 점수인 경우 지표의 사전 순으로

    // 1) "RT"의 경우  R : 비동의 / T : 동의

    // 2) survey == choices
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        String[] personal = new String[]{"R","T", "C", "F", "J", "M", "A", "N"};

        Map<String,Integer> personalityScore = new HashMap<>();

        // +) 유형의 key 만들기
        for(int a = 0; a < personal.length; a++){
            personalityScore.put(personal[a], 0);
        }

        // 1) survey 접근하기
        for(int i = 0; i < survey.length; i++){

           // 1-1) 해당 값

            // 1-2) 값 나누기
            String[] surveySplit = survey[i].split("");

            String front = surveySplit[0];
            String back = surveySplit[1];

            // 1-3) 점수
            int choice = choices[i];

            // => 1 ~ 3 은 앞 캐릭터
            // => 4 통과
            // => 5 ~ 7 은 뒷 캐릭터
            switch (choice){
                case 1:
                    personalityScore.put(front, personalityScore.get(front)+3);
                    break;
                case 2:
                    personalityScore.put(front, personalityScore.get(front)+2);
                    break;
                case 3:
                    personalityScore.put(front, personalityScore.get(front)+1);
                    break;
                case 5:
                    personalityScore.put(back, personalityScore.get(back)+1);
                    break;
                case 6:
                    personalityScore.put(back, personalityScore.get(back)+2);
                    break;
                case 7:
                    personalityScore.put(back, personalityScore.get(back)+3);
                    break;
                default:
                    break;
            }
        }

        String[] setting = new String[]{"RT", "CF", "JM", "AN"};

        for(int count = 0; count<setting.length; count++){

            String[] split = setting[count].split("");

            String split1 = split[0];
            String split2 = split[1];

            if(personalityScore.get(split1) >= personalityScore.get(split2)){
                answer += split1;
            }else{
                answer += split2;
            }
        }

        System.out.println(personalityScore);


        return answer;
    }
}












    class SolutionParking {
        public int[] solution(int[] fees, String[] records) {

            //기본 설정
            int defaultTime = fees[0];
            int defaultPay = fees[1];
            int unitTime = fees[2];
            int unitPay = fees[3];

            // map으로 생성
            Map<String,ArrayList<Integer>> carTimeMap = new HashMap<>();

            // 1) records를 split함.
            for(int i = 0; i < records.length; i++){
                // 1-1) split하기   splitRecord[05:34, 5961, IN]
                String[] splitRecord = records[i].split(" ");
                String[] time = splitRecord[0].split(":");

                // 시간-> 분으로 표시
                int minute = (Integer.parseInt(time[0]) * 60) + (Integer.parseInt(time[1])) ;

                // 1-2)key가 없는 경우 -> ArrayList 만들기
                if(!carTimeMap.containsKey(splitRecord[1])){
                    carTimeMap.put(splitRecord[1], new ArrayList<>(Arrays.asList(minute)));
                }else{
                    // 1-3) key가 있는 경우 -> 해당 key에 value 추가하기
                    carTimeMap.get(splitRecord[1]).add(minute);
                }

            }
            System.out.println(carTimeMap);

            // 2) key 저장 ( 오름차순 )
            String[] keyArray = carTimeMap.keySet().toArray(new String[0]);
            Arrays.sort(keyArray);

            int[] answer = new int[keyArray.length];
            // 2-1) key값에 따라 돎
            for(int index =0; index < keyArray.length; index++ ){

                Integer[] valueArray = carTimeMap.get(keyArray[index]).toArray(new Integer[0]);

                int cumulativeTime =0;

                // 2-2) key에 해당하는 value 접근 ( 2개가 짝 )
                for(int count = 0 ; count < valueArray.length; count++){
                    // 2-3) 마지막 값이면서, 홀수인 경우뒤에 값이 없는 경우 23:59분 추가
                    if((count == valueArray.length-1) && (valueArray.length%2 == 1)){
                        int lastTime = (60*23) + 59;
                        int lastUseTime = lastTime-valueArray[count];
                        cumulativeTime += lastUseTime;
                    }

                    // 2-4) 인덱스 기준 홀수
                    if(count%2 == 1){
                        cumulativeTime += (valueArray[count] - valueArray[count-1]);
                    }
                }

                // 3) 주차요금
                double calTime = (double) (cumulativeTime - defaultTime) /unitTime;
                int overTime = (int) Math.ceil(calTime);
                if(cumulativeTime-defaultTime >=0){
                    answer[index] = defaultPay + overTime * unitPay;
                }else{
                    answer[index] =defaultPay;
                }

            }

            return answer;
        }
    }





class Solution_triangle_snail{
    public int[] solution(int n) {
        int[] answer = {};

        ArrayList<ArrayList<Integer>> listBox = new ArrayList<>(n);

        // +) 마지막 수
        int total = (n+1) * n / 2;

        // 1) 리스트 만들어서
        for(int i = 0; i<n; i++){
            listBox.add(new ArrayList<>(i+1));
        }

        int index_h = 0;
        int mode = 0;
        int max_count = n;
        int lastLine = n-1;
        // 2) total만큼 리스트 돌림
        for(int a = 1, count = 0; a <= total; a++, count++){

           if(mode % 3 == 0) {
                listBox.get(index_h).add(mode/3,a);
                index_h++;

            }

            if(mode % 3 == 1) {
                int backCount = listBox.get(lastLine-(mode/3)).size();
                listBox.get(lastLine-(mode/3)).add(backCount-mode/3,a);
            }

            if(mode % 3 == 2){
                int backCount2 = listBox.get(index_h-2).size();
                listBox.get(index_h-2).add(backCount2-mode/3,a);
                index_h--;
            }

            if(count == max_count-1) {
                mode++;
                count = -1;
                max_count--;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(ArrayList<Integer> list1 : listBox) {
            arrayList.addAll(list1);
        }

        answer = arrayList.stream().mapToInt(Integer::intValue).toArray();


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