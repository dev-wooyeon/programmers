package level1;

import java.util.Scanner;

public class MinMax {

    /// Fields

    /// Contructor
    public MinMax() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("이거 아직 안푼 문제다 은우야. 풀고 블로그 글 쓰자 ");

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.");
        System.out.println("  배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.");
        System.out.println("  예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다. \n");
        System.out.println("제한사항");
        System.out.println("  두 수는 1이상 1000000이하의 자연수입니다. \n");
        System.out.println("테스트 케이스");
        System.out.println("  1. n:3 m:12 return:[3, 12] ");
        System.out.println("  2. n:2 m:5 return:[1, 10]");
        System.out.print("테스트 케이스를 선택 : ");

        int n;
        int m;
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1 :
                    n = 3;
                    m = 12;
                    break;
                case 2 :
                    n = 2;
                    m = 5;
                    break;
                default :
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    n = 3;
                    m = 12;
                    break;
            }
        }


        int[] results = solution(n, m);

        System.out.print("result : [");
        StringBuilder answer = new StringBuilder();
        for (int result : results) {
            answer.append(result).append(", ");
        }

        if (!"".equals(answer.toString())) answer = new StringBuilder(answer.substring(0, answer.length() - 2));
        System.out.print(answer + "]");


    }

    private int[] solution(int n, int m) {

        // 최대 공약수, 최소 공배수
        int[] answer = new int[2];

        if (m % n == 0) {
            answer[0] = n;
            answer[1] = m;
            return answer;
        }

        // M의 크기 까지 도는 for
        for (int i = 1; i <= m; i++) {
            // N을 i로 나누어도 0 이고, M을 i로 나누어도 0인 조건인 경우가 최소 공약수.
            if (n % i == 0 & m % i == 0) {
                // System.out.println(" 최소 공약수 : " + i);
                answer[0] = i;
            }
        }
        // System.out.println(" 최소 공배수 : " + (n * m));
        answer[1] = n * m / answer[0];


        return answer;
    }
}