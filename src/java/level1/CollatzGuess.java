package java.level1;

import java.util.Scanner;

public class CollatzGuess {

    /// Fields

    /// Contructor
    public CollatzGuess() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("====================================");

        System.out.println("문제설명");
        System.out.println(" 1937년 Collatz란 사람에 의해 제기된 이 추측은, 주어진 수가 1이 될때까지 다음 작업을 반복하면, 모든 수를 1로 만들 수 있다는 추측입니다. 작업은 다음과 같습니다. ");
        System.out.println(" 1-1. 입력된 수가 짝수라면 2로 나눕니다. ");
        System.out.println(" 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. ");
        System.out.println(" 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다. ");
        System.out.println(" 입력된 수가 6이라면 6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1 이 되어 총 8번 만에 1이 됩니다. ");
        System.out.println(" 단, 작업을 500번을 반복해도 1이 되지 않는다면 –1을 반환 ");
        System.out.println("제한 사항");
        System.out.println("  입력된 수, num은 1 이상 8000000 미만인 정수입니다.");
        System.out.println("테스트 케이스");
        System.out.println("  1. n = 6, result = 8");
        System.out.println("  2. n = 16, result = 4");
        System.out.println("  3. n = 626331 result = -1");
        System.out.print("테스트 케이스를 선택 : ");

        int num;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    num = 6;
                    break;
                case 2:
                    num = 16;
                    break;
                case 3:
                    num = 626331;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    num = 6;
                    break;
            }
        }
        System.out.println("====================================");
        int result = solution(num);
        System.out.print(" result : " + result);

    }

    public int solution(int num){

        int answer = 0;
        long long_num = num;
        for (int i = 0; i <= 500; i++) {
            if(long_num == 1) return i;
            if(i==500) return -1;
            long_num = collatz(long_num);
        }

        // System.out.println("answer = " + answer);

        return answer;
    }

    private long collatz(long long_num) {
        return long_num % 2 == 0 ? long_num/2 : (long_num*3)+1;
    }
}