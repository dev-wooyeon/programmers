package level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sum_Cnt_Of_Measure {

    /// Fields

    /// Contructor
    public Sum_Cnt_Of_Measure() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("====================================");

        System.out.println("문제설명");
        System.out.println("  두 정수 left와 right가 매개변수로 주어집니다.");
        System.out.println("  left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고, ");
        System.out.println("  약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요 ");
        System.out.println("제한 사항");
        System.out.println("  1 ≤ left ≤ right ≤ 1,000 ");
        System.out.println("테스트 케이스");
        System.out.println("  1. left:13, right:17, result:43");
        System.out.println("  2. left:24, right:27, result:52");
        System.out.print("테스트 케이스를 선택 : ");
        int left = 0;
        int right = 0;

        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    left = 13;
                    right = 17;
                    break;
                case 2:
                    left = 24;
                    right = 27;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    left = 13;
                    right = 17;
                    break;
            }
        }
        System.out.println("====================================");
        int result = solution(left, right);

        System.out.print("result : " + result);

    }

    private int solution(int left, int right) {
        int answer = 0;


        for (int i = left ; i <= right ; i ++){

            int count = 0;

            for (int j = 1; j <= i/2; ++j) {
                System.out.println(" i = " + i + ", j = " + j);
                if (i % j == 0) {
                    count++;
                }
            }
            count++;

            System.out.println(" count = " + count + ", i = " + i);
            if(count % 2 == 0){
                answer += i;
            } else {
                answer -= i;
            }

        }

        System.out.println("answer = " + answer);


        return answer;
    }

}

