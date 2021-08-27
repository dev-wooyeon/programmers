package weeklyChallange;

import java.util.Scanner;

public class Week4 {

    /// Fields

    /// Constructor
    public Week4(){
        problem();
    }

    /// Method
    public void problem(){

        System.out.println(" 위클리 챌린지 4주차 상호 평가 [직업군 추천하기] ");

        // https://programmers.co.kr/learn/courses/30/lessons/84325
        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. result : HARDWARE ");
        System.out.println("2. result : PORTAL ");
        System.out.print("테스트 케이스를 선택 : ");


        String[] table = {};
        String[] language = {};
        int[] preference = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    table = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
                    language = new String[]{"PYTHON", "C++", "SQL"};
                    preference = new int[]{7, 5, 5};
                    break;
                case 2:
                    table = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
                    language = new String[]{"JAVA", "JAVASCRIPT"};
                    preference = new int[]{7, 5};
                    break;
                default:
                    // scores = new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
                    break;
            }
        }

        String result = solution(table, language, preference);
        System.out.println(" result = " + result);
    }

    private String solution(String[] table, String[] language, int[] preference) {

        System.out.println(" TEST ");
        return "";
    }
}
