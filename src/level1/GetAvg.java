package level1;

import java.util.Arrays;
import java.util.Scanner;

public class GetAvg {

    /// Fields

    /// Contructor
    public GetAvg() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. arr[1,2,3,4]");
        System.out.println("2. arr[5,5]");
        System.out.print("테스트 케이스를 선택 : ");

        int[] arr = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    arr = new int[]{1, 2, 3, 4};
                    break;
                case 2:
                    arr = new int[]{5, 5};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    arr = new int[]{1, 2, 3, 4};
                    break;
            }
        }

        double result = solution(arr);
        System.out.print(" result : " + result);

    }

    public double solution(int[] arr) {

        double answer = 0.0;

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        answer = sum / arr.length;


        return answer;
    }

    public double solution2(int[] arr) {

        double answer = 0.0;

        answer = Arrays.stream(arr).average().orElse(0);

        return answer;
    }

}
