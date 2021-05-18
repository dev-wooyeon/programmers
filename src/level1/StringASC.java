package level1;

import java.util.Scanner;

public class StringASC {

    // Fields

    /// Contructor
    public StringASC() {
        super();

        problem();
    }

    /// Method

    public static void main(String[] args) throws Exception {
        new StringASC();
    }

    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. strings['sun', 'bed', 'car'] n:1");
        System.out.println("2. strings['abce', 'abcd', 'cdx'] n:2");
        System.out.print("테스트 케이스를 선택 : ");

        String[] s;
        int n;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    s = new String[]{"sun", "bed", "car"};
                    n = 1;
                    break;
                case 2:
                    s = new String[]{"abce", "abcd", "cdx"};
                    n = 2;
                    break;
                default:
                    s = new String[]{"sun", "bed", "car"};
                    n = 1;
                    break;
            }
        }

        String[] result = solution(s, n);
        for (String str : result) {
            System.out.println("str : " + str);
        }

    }

    public String[] solution(String[] s, int n) {

        String[] answer = new String[s.length];

        for (int i = 0; i < s.length - 1; i++) {

            // answer[i] =
            // if (s[i].charAt(n - 1) < s[i + 1].charAt(n - 1)) {
            // answer[i] = s[i];
            // }

        }
        return answer;
    }

}