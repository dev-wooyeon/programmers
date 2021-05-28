package level1;

import java.util.Scanner;

public class MakeIntArr {


    /// Fields

    /// Contructor
    public MakeIntArr() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("====================================");

        System.out.println("문제설명");
        System.out.println("  자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.");
        System.out.println("제한 사항");
        System.out.println("  n은 10,000,000,000이하인 자연수입니다.");
        System.out.println("테스트 케이스");
        System.out.println("  1. 12345");
        System.out.print("테스트 케이스를 선택 : ");
        long n = 0;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    n = 12345;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    n = 12345;
                    break;
            }
        }
        System.out.println("====================================");
        int[] results = solution(n);
        System.out.print("answer : [");
        for (int result:results) {
            System.out.print(result + ",");
        }
        System.out.print("]");

    }

    private int[] solution(long n) {

        char[] chars = Long.toString(n).toCharArray();
        int[] answer = new int[chars.length];
        for (int i = 0; i < chars.length ; i++) {
            answer[i] = (int) chars[chars.length-i-1]-48;
        }

        return answer ;
    }
}
