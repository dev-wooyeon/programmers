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

        Stack<Integer> stack = new Stack<>();
        int temp = n;
        while(temp > 0){

            stack.push(temp % 3);
            temp = temp / 3;

        }

        System.out.println("stack.size() = " + stack.size());

        for (int i = 0; i < stack.size(); i++) {

            System.out.println("stack.pop() = " + stack.pop());

        }

        return answer;
    }



}