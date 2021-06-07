package level1;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveMin {

    /// Fields

    /// Contructor
    public RemoveMin() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("====================================");

        System.out.println("문제설명");
        System.out.println(" 정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. ");
        System.out.println(" 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.  ");
        System.out.println(" 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다. ");
        System.out.println("제한 사항");
        System.out.println("  arr은 길이 1 이상인 배열입니다.");
        System.out.println("  인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.");
        System.out.println("테스트 케이스");
        System.out.println("  1. arr[4,3,2,1] return[4,3,2]");
        System.out.println("  2. arr[10] return[-1]");
        System.out.print("테스트 케이스를 선택 : ");

        int[] arr;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    arr = new int[]{4,3,2,1};
                    break;
                case 2:
                    arr = new int[]{10};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    arr = new int[]{4,3,2,1};
                    break;
            }
        }
        System.out.println("====================================");
        int[] results = solution(arr);

        StringBuffer sb = new StringBuffer();

        sb.append("result : [");
        for (int result: results) {
            sb.append(result + ",");
        }

        sb = new StringBuffer().append(sb.toString().substring(0,sb.length() -1) + "]");
        System.out.print(sb);

    }

    public int[] solution(int[] arr){

        int len = arr.length;
        if(len > 1 ) len -= 1;
        int[] answer = new int[len];

        Arrays.sort(arr);

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length ; j++) {

            }
        }


        return answer;
    }
}