package level2;

import java.util.Scanner;

public class PressKeypad {

    /// Fields

    /// Constructor
    public PressKeypad() {
        problem();
    }

    /// Method
    public void problem() {
        System.out.println("2021 카카오 채용연계형 인턴십 [숫자 문자열과 영단어]");
        System.out.println("테스트 케이스");
        System.out.println(" 1. numbers : [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], hand : right, result : LRLLLRLLRRL");
        System.out.println(" 2. numbers : [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], hand : left, result : LRLLRRLLLRR");
        System.out.println(" 3. numbers : [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]     hand : right, result : LLRLLRLLRL");
        System.out.print("테스트 케이스를 선택 : ");

        int[] numbers;
        String hand = "";
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1 :
                    numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
                    hand = "right";
                    break;
                case 2 :
                    numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
                    hand = "left";
                    break;
                case 3 :
                    numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
                    hand = "right";
                    break;
                default :
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    numbers = new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
                    hand = "right";
                    break;
            }
        }

        String answer = solution(numbers, hand);
        System.out.println("answer : " + answer);
    }

    private String solution(int[] numbers, String hand) {

        StringBuilder answer = new StringBuilder();

        /**
         * 1 2 3         1  2  3
         * 4 5 6    ->   4  5  6
         * 7 8 9         7  8  9
         * * 0 #        10 11 12
         */
        int L_hand = 10; // *
        int R_hand = 12; // #

        for (int number : numbers) {

            if(number == 0) number = 11;

            int part = number % 3;

            // DEBUG
            // System.out.println("number : " + number + ", part : " + part + ", L_hand : " + L_hand + ", R_hand : " + R_hand);

            // 3열 (오른쪽)
            if(part == 0) {
                R_hand = number;
                answer.append("R");
                continue;
            }
            // 1열 (왼쪽)
            if(part == 1) {

                L_hand = number;
                answer.append("L");
                continue;

            }
            // 2열 (중앙)
            if(part == 2) {

                int calL = Math.abs(L_hand - number);
                int calR = Math.abs(R_hand - number);

                int distanceL = (calL % 3) + (calL / 3);
                int distanceR = (calR % 3) + (calR / 3);

                if (distanceL < distanceR) {
                    L_hand = number;
                    answer.append("L");
                }

                if (distanceL > distanceR) {
                    R_hand = number;
                    answer.append("R");
                }

                if (distanceL == distanceR) {
                    if ("left".equals(hand)) {
                        L_hand = number;
                        answer.append("L");
                    } else {
                        R_hand = number;
                        answer.append("R");
                    }
                }
            }

        }

        return answer.toString();
    }
}
