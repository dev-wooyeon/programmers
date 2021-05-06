package level1;

import java.util.Scanner;

public class Budget {
    
    /// Fields

    /// Contructor
    public Budget() {
        super();

        problem();
    }

    /// Method
    public void problem(){

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. d[1,3,2,5,4] budget:9");
        System.out.println("2. d[2,2,3,3] budget:10");
        System.out.print("테스트 케이스를 선택 : ");
        
        int[] d = {};
        int budget = 0;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try(Scanner scan = new Scanner(System.in)){
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    d = new int[]{1,3,2,5,4};
                    budget = 9;
                    break;
                case 2:
                    d = new int[]{2,2,3,3};
                    budget = 10;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    d = new int[]{1,3,2,5,4};
                    budget = 9;
                    break;
            }
        }
        
        int result = solution(d,budget);
        System.out.println("result : " + result);
    }

    public int solution(int[] d, int budget){

        int answer = 0;

        for (int i = 0; i < d.length; i++) {
            System.out.println(budget + " : " + d[i]);

            if(budget - d[i] > 0){
                budget -= d[i];
                answer++;
            }
        }

        return answer;        
    }

}
