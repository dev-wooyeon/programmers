package java.level2;

import java.util.Scanner;

public class CorrectParentheses {

    /// Fields

    /// Constructor
    public CorrectParentheses() {
        problem();
    }

    private void problem() {

        StringBuilder test_case = new StringBuilder();
        test_case.append(" 1. ()() ");
        test_case.append(" 2. (())() ");
        test_case.append(" 3. )()( ");
        test_case.append(" 4. (()( ");
        System.out.println(test_case);
        System.out.print("테스트 케이스를 선택 : ");

        String s;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    s = "()()";
                    break;
                case 2:
                    s = "(())()";
                    break;
                case 3:
                    s = ")()(";
                    break;
                case 4:
                    s = "(()(";
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    s = "()()";
                    break;
            }
        }

        boolean result = solution(s);
        System.out.println("result : " + result);

    }

    public boolean solution(String s) {
        boolean answer = false;

        // 짝수가 아니거나 ) 으로 시작하는 경우
        if(s.length() % 2 != 0) return false;

        int count = 0;

        for(int i=0 ; i < s.length() ; ++i) {
            if(s.charAt(i) == '(') {
                count ++;
            }
            if(s.charAt(i) == ')') {
                count --;
            }
            if(count < 0) {
                break;
            }
        }

        if (count == 0 ) answer = true;

        return answer;
    }
}
