package level1;

import java.util.Scanner;

public class WhereK {
    
       /// Fields

    /// Contructor
    public WhereK() {
        super();

        problem();
    }

    /// Method
    public void problem(){

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. array[1,5,2,6,3,7,4] commands[[2,5,3], [4,4,1], [1,7,3]]");
        System.out.print("테스트 케이스를 선택 : ");
        
        int[] array = {};
        int[][] commands = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try(Scanner scan = new Scanner(System.in)){
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    array = new int[]{1,5,2,6,3,7,4};
                    commands = new int[][]{{2,5,3}, {4,4,1}, {1,7,3}};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    array = new int[]{1,5,2,6,3,7,4};
                    commands = new int[][]{{2,5,3}, {4,4,1}, {1,7,3}};
                    break;
            }
        }
        
        int[] results = solution(array,commands);
        for(int result : results){
            System.out.println("result : " + result);
        }
    }

    public int[] solution(int[] array, int[][] commands){

        int[] answer = {};

        int start;
        int end;
        int k;
        for (int i = 0; i < commands.length; i++) {
            start = array[commands[0][0]];
            end = array[commands[0][1]];
            k = array[commands[0][2]];
        }

        return answer;        
    }

}
