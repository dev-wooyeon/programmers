package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 프로그래머스 Level 1. 두개 뽑아서 더하기 SumTwoInt
 */
public class SumTwoInt {

    /// Fields

    /// Constructor
    public SumTwoInt() {
        System.out.println(getClass().getName() + " Create Default Constructor ");
        problem();
    }

    /// 문제
    public void problem() {

        int key = 1;
        int[] numbers = {};
        switch (key) {
            case 1:
                numbers = new int[]{2, 1, 3, 4, 1};
                break;
            case 2:
                numbers = new int[]{2, 1, 3, 4, 1};
                break;
            default:
                break;
        }

        solution(numbers);
    }

    public void solution(int[] numbers) {

        int[] answer = {};

        // 합계 리스트 생성
        List<Integer> sumList = new ArrayList<Integer>();

        // 0번째 인덱스부터 numbers의 길이만큼 돌 Outer for
        for (int i = 0; i < numbers.length; i++) {
            // 1번째 인덱스부터 numbers의 길이만큼 돌 Inner for
            for (int j = i + 1; j < numbers.length; j++) {
                // 합계 데이터 
                int sum = numbers[i] + numbers[j];
                // 합계 데이터가 없으면 -1를 반환하는 indexOf 사용
                if (sumList.indexOf(sum) < 0) {
                    // 합계 데이터 추가
                    sumList.add(sum);
                }
            }
        }

        // 리스트의 사이즈 만큼 생성
        answer = new int[sumList.size()];
        // 답안지 세팅
        for (int i = 0; i < sumList.size(); i++) {
            answer[i] = sumList.get(i);
        }
        // 정렬
        Arrays.sort(answer);

        // DEBUG
        for (int i = 0; i < answer.length; i++) {
            System.out.println(" :: " + answer[i]);
        }
    }
}