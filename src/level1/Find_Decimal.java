package level1;

import java.util.Arrays;
import java.util.Scanner;

public class Find_Decimal {

    /// Fields

    /// Contructor
    public Find_Decimal() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("이거 아직 안푼 문제다 은우야. 풀고 블로그 글 쓰자 ");

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.");
        System.out.println("  소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.");
        System.out.println("  (1은 소수가 아닙니다.)");
        System.out.println("");
        System.out.println("제한사항");
        System.out.println("  n은 2이상 1000000이하의 자연수입니다.");
        System.out.println("");
        System.out.println("테스트 케이스");
        System.out.println("  1. n : 10 ");
        System.out.println("  2. n : 5");
        System.out.print("테스트 케이스를 선택 : ");

        int n = 0;
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1:
                    n = 10;
                    break;
                case 2:
                    n = 5;
                    break;
                default:
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    n = 10;
                    break;
            }
        }


        int result = solution(n);
        System.out.println(result);

    }

    private int solution(int n) {

        int answer = 0;

        for(int i = 2 ; i <= n ; ++i){

            for(int j = 2; j*j <= i ; ++j) {
                if(i % j == 0) {

                } else {
                    System.out.println("i = " + i + ", j = " + j);
                    answer ++;
                }
            }
        }


        return answer;
    }



}
