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

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. arr[1,2,3,4]");
        System.out.println("2. arr[5,5]");
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
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    n = 12;
                    break;
            }
        }
        
        int result = solution(n);
        System.out.print(" result : " + result);

    }

    private int solution(int n) {

        int answer = 0;

        for(int i = 1 ; i <= n ; ++i){
            if(n % i == 0){
                answer += i;
            }
        }

        return answer;
    }
    
}
