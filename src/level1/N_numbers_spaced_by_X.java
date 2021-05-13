package level1;

import java.util.Scanner;

public class N_numbers_spaced_by_X {
    
    /// Fields

    /// Contructor
    public N_numbers_spaced_by_X() {
        super();

        problem();
    }

    /// Method
    public void problem(){

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. x:2 n:5");
        System.out.println("2. x:4 n:3");
        System.out.println("3. x:-2 n:2");
        System.out.print("테스트 케이스를 선택 : ");

        int x = 0;
        int n = 0;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try(Scanner scan = new Scanner(System.in)){
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    x = 2;
                    n = 5;
                    break;
                case 2:
                    x = 4;
                    n = 3;
                    break;
                case 3:
                    x = -4;
                    n = 2;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    x = 2;
                    n = 5;
                    break;
            }
        }
        
        long[] results = solution(x, n);
        System.out.print("result :");
        for (long result : results) {
            System.out.print(result);    
        }

    }

    private long[] solution(int x, int n) {

        long[] answer = new long[n];

        for (int i = 0; i < n; ++i) {
            answer[i] = (long) x * (i+1);
        }
        return answer;
    }

}
