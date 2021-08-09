package weeklyChallange;

import java.util.HashMap;
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

        // 유일한 최고점, 최저점, 평균 구할 갯수 조회
        int max = -1; // 0<= score
        int min = 101; // score <= 100
        int sum = 0;
        double cal_avg = 0.0;
        int slen = scores.length;
        double[] avg_list = new double[slen];

        for(int i = 0 ; i < slen; i++){
            for(int j = 0 ; j < slen; j++) {

                if (i == j) continue;
                max = Math.max(max, scores[j][i]);
                min = Math.min(min, scores[j][i]);
                sum += scores[j][i];
            }

            // 평균 구하기
            if (scores[i][i] > max || scores[i][i] < min) {
                cal_avg = sum / slen - 1;
            } else {
                sum+= scores[i][i];
                cal_avg = sum / slen;
            }
            avg_list[i] = cal_avg;

            cal_avg = 0.0;
            sum = 0;
            max = -1;
            min = 101;
        }

        // 학점 정하기
        for(double avg : avg_list){
            System.out.println(" avg = " + avg);
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
