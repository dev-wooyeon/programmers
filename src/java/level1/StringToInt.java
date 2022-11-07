package java.level1;

import java.util.Scanner;

public class StringToInt {

    /// Fields

    /// Contructor
    public StringToInt() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("이거 아직 안푼 문제다 은우야. 풀고 블로그 글 쓰자 ");

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.                  ");
        System.out.println("제한사항");
        System.out.println("  s의 길이는 1 이상 5이하입니다. \n");
        System.out.println("  s의 맨앞에는 부호(+, -)가 올 수 있습니다. \n");
        System.out.println("  s는 부호와 숫자로만 이루어져있습니다. \n");
        System.out.println("  s는 \"0\"으로 시작하지 않습니다. \n");
        System.out.println("테스트 케이스");
        System.out.println("  1. 1234 return : 1234 ");
        System.out.println("  2. -1234  return : -1234 ");
        System.out.print("테스트 케이스를 선택 : ");

        String s;
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1 :
                    s = "1234";
                    break;
                case 2 :
                    s = "-1234";
                    break;
                default :
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    s = "1234";
                    break;
            }
        }


        int result = solution(s);

        System.out.println(" result : " + result);




    }

    private int solution(String s) {
        int answer = 0;

        if ('-' == s.charAt(0)){
            answer = Integer.parseInt(s.substring(1,s.length())) * -1;
        } else {
            answer = Integer.parseInt(s.substring(0, s.length()));
        }

        return  answer;
    }
}