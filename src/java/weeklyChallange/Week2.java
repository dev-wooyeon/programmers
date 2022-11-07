package java.weeklyChallange;

import java.util.Scanner;

public class Week2 {

    /// Fields

    /// Constructor
    public Week2(){
        problem();
    }

    /// Method
    public void problem(){

        System.out.println(" 위클리 챌린지 2주차 상호 평가 ");

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. scores : [[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]] result : FBABD ");
        System.out.println("2. scores : [[50,90],[50,87]] result : DA ");
        System.out.println("3. scores : [[70,49,90],[68,50,38],[73,31,100]] result : CFD ");
        System.out.print("테스트 케이스를 선택 : ");


        int scores[][] = {{}};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    scores = new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
                    break;
                case 2:
                    scores = new int[][]{{50,90},{50,87}};
                    break;
                case 3:
                    scores = new int[][]{{70,49,90},{68,50,38},{73,31,100}};
                    break;
                default:
                    scores = new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
                    break;
            }
        }

        String result = solution(scores);
        System.out.println(" result = " + result);
    }

    public String solution(int[][] scores){

        StringBuilder answer = new StringBuilder();

        // 변수 서언 최고, 최저, 합계, 길이
        int max, min, sum, slen = scores.length;
        // 계산하여 담을 평균 값
        double cal_avg;
        // 계산 완료한 데이터 담을 평균 점수 리스트
        double[] avg_list = new double[slen];

        // 행 처리할 for
        for(int i = 0 ; i < slen; i++){

            // 0<= scores <= 100 이므로 max = -1, min = 101로 선언
            sum = 0;
            max = -1;
            min = 101;

            // 열 처리할 for
            for(int j = 0 ; j < slen; j++) {

                // 0,0 1,1 2,2 3,3 4,4 ( 자기 자신을 평가한 점수 제외 )
                if (i == j) continue;
                // 최고 점수 조회
                max = Math.max(max, scores[j][i]);
                // 최저 점수 조회
                min = Math.min(min, scores[j][i]);
                // 자기 자신을 평가한 점수를 제외하고 계산
                sum += scores[j][i];

            }

            // 평균 구하기
            // 유일한 점수인지 체크히여 유일한 점수인 경우 -1처리
            if (scores[i][i] > max || scores[i][i] < min) {
                cal_avg = sum / (slen - 1);
            } else {
                // 자기 자신을 평가한 점수가 유일한 값이 아닐 경우 합산하여 평균 계산
                sum += scores[i][i];
                cal_avg = sum / slen;
            }

            // 계산한 평균값 리스트에 담는다.
            avg_list[i] = cal_avg;
        }

        // 학점 구하기
        for(double avg : avg_list){
            switch ((int) avg / 10){
                case 10 :
                case 9 : answer.append("A"); break;
                case 8 : answer.append("B"); break;
                case 7 : answer.append("C"); break;
                case 6 :
                case 5 : answer.append("D"); break;
                default: answer.append("F");
            }
        }
        // 답안 제출
        return answer.toString();
    }
}
