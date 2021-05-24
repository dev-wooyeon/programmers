package level1;

import java.util.Scanner;

public class DotGame {

    /// Fields

    /// Contructor
    public DotGame() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("1차 다트 게임. ");
        System.out.println("[1S2D*3T, 1D2S#10S, 1D2S0T, 1S*2T*3S, 1D#2S*3S, 1T2D3D#, 1D2S3T*]");

        System.out.println("====================================");
        String[] testCases = new String[]{"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
        int[] answerList = new int[testCases.length];
        for (int i = 0; i < testCases.length; i++) {
            answerList[i] = solution(testCases[i]);
        }

        System.out.println("테스트 케이스 실행 결과");
        for (int i = 0; i < answerList.length; i++) {
            System.out.println("[" + (i + 1) + "] " + answerList[i]);
        }

    }

    public int solution(String dartResult) {

        int answer = 0;

        dartResult = dartResult.replaceAll("10","J");
        StringBuilder display = new StringBuilder();
        int[] tempJumsuList = new int[3];
        for (int i = 0; i < dartResult.length(); i++) {
            int jumsu = 0;
            int idx = 0;
            switch (dartResult.charAt(i)) {
                case 'S':
                    if(dartResult.charAt(i - 1) == 'J') jumsu = 10;
                    else jumsu = Character.getNumericValue(dartResult.charAt(i - 1));
                    answer += Math.pow(jumsu, 1);
                    // System.out.println("+" + jumsu + "^1");
                    display.append("+" + jumsu + "^1");
                    tempJumsuList[idx] = jumsu;
                    idx++;
                    break;
                case 'D':
                    if(dartResult.charAt(i - 1) == 'J') jumsu = 10;
                    else jumsu = Character.getNumericValue(dartResult.charAt(i - 1));
                    answer += Math.pow(jumsu, 2);
                    // System.out.println("+" + jumsu + "^2");
                    display.append("+" + jumsu + "^2");
                    tempJumsuList[idx] = jumsu;
                    idx++;
                    break;
                case 'T':
                    if(dartResult.charAt(i - 1) == 'J') jumsu = 10;
                    else jumsu = Character.getNumericValue(dartResult.charAt(i - 1));
                    answer += Math.pow(jumsu, 3);
                    // System.out.println("+" + jumsu + "^3");
                    display.append("+" + jumsu + "^3");
                    tempJumsuList[idx] = jumsu;
                    idx++;
                    break;
                case '*':
                    int temp = tempJumsuList[idx] * 2;
                    temp += tempJumsuList[idx-1] *2;
                    answer = temp;
                    // System.out.println(answer + "*2");
                    break;
                case '#':
                    answer = answer * (-1);
                    // System.out.println(answer + "*(-1)");
                    display.append("*(-1)");
                    break;
            }
        }
        System.out.println(display);
        System.out.println("===================================");

        return answer;
    }


}
