package java.level1;

import java.util.Scanner;

public class Find_Decimal {

    /// Fields

    /// Contructor
    public Find_Decimal() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("이거 아직 안푼 문제다 은우야. 풀고 블로그 글 쓰자 ");

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.");
        System.out.println("  소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.");
        System.out.println("  (1은 소수가 아닙니다.)");
        System.out.println("");
        System.out.println("제한사항");
        System.out.println("  n은 2이상 1000000이하의 자연수입니다.");
        System.out.println("");
        System.out.println("테스트 케이스");
        System.out.println("  1. n : 10 ");
        System.out.println("  2. n : 5");
        System.out.print("테스트 케이스를 선택 : ");

        int n = 0;
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1:
                    n = 10;
                    break;
                case 2:
                    n = 5;
                    break;
                default:
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    n = 10;
                    break;
            }
        }


        int result = solution(n);
        System.out.println(result);

    }

    private int solution(int n) {

        // n <= 1 일 때 종료
        if(n <= 1) return 0;
        int answer = 0;

        Boolean[] primeAry = new Boolean[n+1];
        // 0번째와 1번째를 소수 아님으로 처리
        primeAry[0] = false;
        primeAry[1] = false;
        // 2~ n 까지 소수로 설정
        for(int i=2; i<=n; i++ ) primeAry[i] = true;
        // System.out.println(" step 001. primeAry = " + Arrays.asList(primeAry));

        // 2 부터  ~ i*i <= n
        // 각각의 배수들을 지워간다.

        for(int i=2; i<=Math.sqrt(n); i++){
            if(primeAry[i]){
                for(int j = i; i*j<=n; j++) primeAry[i*j] = false;
                //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
            }
        }

        // System.out.println(" step 002. primeAry = " + Arrays.asList(primeAry));

        for (boolean flag : primeAry) if(flag) answer++;

        return answer;
    }



}
