package level1;

import java.util.Scanner;

public class AlignMyMind {

    /// Fields

    /// Contructor
    public AlignMyMind() {
        super();
        problem();
    }

    /// Method

    public static void main(String[] args) throws Exception {
        new Budget();
    }

    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. strings[sun,bed,car] n:1 ");
        System.out.println("2. strings[abce,abcd,cdx] n:2");
        System.out.print("테스트 케이스를 선택 : ");

        String[] strings = {};
        int n = 0;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    strings = new String[]{"sun","bed","car"};
                    n = 1;
                    break;
                case 2:
                    strings = new String[]{"abce","abcd","cdx"};
                    n = 2;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    strings = new String[]{"sun","bed","car"};
                    n = 1;
                    break;
            }
        }

        String[] results = solution(strings, n);

        System.out.print("result : [");
        for (String result: results){
            System.out.print(result+", ");
        }
        System.out.print("]");
    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        int max;
        for (int i = 0; i < strings.length-1; ++i) {
            max = strings[i].charAt(n);
            System.out.println("max : " + max);
            if(max < strings[i+1].charAt(n)) max = 0;
        }

        return answer;
    }
}
