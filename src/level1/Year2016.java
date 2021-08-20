package level1;

import java.util.Scanner;

public class Year2016 {

    /// Fields

    /// Constructor
    public Year2016() {
        problem();
    }

    /// Method
    public void problem() {

        System.out.println("문제 설명");
        System.out.println(" 2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요? ");
        System.out.println(" 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution 을 완성하세요. ");
        System.out.println(" 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.");
        System.out.println(" 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 'TUE' 를 반환하세요.");

        System.out.println("제한 조건");
        System.out.println("2016년은 윤년입니다.");
        System.out.println("2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)");

        int month;
        int day;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    month = 5;
                    day = 24;
                    break;
                case 2:
                    month = 11;
                    day = 26;
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    month = 5;
                    day = 24;
                    break;
            }
        }

        String result = solution(month, day);
        System.out.print(" RESULT : " +result);
    }

    public String solution(int month, int day) {
        String answer = "";

        String[] weekend = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int[] lastDay = new int[]{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    
        int month_plus_day = 0;
        for (int i = 0; i < month-1 ; i++) {
            System.out.println("[DEBUG] lastDay["+i+"] : " + lastDay[i]);
            month_plus_day += lastDay[i];
        }
        System.out.println("[DEBUG] day-1 : " + (day-1));
        month_plus_day += day - 1;
        System.out.println("[DEBUG] month_plus_day : " + month_plus_day );
        System.out.println("[DEBUG] what is ? : " + month_plus_day % 7 + ", Days of week : " + weekend[month_plus_day%7]);
        answer = weekend[month_plus_day % 7];


        return answer;
    }
}

