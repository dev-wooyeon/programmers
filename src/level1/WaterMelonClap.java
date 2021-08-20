package level1;

import java.util.Scanner;

public class WaterMelonClap {

    /// Fields

    /// Contructor
    public
    WaterMelonClap() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. n:3");
        System.out.println("2. n:4");
        System.out.print("테스트 케이스를 선택 : ");

        int n;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    n = 3;
                    break;
                case 2:
                    n = 4;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    n = 3;
                    break;
            }
        }

        String result = solution(n);
        System.out.println("result : " + result);
    }

    public String solution(int n) {

        String answer = "";


        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) answer += "수";
            else answer += "박";

        }


        return answer;
    }

}
