package level1;

import java.util.Scanner;
import java.util.Stack;

public class Triad_Flip {

    /// Fields

    /// Contructor
    public Triad_Flip() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  자연수 n이 매개변수로 주어집니다. ");
        System.out.println("  n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요. ");
        System.out.println("");
        System.out.println("제한사항");
        System.out.println("  n은 1 이상 100,000,000 이하인 자연수입니다.");
        System.out.println("");
        System.out.println("테스트 케이스");
        System.out.println("  1. n : 45 ");
        System.out.println("  2. n : 125");
        System.out.print("테스트 케이스를 선택 : ");

        int n = 0;
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1:
                    n = 45;
                    break;
                case 2:
                    n = 125;
                    break;
                default:
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    n = 45;
                    break;
            }
        }


        int result = solution(n);
        System.out.println(result);

    }

    private int solution(int n) {

        int answer = 0;

        // LIFO 구조체 선언
        Stack<Integer> stack = new Stack<>();

        // 입력받은 10진수 n이 0보다 크다면 반복한다.
        while(n > 0){
            // 10진수 45 -> 3진수 1200 -> 뒤집으면 0021
            stack.push(n % 3);
            // n을 나눈 몫을 저장하여 while문을 제어한다.
            n = n / 3;
        }

        // 제곱승 변수
        int squared = 0;
        // 스택이 비어있지 않으면
        while (!stack.empty()) {
            // 답안지세팅 (
            // ( stack.pop() = 1 ) * ( Math.pow(3, squared++) = 3^0 = 1 ) = 1
            // ( stack.pop() = 2 ) * ( Math.pow(3, squared++) = 3^1 = 3 ) = 6
            answer += stack.pop() * Math.pow(3, squared++);
        }

        return answer;
    }



}