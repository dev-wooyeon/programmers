package level1;

import java.util.ArrayList;
import java.util.Scanner;

public class FailureRate {
    /// Fields

    /// Contructor
    public FailureRate() {
        super();

        problem();
    }

    /// Method
    public void problem(){

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. N:5 stages[2, 1, 2, 6, 2, 4, 3, 3]");
        System.out.println("2. N:4 stages[4, 4, 4, 4, 4]");
        System.out.print("테스트 케이스를 선택 : ");
        
        int n = 0;
        int[] stages = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try(Scanner scan = new Scanner(System.in)){
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    n = 5;
                    stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
                    break;
                case 2:
                    n = 4;
                    stages = new int[]{4, 4, 4, 4, 4};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    n = 5;
                    stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
                    break;
            }
        }
        
        int[] results = solution(n,stages);
        for(int result : results){
            System.out.println("result : " + result);
        }
    }

    public int[] solution(int n, int[] stages){

        int[] answer = {};
        
        int fail = 1;

        

        for (int j = 0; j <= n; j++) {

            ArrayList<Integer> list = new ArrayList<Integer>();
            System.out.println("==================");
            for(int i = 1 ; i <= stages.length-1 ; i ++){
                
                
                stages[i] = stages[i] - j;    
                System.out.println("["+i+"]"+"["+j+"]"+"["+stages[i]+"]");
                if (stages[i] == 0) {
                    fail++;
                    
                    list.remove(i-1);
                } 
                if (stages[i] >= 0 ){
                    list.add(stages[i-1]);
                }
            }
            
            System.out.println("["+j+"] Stage, failure Rate : " + fail + "/"+ list.size());
            
        }

        

        return answer;        
    }

}

