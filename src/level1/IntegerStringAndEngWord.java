package level1;

import java.util.Scanner;

public class IntegerStringAndEngWord {

    /// Fields

    /// Constructor
    public IntegerStringAndEngWord() {
        problem();
    }

    /// Method
    public void problem() {
        System.out.println("2021 카카오 채용연계형 인턴십 [숫자 문자열과 영단어]");
        System.out.println("테스트 케이스");
        System.out.println(" 1. one4seveneight -> 1478");
        System.out.println(" 2. 23four5six7 -> 234567");
        System.out.println(" 3. 2three45sixseven -> 234567");
        System.out.println(" 4. 123 -> 123");
        System.out.print("테스트 케이스를 선택 : ");

        String s = "";
        try (Scanner scan = new Scanner(System.in)) {

            int key = scan.nextInt();

            switch (key) {
                case 1 :
                    s = "one4seveneight";
                    break;
                case 2 :
                    s = "23four5six7";
                    break;
                case 3 :
                    s = "2three45sixseven";
                    break;
                case 4 :
                    s = "123";
                    break;
                default :
                    System.out.println("입력하신 테스트 케이스가 존재 하지 않아 [1번] 으로 처리됩니다.");
                    s = "one4seveneight";
                    break;
            }
        }


        int answer = solution(s);

        System.out.println("answer : " + answer);

    }

    private int solution(String s) {

        int answer = 0;

        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");

        System.out.println(s);

        answer = Integer.parseInt(s);

        return answer;
    }
}
