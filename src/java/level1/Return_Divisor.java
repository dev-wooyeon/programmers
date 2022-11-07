package java.level1;

import java.util.Scanner;

public class Return_Divisor {

    /// Fields

    /// Contructor
    public Return_Divisor() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("====================================");

        System.out.println("문제설명");
        System.out.println("  array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, ");
        System.out.println("  solution을 작성해주세요.");
        System.out.println("  divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.");
        System.out.println("제한 사항");
        System.out.println("  arr은 자연수를 담은 배열입니다.");
        System.out.println("  정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.");
        System.out.println("  divisor는 자연수입니다.");
        System.out.println("  array는 길이 1 이상인 배열입니다.");
        System.out.println("테스트 케이스");
        System.out.println("  1. arr[5, 9, 7, 10] divisor:5");
        System.out.println("  2. arr[2, 36, 1, 3] divisor:1");
        System.out.println("  2. arr[3, 2, 6] divisor:10");
        System.out.print("테스트 케이스를 선택 : ");

        int[] arr;
        int divisor = 0;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    arr = new int[]{5, 9, 7, 10};
                    divisor = 5;
                    break;
                case 2:
                    arr = new int[]{2, 36, 1, 3};
                    divisor = 1;
                    break;
                case 3:
                    arr = new int[]{3, 2, 6};
                    divisor = 10;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    arr = new int[]{5, 9, 7, 10};
                    break;
            }
        }
        System.out.println("====================================");
        int[] results = solution(arr, divisor);
        System.out.print("[");
        for (int result : results) {
            System.out.print(result + ", ");
        }
        System.out.print("]");
    }

    private int[] solution(int[] arr, int divisor) {

        int[] answer = {-1};

        int return_cnt = 0;
        for (int element : arr) {
            if (element % divisor == 0) {
                return_cnt++;
            }
        }

        if (return_cnt > 0) answer = new int[return_cnt];

        for (int element : arr) {
            if (element % divisor == 0) {
                answer[return_cnt - 1] = element;
                return_cnt--;
            }
        }

        // Arrays.sort(answer);
        selectionSort(answer);

        return answer;
    }

    private void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}