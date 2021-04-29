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

    public void problem() {

        int key = 1;
        int[] numbers = {};
        switch (key) {
            case 1:
                numbers = new int[] { 2, 1, 3, 4, 1 };
                break;
            case 2:
                numbers = new int[] { 2, 1, 3, 4, 1 };
                break;
            default:
                break;
        }

        solution(numbers);
    }

    public void solution(int[] numbers) {

        int[] answer = {};
        List<Integer> sumList = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int a = numbers[i] + numbers[j];
                if (sumList.indexOf(a) < 0) {
                    sumList.add(a);
                }
            }
        }

        answer = new int[sumList.size()];
        for (int i = 0; i < sumList.size(); i++) {
            answer[i] = sumList.get(i);
        }
        Arrays.sort(answer);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(" :: " + answer[i]);
        }
    }
}