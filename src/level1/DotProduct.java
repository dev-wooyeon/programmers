package level1;

import java.util.Scanner;

public class DotProduct {

    /// Fields

    /// Contructor
    public DotProduct() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. a[1,2,3,4] b[-3,-1,0,2]");
        System.out.println("2. a[-1,0,1] b[1,0,-1] ");
        System.out.print("테스트 케이스를 선택 : ");

        int[] a = {};
        int[] b = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    a = new int[]{1, 2, 3, 4};
                    b = new int[]{-3, -1, 0, 2};
                    break;
                case 2:
                    a = new int[]{-1, 0, 1};
                    b = new int[]{1, 0, -1};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    a = new int[]{1, 2, 3, 4};
                    b = new int[]{-3, -1, 0, 2};
                    break;
            }
        }

        int result = solution(a, b);
        System.out.println(" result : " + result);
    }

    public int solution(int[] a, int[] b) {

        int answer = 0;

        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i] + " * " + b[i]);
            answer += a[i] * b[i];
        }

        return answer;
    }
}