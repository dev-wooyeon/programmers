package java.level1;

import java.util.Scanner;

public class SignsPlus {

    /// Fields

    /// Contructor
    public SignsPlus() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. absolutes[4,7,12] signs[true,false,true]");
        System.out.println("2. absolutes[1,2,3] signs[false,false,true] ");
        System.out.print("테스트 케이스를 선택 : ");

        int[] absolutes = {};
        boolean[] signs = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    absolutes = new int[]{4, 7, 12};
                    signs = new boolean[]{true, false, true};
                    break;
                case 2:
                    absolutes = new int[]{1, 2, 3};
                    signs = new boolean[]{false, false, true};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    absolutes = new int[]{4, 7, 12};
                    signs = new boolean[]{true, false, true};
                    break;
            }
        }

        int result = solution(absolutes, signs);
        System.out.println("result : " + result);
    }

    public int solution(int[] absolutes, boolean[] signs) {

        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (!signs[i]) {
                answer -= absolutes[i];
            } else {
                answer += absolutes[i];
            }
        }

        return answer;
    }

}
