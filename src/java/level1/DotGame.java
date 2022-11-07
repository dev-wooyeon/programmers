package java.level1;

import java.util.StringTokenizer;

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


        // 토큰 처리
        StringTokenizer st = new StringTokenizer(dartResult, "SDT*#",true);
        // 점수 처리할 숫자배열 선언
        int[] point_arr = new int[3];
        // 위치(position) 약자 pos 변수 선언
        int pos = 0;

        // 디버깅 디스플레이 용도의 StringBuilder 선언
        // StringBuilder display = new StringBuilder();

        // 토큰을 가지고 있는 경우에 수행하는 while 문
        while(st.hasMoreTokens()){

            // 토큰값을 얻는다
            String token = st.nextToken();

            // token 값에 따라 case 처리할 switch-case 문
            switch (token){
                case "S" :
                    // S(Single) 일 경우 * 1 이므로 default 에서 배열에 담겨 있기 때문에 연산 불필요
                    break;
                case "D" :
                    // D(Double) 일 경우 얻은 점수의 ^2
                    point_arr[pos-1] = (int) Math.pow(point_arr[pos-1], 2);
                    // display.append("token : " + token + ", pos : " + pos + ", point_arr[pos-1] : " + point_arr[pos-1] + ", point_arr^2 : " +point_arr[pos-1]+"\n");
                    break;
                case "T" :
                    // T(Triple) 일 경우 얻은 점수의 ^3
                    point_arr[pos-1] = (int) Math.pow(point_arr[pos-1], 3);
                    // display.append("token : " + token + ", pos : " + pos + ", point_arr[pos-1] : " + point_arr[pos-1] + ", point_arr^3 : " +point_arr[pos-1]+"\n");
                    break;
                case "*" :
                    // *(스타상) 일 경우 얻은 점수 2배
                    point_arr[pos-1] = point_arr[pos-1] * 2;
                    // 만약 스타상의 위치가 2이상 인 경우에 앞 라운드의 점수를 * 2 처리한다.
                    if(pos > 1) point_arr[pos-2] = point_arr[pos-2] * 2;
                    // display.append("token : " + token + ", pos : " + pos + ", point_arr[pos-1] : " + point_arr[pos-1] + ", point_arr*2 : " +point_arr[pos-1] * 2+"\n");
                    break;
                case "#" :
                    // #(아차상) 일 경우 얻은 점수 * -1
                    point_arr[pos-1] = point_arr[pos-1] * -1;
                    // display.append("token : " + token + ", pos : " + pos + ", point_arr[pos-1] : " + point_arr[pos-1] + ", point_arr-1 : " +point_arr[pos-1] * 2+"\n");
                    break;
                default:
                    // 각 라운드 별 점수 처리하는 default 구문
                    point_arr[pos] = Integer.parseInt(token);
                    // display.append("token : " + token + ", pos : " + pos + ", point_arr[pos-1] : " + point_arr[pos] + ", point_arr : " +point_arr[pos]+"\n");
                    pos++;
            }

        }

        // 처리 완료한 포인트 배열을 합산한다.
        for (int getPoint: point_arr) {
            answer += getPoint;
        }

        // display.append("game : " + dartResult +  ", answer : " + answer);
        // System.out.println(display);
        // System.out.println("===================================");

        return answer;
    }
//    public int solution(String dartResult) {
//
//        int answer = 0;
//
//        dartResult = dartResult.replaceAll("10", "J");
//        StringBuilder display = new StringBuilder();
//        int[] tempJumsuList = new int[3];
//        for (int i = 0; i < dartResult.length(); i++) {
//            int jumsu = 0;
//            int idx = 0;
//            switch (dartResult.charAt(i)) {
//                case 'S':
//                    if (dartResult.charAt(i - 1) == 'J') jumsu = 10;
//                    else jumsu = Character.getNumericValue(dartResult.charAt(i - 1));
//                    answer += Math.pow(jumsu, 1);
//                    // System.out.println("+" + jumsu + "^1");
//                    display.append("+" + jumsu + "^1");
//                    tempJumsuList[idx] = jumsu;
//                    idx++;
//                    break;
//                case 'D':
//                    if (dartResult.charAt(i - 1) == 'J') jumsu = 10;
//                    else jumsu = Character.getNumericValue(dartResult.charAt(i - 1));
//                    answer += Math.pow(jumsu, 2);
//                    // System.out.println("+" + jumsu + "^2");
//                    display.append("+" + jumsu + "^2");
//                    tempJumsuList[idx] = jumsu;
//                    idx++;
//                    break;
//                case 'T':
//                    if (dartResult.charAt(i - 1) == 'J') jumsu = 10;
//                    else jumsu = Character.getNumericValue(dartResult.charAt(i - 1));
//                    answer += Math.pow(jumsu, 3);
//                    // System.out.println("+" + jumsu + "^3");
//                    display.append("+" + jumsu + "^3");
//                    tempJumsuList[idx] = jumsu;
//                    idx++;
//                    break;
//                case '*':
//                    int temp = tempJumsuList[idx] * 2;
//                    temp += tempJumsuList[idx - 1] * 2;
//                    answer = temp;
//                    // System.out.println(answer + "*2");
//                    break;
//                case '#':
//                    answer = answer * (-1);
//                    // System.out.println(answer + "*(-1)");
//                    display.append("*(-1)");
//                    break;
//            }
//        }
//        System.out.println(display);
//        System.out.println("===================================");

//        return answer;
//    }


}
