package level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
            System.out.print(result + ", ");
        }
    }

    public int[] solution(int n, int[] stages){

        int[] answer = new int[n];
        
        HashMap<Integer,Double> hsm = new HashMap<Integer,Double>();
        // 스테이지에 머물러 있는 인원 수 체크

        // 실패한유저 체크

        // 스테이지 N개 만큼 도는 for문
        for (int i = 1; i < n+1; i++) {

            int fail = 0;
            int succ = 0;

            System.out.println("==================");
            // 스테이지에 
            for(int j = 0 ; j < stages.length ; j ++){
                
                
                if ( ( stages[j] - i ) > 0) {
                    System.out.println("[SUCC] ["+j+"]"+"["+i+"]"+"["+stages[j]+"]");
                    succ++;
                }

                if ( ( stages[j] - i ) == 0) {
                    System.out.println("[FAIL] ["+j+"]"+"["+i+"]"+"["+stages[j]+"]");
                    fail++;
                } 

            }

            System.out.println("stages users cnt : " + (succ+fail) + ", fail cnt : " + fail);
            hsm.put(i, (double)fail / (double)(succ+fail) * 100);

        }

        System.out.println(hsm.toString());

        // 맵에서 랭크 처리하자.
        double max = hsm.get(1);

        for (int key = 2 ; key <= hsm.keySet().size() ; key++) {            
            if( max < hsm.get(key)) max = hsm.get(key);
        }

        System.out.println( max );

        return answer;        
    }

}

