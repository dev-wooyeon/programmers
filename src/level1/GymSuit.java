package level1;

import java.util.ArrayList;
import java.util.Arrays;
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

        int n;
        int[] lost;
        int[] reserve;
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


        int result = solution2(n, lost, reserve);
        System.out.println(result);

    }

    private int solution2(int n, int[] lost, int[] reserve) {

        // 전체 학생 수 - 도난당한 학생 수 = 초기 answer
        // 5 - 2 = 3;
        int answer = n - lost.length;

        // 도난 당한 학생수 만큼 도는 outer for
        for (int i = 0; i < lost.length; i++) {
            // 빌려 줄 수 있는 학생 수 만큼 도는 inner for
            for (int j = 0; j < reserve.length; j++) {
                // 잃어버린 학생의 번호와 빌려 줄 수 있는 학생의 번호가 같다면
                if (lost[i] == reserve[j]) {
                    // 답안지 건수 +1
                    answer++;
                    // 빌려줄수 있는 학생의 번호에 -1 대입
                    reserve[j] = 0;
                    // 도난당한 학생의 번호를 -1 대입
                    lost[i] = 0;
                    // inner for break 후 outer for 진행 한다.
                    break;
                } // end of if
            } // end of inner for
        } // end of outer for

        // 도난당한 학생수 만큼 도는 outer for
        for (int i = 0; i < lost.length; i++) {
            // 잃어버린 학생의 번호와 빌려 줄 수 있는 학생의 번호가 같은 경우 처리 하지 않도록 -1값에 대하여 continue 처리
            if (lost[i] == 0) continue;
            // 빌려 줄 수 있는 학생 수만큼 도는 inner for
            for (int j = 0; j < reserve.length; j++) {
                // 잃어버린 학생의 번호와 빌려 줄 수 있는 학생의 번호가 같은 경우 처리 하지 않도록 -1값에 대하여 continue 처리
                if (reserve[j] == 0) continue;

                // 만약, 잃어버린 학생의 번호와 빌려줄수 있는 학생의 번호가 앞뒤 +-1 이면
                if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    // 답안지 건수 +1
                    answer++;
                    // 빌려줄 수 있는 학생의 번호에 -1 대입
                    reserve[j] = 0;
                    // inner for break 후 outer for 진행 한다.
                    break;
                } // end of if
            } // end of inner for
        } // end of outer for

        return answer;
    }

    private int solution(int n, int[] lost, int[] reserve) {

        int answer = 0;

        // 전체 학생의 수만큼 학생 배열 생성
        int[] students = new int[n + 1];

        // 모든 학생들이 체육복 1개를 가지고 왔다고 가정하여 개수 세팅
        for (int i = 0; i < n; ++i) {
            students[i] = 1;
        }
        // 체육복 초기세팅
        System.out.println("init suit cnt = " + Arrays.toString(students));

        // 도난 당한 학생의 체육복 개수 -1
        for (int i = 0; i < lost.length; ++i) students[lost[i] - 1]--;
        // 체육복 도난 처리
        System.out.println("lost suit cnt = " + Arrays.toString(students));

        // 여분이 있는 학생의 체육복 개수 +1
        for (int i = 0; i < reserve.length; ++i) students[reserve[i] - 1]++;
        // 여분 처리
        System.out.println("reserve suit cnt = " + Arrays.toString(students));

        // 학생수 만큼 도는 for
        for (int i = 0; i < n; ++i) {

            // i보다 앞번호 처리( 0번보다 앞은 없기때문에 예외 처리 )
            if (students[i] == 2 && i > 0 && students[i - 1] == 0) {
                students[i]--; // 여분 체육복 빌려줌 처리
                students[i - 1]++;  // 체육복 받음 처리
            }

            // i보다 뒷번호 처리( n번보다 앞은 없기때문에 예외 처리 )
            if (students[i] == 2 && students[i + 1] == 0) {
                students[i]--; // 여분 체육복 빌려줌 처리
                students[i + 1]++;  // 체육복 받음 처리
            }
        } // end of outer for
        System.out.println("after suit cnt = " + Arrays.toString(students));

        for (int i = 0; i < n; ++i) if (students[i] > 0) answer++;


        return answer;
    }

}
