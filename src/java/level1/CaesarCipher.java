package java.level1;

import java.util.Scanner;

public class CaesarCipher {

    /// Fields

    /// Contructor
    public CaesarCipher() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("블로그 글 쓰자 ");

        System.out.println("=============================================================================== ");
        System.out.println("문제 설명");
        System.out.println("  어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.");
        System.out.println("  예를 들어 \"AB\"는 1만큼 밀면 \"BC\"가 되고, 3만큼 밀면 \"DE\"가 됩니다. ");
        System.out.println("  \"z\"는 1만큼 밀면 \"a\"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요. ");
        System.out.println("제한사항");
        System.out.println(" 공백은 아무리 밀어도 공백입니다. \n");
        System.out.println(" s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다. \n");
        System.out.println(" s의 길이는 8000이하입니다. \n");
        System.out.println(" n은 1 이상, 25이하인 자연수입니다. \n");
        System.out.println("테스트 케이스");
        System.out.println("  1. s=\"AB\" n=1 result=\"BC\" ");
        System.out.println("  2. s=\"z\" n=1 result=\"a\" ");
        System.out.println("  3. s=\"a B z\" n=4 result=\"e F d\" ");
        System.out.print("테스트 케이스를 선택 : ");

        String s;
        int n;
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1:
                    s = "AB";
                    n = 1;
                    break;
                case 2:
                    s = "z";
                    n = 1;
                    break;
                case 3:
                    s="a B z";
                    n= 4;
                    break;
                default:
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    s = "AB";
                    n = 1;
                    break;
            }
        }


        String result = solution(s, n);

        System.out.print("\n result = " + result);
        StringBuilder answer = new StringBuilder();
    }

    private String solution(String s, int n) {

        StringBuilder answer = new StringBuilder();

        // 대소문자 구분을 위한 start 선언 (A or a)
        char start;
        // 문자열의 길이만큼 도는 for
        for (int i = 0; i < s.length(); i++) {
            // 문자열의 한글자 씩 읽는다.
            char org = s.charAt(i);
            // 만약 공백일 경우 답안지에 공백 세팅 후 다음 처리 진행
            if ( 32 == org ) { answer.append(" "); continue; }
            // 대소문자 구분하여 start에 세팅
            start = Character.isUpperCase(org)?'A':'a';
            // ORG = z(122), n = 4, start = a(97), (122+4-97)%26 = 3 + 07 = d(100)
            org = (char) ( start + ( org + n - start ) % 26 );
            // 답안지 세팅
            answer.append(org);
        }


        return answer.toString();
    }
}

