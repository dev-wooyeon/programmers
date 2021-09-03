package level1;

import java.util.Scanner;

public class CheckSquared {
    /// Fields

    /// Constructor
    public CheckSquared() {
        problem();
    }

    /// Method
    public void problem() {



        System.out.println("문제 설명");
        System.out.println(" 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.");
        System.out.println(" n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,  ");
        System.out.println(" n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.");
        System.out.println("제한 조건");
        System.out.println(" n은 1이상, 50000000000000 이하인 양의 정수입니다.");

        long n;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    n = 121;
                    break;
                case 2:
                    n = 3;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    n = 121;
                    break;
            }
        }

        long result = solution(n);
        System.out.print(" RESULT : " +result);
    }

    public long solution(long n) {
        long answer = 0;

        boolean have_sqaured = false;
        for(int i = 0; (long)i*i <= n ; i++){
            if((long)i*i == n){
                have_sqaured = true;
                long temp = i+1;
                answer = temp * temp;
            }
        }

        if(!have_sqaured) answer = -1;


        return answer;
    }
}
