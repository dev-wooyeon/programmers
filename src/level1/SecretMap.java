package level1;

import java.util.Scanner;

public class SecretMap {
    
     /// Fields

    /// Contructor
    public SecretMap() {
        super();

        problem();
    }

    /// Method
    public void problem(){

        System.out.println("=============================================================================== ");
        System.out.println("1. n:5 arr1[9, 20, 28, 18, 11] arr2[30, 1, 21, 17, 28]                          ");
        System.out.println("2. n:6 arr1[46, 33, 33 ,22, 31, 50] arr2[27 ,56, 19, 14, 14, 10]                ");
        System.out.print("테스트 케이스를 선택 : ");

        int n = 0;
        int[] arr1 = {};
        int[] arr2 = {};
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1  :
                    n = 5;
                    arr1 = new int[]{9, 20, 28, 18, 11};
                    arr2 = new int[]{30, 1, 21, 17, 28};
                    break;
                case 2  :
                    n = 6;
                    arr1 = new int[]{46, 33, 33 ,22, 31, 50};
                    arr2 = new int[]{27 ,56, 19, 14, 14, 10};
                    break;
                default:
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    n = 5;
                    arr1 = new int[]{9, 20, 28, 18, 11};
                    arr2 = new int[]{30, 1, 21, 17, 28};
                    break;
            }
        }


        solution(n, arr1, arr2);
    }

    private String[] solution(int n, int[] arr1, int[] arr2) {

        String[] answer = {};


        System.out.println(" arr1[0] | arr2[0]" + Integer.toBinaryString(arr1[0] | arr2[0]));

        return answer;
    }

}
