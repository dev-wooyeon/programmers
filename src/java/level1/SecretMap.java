package java.level1;

import java.util.Scanner;

public class SecretMap {

    /// Fields

    /// Contructor
    public SecretMap() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("===============================================================================");
        System.out.println("1. n:5 arr1[9, 20, 28, 18, 11] arr2[30, 1, 21, 17, 28]                         ");
        System.out.println("2. n:6 arr1[46, 33, 33 ,22, 31, 50] arr2[27 ,56, 19, 14, 14, 10]               ");
        System.out.print("테스트 케이스를 선택 : ");

        int n = 0;
        int[] arr1 = {};
        int[] arr2 = {};
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1:
                    n = 5;
                    arr1 = new int[]{9, 20, 28, 18, 11};
                    arr2 = new int[]{30, 1, 21, 17, 28};
                    break;
                case 2:
                    n = 6;
                    arr1 = new int[]{46, 33, 33, 22, 31, 50};
                    arr2 = new int[]{27, 56, 19, 14, 14, 10};
                    break;
                default:
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    n = 5;
                    arr1 = new int[]{9, 20, 28, 18, 11};
                    arr2 = new int[]{30, 1, 21, 17, 28};
                    break;
            }
        }


        String[] results = solution(n, arr1, arr2);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private String[] solution(int n, int[] arr1, int[] arr2) {

        // 한변의 길이 n 만큼 답안지의 길이 초기화
        String[] answer = new String[n];

        // 한변의 길이 n 만큼 도는 for문
        for (int i = 0; i < n; ++i) {

            // 문자 처리할 StringBuffer 객체 생성
            StringBuffer sb = new StringBuffer();
            // 각 arr1,arr2의 i번째의 숫자 데이터를 Binary |(or) 연산을 하여 answer의 i번째에 대입한다.
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);

            // 만약에 한변의 길이가 6인데, Binary의 길이가 5인 경우도 있음으로 공백처리 

            for (int k = 0; k < n - answer[i].length(); ++k) {
                sb.append(" ");
            }

            // answer[i]의 길이만큼 돌며 답안지에 세팅할 1-> #, 0-> " " 세팅을 위한 for
            for (int j = 0; j < answer[i].length(); ++j) {
                if ('1' == answer[i].charAt(j)) sb.append("#");
                else                            sb.append(" ");
            }

            // 답안지에 처리 완료한 sb 데이터를 대입한다.
            answer[i] = sb.toString();
        }

        // 처리 완료 후 전달되는 답안지
        return answer;
    }

}
