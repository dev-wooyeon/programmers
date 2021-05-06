package level1;

import java.util.Scanner;

public class MakeDecimal {
    
    /// Fields

    /// Contructor
    public MakeDecimal() {
        super();

        problem();
    }

    public void problem(){

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. [1,2,3,4] ");
        System.out.println("2. [1,2,7,6,4] ");
        System.out.println("2. [1,2,8,9,5] ");
        System.out.print("테스트 케이스를 선택 : ");
        
        int[] nums = {};

        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try(Scanner scan = new Scanner(System.in)){
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    nums = new int[]{1,2,3,4};
                    break;
                case 2:
                    nums = new int[]{1,2,7,6,4};
                    break;
                case 3:
                    nums = new int[]{1,2,8,9,5};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    nums = new int[]{1,2,3,4};
                    break;
            }
        }
        
        // int result = solution(nums);
        int result = solution2(nums);
        System.out.println(" result : " + result);
    }

    public int solution(int[] nums){

        int answer = 0;

        int numsLen = nums.length;
        for(int i = 0 ; i < numsLen-2 ; i ++){
            for(int j = i+1 ; j < numsLen-1 ; j ++){
                for(int k = j+1 ; k < numsLen ; k ++){
                    
                    // 배열 디버깅
                    // System.out.println("["+i+"]" + nums[i] + " ["+j+"]" + nums[j] + " ["+k+"]" + nums[k]);
                    int sum = nums[i] + nums[j] + nums[k];
                    if( (sum % sum == 0) & (sum % 2 != 0) & (sum % 3 != 0) ){
                        // 소수확인
                        // System.out.println("SUM : " + sum);
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer;        
    }

    public int solution2(int[] nums){

        int answer = 0;

        int numsLen = nums.length;
        for(int i = 0 ; i < numsLen-2 ; i ++){
            for(int j = i+1 ; j < numsLen-1 ; j ++){
                for(int k = j+1 ; k < numsLen ; k ++){
                    // 배열 디버깅
                    // System.out.println("["+i+"]" + nums[i] + " ["+j+"]" + nums[j] + " ["+k+"]" + nums[k]);
                    int sum = nums[i] + nums[j] + nums[k];
                    if (isPrime(sum) ) answer++;
                }
            }
        }
        return answer;        
    }

    public boolean isPrime(int sum) {

        // 소수확인
        // System.out.println("SUM : " + sum);

        for (int i = 2; i*i <= sum; i++) {
            if (sum % i == 0) return false;
        }
        return true;
    }

    

    
}
