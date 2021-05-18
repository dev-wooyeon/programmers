package level1;

import java.util.ArrayList;
import java.util.Scanner;

public class GymSuit {

    /// Fields

    /// Contructor
    public GymSuit() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.");
        System.out.println("  다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.");
        System.out.println("  학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. ");
        System.out.println("  예를 들어, ");
        System.out.println("  4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. ");
        System.out.println("  체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.");
        System.out.println("  전체 학생의 수 n,");
        System.out.println("  체육복을 도난당한 학생들의 번호가 담긴 배열 lost,");
        System.out.println("  여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,");
        System.out.println("  체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.");
        System.out.println("");
        System.out.println("제한사항");
        System.out.println("  전체 학생의 수는 2명 이상 30명 이하입니다.");
        System.out.println("  체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.");
        System.out.println("  여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.");
        System.out.println("  여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.");
        System.out.println("  여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. ");
        System.out.println("  이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, ");
        System.out.println("  남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.");
        System.out.println("");
        System.out.println("테스트 케이스");
        System.out.println("  1. n : 5, lost[2,4], reserve[1,3,5]");
        System.out.println("  2. n : 5, lost[2,4], reserve[3]");
        System.out.println("  3. n : 3, lost[3], reserve[1]");
        System.out.print("테스트 케이스를 선택 : ");

        int n = 0;
        int[] lost = {};
        int[] reserve = {};
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1:
                    n = 5;
                    lost = new int[]{2, 4};
                    reserve = new int[]{1, 3, 5};
                    break;
                case 2:
                    n = 5;
                    lost = new int[]{2, 4};
                    reserve = new int[]{3};
                    break;
                case 3:
                    n = 3;
                    lost = new int[]{3};
                    reserve = new int[]{1};
                    break;
                default:
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    n = 5;
                    lost = new int[]{2, 4};
                    reserve = new int[]{1, 3, 5};
                    break;
            }
        }


        int result = solution(n, lost, reserve);
        // System.out.println(result);

    }

    private int solution(int n, int[] lost, int[] reserve) {

        int answer = n;

        // 배열의 n번째와 학생의 번호n을 매치되도록 생성하기 위해 n+1 사이즈로 생성
        int[] students = new int[n + 1];

        for (int i = 1; i < students.length; ++i) {
            students[i] = i;
        }

        for (int i = 0; i < lost.length; i++) {
            System.out.println(" students[lost[i]] : " + students[lost[i]] + ", lost[i] : " + lost[i]);
            if (students[lost[i]] == lost[i]) n--;
        }

        for (int i = 0; i < reserve.length; i++) {

        }
        System.out.println(" 잃어버린 학생을 제외한 학생 수 : " + n);


        // 잃어버린 학생들 만큼 빼기
        answer -= lost.length;

        // 체육복 빌려줌 처리
        answer += reserve.length;

        "".repeat(2);

        return answer;
    }

}
