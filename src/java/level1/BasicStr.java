package java.level1;

import java.util.Scanner;

public class BasicStr {

    /// Fields

    /// Contructor
    public BasicStr() {
        super();

        problem();
    }

    /// Method

    public static void main(String[] args) {
        new BasicStr();
    }

    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. s:a234");
        System.out.println("2. s:1234");
        System.out.print("테스트 케이스를 선택 : ");

        String s;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    s = "a234";
                    break;
                case 2:
                    s = "1234";
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    s = "a234";
                    break;
            }
        }

        boolean result = solution(s);
        System.out.println("result : " + result);
    }

    public boolean solution(String s) {

        boolean answer = true;

        System.out.println(s.length());
        if (s.length() != 4 && s.length() != 6)
            answer = false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                answer = false;
            }
        }

        return answer;
    }

}