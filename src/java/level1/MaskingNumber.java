package java.level1;

import java.util.Scanner;

public class MaskingNumber {

    /// Fields

    /// Contructor
    public MaskingNumber() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. 01033334444");
        System.out.println("2. 027778888");
        System.out.print("테스트 케이스를 선택 : ");

        String phone_number = "";
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    phone_number = "01033334444";
                    break;
                case 2:
                    phone_number = "027778888";
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    phone_number = "01033334444";
                    break;
            }
        }

        String result = solution(phone_number);
        System.out.println("result : " + result);
    }

    public String solution(String phone_number) {

        String answer = "";

        // 번호의 길이를 받아온다.
        int numLen = phone_number.length();

        // 제한 조건
        if (numLen >= 4 & numLen <= 20) {

            // 뒷자리 4자리 제외하고 * 표시를 길이에 맞게 처리하는 for
            for (int i = 0; i < numLen - 4; i++) {
                answer += "*";
            }
            // 답안지에 번호 뒷 4자리를 추가 세팅한다.
            answer += phone_number.substring(numLen - 4, numLen);
        }


        return answer;
    }

}
