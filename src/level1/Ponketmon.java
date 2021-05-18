package level1;

import java.util.HashMap;

public class Ponketmon {

    public Ponketmon() {
        System.out.println(getClass().getName() + " Create Default Constructor ");

        problem();
    }

    public void problem() {

        int key = 3;
        int[] nums = {};
        switch (key) {
            case 1:
                nums = new int[]{3, 1, 2, 3};
                break;
            case 2:
                nums = new int[]{3, 3, 3, 2, 2, 4};
                break;
            case 3:
                nums = new int[]{3, 3, 3, 2, 2, 2};
                break;
            default:
                break;
        }

        solution(nums);

    }

    public void solution(int[] nums) {

        int answer = 0;

        // STEP 001. 해쉬맵 데이터 객체 생성
        HashMap<Integer, Integer> hsm = new HashMap<Integer, Integer>();

        // STEP 002. 선택할수 있는 개수를 담는 canPickCnt 변수 선언
        int canPickCnt = nums.length / 2;

        // STEP 003. 건수를 포함하여 확인을 하기위해 getOrDefault 메소드 사용하여 hsm에 put
        for (Integer num : nums) hsm.put(num, hsm.getOrDefault(num, 0) + 1);

        // 해쉬맵 디버깅
        // System.out.println(" 해쉬맵 데이터 확인 : " + hsm.toString());

        // STEP 004. 선택할수 있는 건수와 맵에 담겨있는 사이즈를 비교한다.
        // STEP 004-1. 선택가능한 건수가 해쉬맵에 담긴 사이즈보다 작거나 같은경우
        // STEP 004-2. 선택가능한 건수를 답안지 세팅한다. (nums len : 6, canPickCnt : 3, hsm size : 3, answer = 3)
        // STEP 004-3. 만약 해쉬맵의 사이즈가 선택가능한 건수보다 큰 경우에는
        // STEP 004-4. 해쉬맵의 사이즈를 답안지 세팅한다. (nums len : 6, canPickCnt : 3, hsm size : 2, answer = 2)
        if (canPickCnt <= hsm.size()) answer = canPickCnt;
        else answer = hsm.size();

        System.out.println(" 답안지 : " + answer);
    }
}   
