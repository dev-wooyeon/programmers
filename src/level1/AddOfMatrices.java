package level1;

import java.util.Scanner;

public class AddOfMatrices {

    /// Fields

    /// Contructor
    public AddOfMatrices() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("이거 아직 안푼 문제다 은우야. 풀고 블로그 글 쓰자 ");

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.");
        System.out.println("  2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.");
        System.out.println("제한사항");
        System.out.println("  행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다. \n");
        System.out.println("테스트 케이스");
        System.out.println("  1. arr1[[1,2],[2,3]] arr2[[3,4],[5,6]] return[[4,6],[7,9]] ");
        System.out.println("  2. arr1[[1],[2]] arr2[[3],[4]] return[[4],[6]]");
        System.out.print("테스트 케이스를 선택 : ");

        int[][] arr1;
        int[][] arr2;
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1 :
                    arr1 = new int[][]{{1,2},{2,3}};
                    arr2 = new int[][]{{3,4},{5,6}};
                    break;
                case 2 :
                    arr1 = new int[][]{{1},{2}};
                    arr2 = new int[][]{{3},{4}};
                    break;
                default :
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    arr1 = new int[][]{{1,2},{2,3}};
                    arr2 = new int[][]{{3,4},{5,6}};
                    break;
            }
        }


        int[][] results = solution(arr1, arr2);

        System.out.print("result : [");
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                answer.append(results[i][j]).append(", ");
            }
        }

        if (!"".equals(answer.toString())) answer = new StringBuilder(answer.substring(0, answer.length() - 2));
        System.out.print(answer + "]");


    }

    private int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr1[0].length];

        System.out.println(" arr1.length : " + arr1[0].length);
        System.out.println(" arr2.length : " + arr2[0].length);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.println(" ================================== ");
                System.out.println(" arr1["+i+"]["+j+"] = " + arr1[i][j] );
                System.out.println(" arr2["+i+"]["+j+"] = " + arr2[i][j] );
                System.out.println(" ================================== ");
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return  answer;
    }
}
