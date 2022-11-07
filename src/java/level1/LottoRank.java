package java.level1;

import java.util.Scanner;

public class LottoRank {

    /// Fields

    /// Contructor
    public LottoRank() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("====================================");

        System.out.println("문제설명");
        System.out.println("  로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. ");
        System.out.println("  아래는 로또의 순위를 정하는 방식입니다.");
        System.out.println(" 1	6개 번호가 모두 일치 ");
        System.out.println(" 2	5개 번호가 일치 ");
        System.out.println(" 3	4개 번호가 일치 ");
        System.out.println(" 4	3개 번호가 일치 ");
        System.out.println(" 5	2개 번호가 일치 ");
        System.out.println(" 6(낙첨)	그 외 ");
        System.out.println("제한 사항");
        System.out.println("  lottos는 길이 6인 정수 배열입니다.");
        System.out.println("  lottos의 모든 원소는 0 이상 45 이하인 정수입니다.");
        System.out.println("  win_nums은 길이 6인 정수 배열입니다.");
        System.out.println("  win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.");
        System.out.println("테스트 케이스");
        System.out.println("  1. lottos[44, 1, 0, 0, 31, 25]   win_nums[31, 10, 45, 1, 6, 19]       result[3,5]");
        System.out.println("  2. lottos[0, 0, 0, 0, 0, 0]      win_nums[38, 19, 20, 40, 15, 25]     result[1, 6]");
        System.out.println("  3. lottos[45, 4, 35, 20, 3, 9]   win_nums[20, 9, 3, 45, 4, 35]        result[1, 1]");
        System.out.print("테스트 케이스를 선택 : ");

        int[] lottos = {};
        int[] win_nums = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    lottos = new int[]{44, 1, 0, 0, 31, 25};
                    win_nums = new int[]{31, 10, 45, 1, 6, 19};
                    break;
                case 2:
                    lottos = new int[]{0, 0, 0, 0, 0, 0};
                    win_nums = new int[]{38, 19, 20, 40, 15, 25};
                    break;
                case 3:
                    lottos = new int[]{45, 4, 35, 20, 3, 9};
                    win_nums = new int[]{20, 9, 3, 45, 4, 35};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    lottos = new int[]{44, 1, 0, 0, 31, 25};
                    win_nums = new int[]{31, 10, 45, 1, 6, 19};
                    break;
            }
        }
        System.out.println("====================================");
        int[] results = solution(lottos, win_nums);

        StringBuilder sb = new StringBuilder();
        sb.append("result [");
        for (int result: results) {
            sb.append(result + ",");
        }
        sb.append("]");
        System.out.print(sb.toString());

    }

    public int[] solution(int[] lottos, int[] win_nums){

        // 최고, 최저 세팅할 2의 배열길이로 선언
        int[] answer = new int[2];

        // 일치개수와 0의 개수 측정
        int match_cnt = 0;
        int zero_cnt = 0;

        // lottos 의 길이만큼 도는 outer for
        for (int i = 0; i < lottos.length; i++) {
            // 0인 개수 측정
            if(lottos[i] == 0) zero_cnt++;
            // win_nums 의 길이만큼 도는 inner for
            for (int j = 0; j < win_nums.length; j++) {
                // 일치하는 번호가 있는경우 일치개수 ++
                if(win_nums[j] == lottos[i]){
                    match_cnt++;
                    break;
                }
            }
        }

        // System.out.println("[DEBUG] zero cnt : " + zero_cnt + ", match_cnt : " + match_cnt);
        // 최고 순위 세팅
        answer[0] = Math.min(7-(zero_cnt+match_cnt),6);
        // 최저 순위 세팅
        answer[1] = Math.min(7-match_cnt,6);

        return answer;
    }
}


