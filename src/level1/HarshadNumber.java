package level1;

import java.util.Scanner;

public class HarshadNumber{

    /// Fields

    /// Contructor
    public HarshadNumber() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("====================================");

        System.out.println("문제설명");
        System.out.println("  양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.");
        System.out.println("  예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.");
        System.out.println("  자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.");
        System.out.println("제한 사항");
        System.out.println("  x는 1 이상, 10000 이하인 정수입니다.");
        System.out.println("테스트 케이스");
        System.out.println("  1. 10 true");
        System.out.println("  2. 12 true");
        System.out.println("  3. 11 false");
        System.out.println("  4. 13 false");
        System.out.print("테스트 케이스를 선택 : ");

        int x;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    x = 10;
                    break;
                case 2:
                    x = 12;
                    break;
                case 3:
                    x = 11;
                    break;
                case 4:
                    x = 13;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    x = 10;
                    break;
            }
        }
        System.out.println("====================================");
        boolean result = solution(x);

        System.out.print("result : " + result);

    }

    public boolean solution(int x){

        boolean answer = true;
        String temp = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < temp.length() ; i++) {
            sum += temp.charAt(i)-48;
        }
        System.out.println(" sum : " + sum);

        if (x % sum != 0) answer = false;


        return answer ;
    }

}

