package level1;

import java.util.ArrayList;

public class PracticeTest {
    
    /// Fields
    private int[] answerList;
    

    /// Constructor
    public PracticeTest(){
        System.out.println("Create Default Constructor");
        problem();
    }

    /// Method
    private void problem() {
        
        /**
         * 제한 조건
         * 시험은 최대 10,000 문제로 구성되어있습니다.
         * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
         * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
         */

        int answerCase = 2;
        switch (answerCase) {
            case 1 :
                answerList = new int[]{1, 2, 3, 4, 5};
                break;
            case 2 :
                answerList = new int[]{1, 3, 2, 4, 2};
                break;
            case 3 :
                answerList = new int[]{3, 2, 1, 1, 2};
            default:
                break;
        }

        int[] answers = solution(answerList);

        for(int answer : answers){
            System.out.println("제출 답안 확인용 : " + answer );
        }
    }

    private int[] solution(int[] answerList)  {

        int[] answer;
        
        // 수포자 패턴 생성
        int[] pattern1 = new int[]{1, 2, 3, 4, 5};
        int[] pattern2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 2차원 패턴 배열 생성
        int[][] patternList = new int[][]{
            pattern1, // 0 
            pattern2, // 1
            pattern3  // 2
        };

        // 패턴리스트의 길이만큼 점수 리스트 생성
        int[] jumsu = new int[patternList.length];

        // 정답리스트만큼 수행하는 for
        for(int i = 0 ; i < answerList.length ; i++){
            // ★ 처리해야하는 패턴이 많아지면 하기 하드코딩한 숫자값(0, 1, 2)들을 처리하는 inner for 구현
            // 1번 패턴 정답 확인 후 점수 카운트 ++
            if(answerList[i] == patternList[0][i%patternList[0].length]) {
                jumsu[0]++;
            } 
            // 2번 패턴 정답 확인 후 점수 카운트 ++
            if(answerList[i] == patternList[1][i%patternList[1].length]) {
                jumsu[1]++;
            } 
            // 3번 패턴 정답 확인 후 점수 카운트 ++
            if(answerList[i] == patternList[2][i%patternList[2].length]) {
                jumsu[2]++;
            }
        }

        // 랭크 처리할 리스트 생성
        ArrayList<Integer> rankList = new ArrayList<Integer>();

        // ★ 여기도 마찬가지로 개선 필요할 것 같음.
        // 가장 높은 점수 체크
        int max = jumsu[0];
        // if( max < jumsu[0]) max = jumsu[0]; // 0으로 초기화 되어 생성되기 때문에 MAX값에 0번값으로 초기 세팅으로 변경
        if( max < jumsu[1]) max = jumsu[1];
        if( max < jumsu[2]) max = jumsu[2];
        
        // 점수 배열만큼 도는 for
        for(int i=0; i < jumsu.length ; i++) {
            // 점수배열에서 얻은 값이 가장 높은 점수인경우
            if (jumsu[i] == max){
                // 리스트에 담는다.
                rankList.add(i+1);
            }
        }
        
        // 랭크 처리 후 수포자 번호 리턴세팅
        answer = new int[rankList.size()];
        int idx = 0;
        for(int test : rankList){
            answer[idx++] = test;
        }

        return answer;
    }
}
