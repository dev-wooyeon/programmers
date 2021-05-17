package level1;

import java.util.Scanner;

public class SumMeasure {
    
    /// Fields

    /// Contructor
    public SumMeasure() {
        super();

        problem();
    }

    /// Method
    public void problem(){

        System.out.println("====================================");
        
        System.out.println("문제설명");
        System.out.println("  정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.");
        System.out.println("제한 사항");
        System.out.println("  n은 0 이상 3000이하인 정수입니다.");
        System.out.println("테스트 케이스");
        System.out.println("  1. n:12 (12의 약수는 1, 2, 3, 4, 6, 12입니다. 이를 모두 더하면 28입니다.)");
        System.out.println("  2. n:5 (5의 약수는 1, 5입니다. 이를 모두 더하면 6입니다.)");
        System.out.print("테스트 케이스를 선택 : ");
        int n = 0;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try(Scanner scan = new Scanner(System.in)){
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    n = 12;
                    break;
                case 2:
                    n = 5;
                    break;
                case 3:
                    n = 1;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    n = 128;
                    break;
            }
        }
        System.out.println("====================================");
        int result = solution(n);
        System.out.print("result : " + result);

    }

    private int solution(int n) {

        int answer = 0;

        if(n == 0) return 0;
        if(n > 1) {
            answer++;
            for(int i = 2; i <= n/2 ; ++i) if(n % i == 0) answer += i;
        }
    
        return answer + n;
    }
    
}
