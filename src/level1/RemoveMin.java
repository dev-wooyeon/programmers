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

        int[] answer = {};

        // 배열의 길이가 1인 경우 -1 리턴
        if (arr.length == 1) return new int[]{-1};

        // 배열의 처음 데이터를 숫자형 변수 min 에 대입
        int min = arr[0];
        // 배열의 길아 2번째 부터 길이만큼 도는 for
        for (int i = 1; i < arr.length; i++) {
            // System.out.println("[DEBUG] min = " + min + " arr["+i+"] = " + arr[i]);
            // min값과, 배열의 값중 작은 수를 리턴
            min = (min <= arr[i]) ? min : arr[i];
        }
        // System.out.println("[DEBUG] 가장 작은 수 : " + min);
        // 배열 -1 길이만큼 답안지 길이 초기화
        answer = new int[arr.length-1];

        // 제일 작은 수를 빼고 담기 때문에 index 가 어디에서 차이날지 모름.
        // 하여 답안지의 배열 처리할 idx 변수 선언
        int idx = 0;
        // 배열의 길이만큼 도는 for
        for (int i=0; i < arr.length ; i++) {
            // 제일 작은수와 배열의 값이 같으면 답안지에 세팅되지 않도록 continue 처리
            if(arr[i] == min) continue;
            // 답안지 세팅
            answer[idx++] = arr[i];
        }


        return answer;
    }
}