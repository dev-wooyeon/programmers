package level1;

import java.util.ArrayList;
import java.util.List;

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
            default:
                break;
        }

        solution(answerList);
    }

    private void solution(int[] answerList)  {

        int[] supojaList1 = new int[]{1, 2, 3, 4, 5};
        int[] supojaList2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] supojaList3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[][] supojaList = new int[][]{
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        for(int i = 0 ; i < answerList.length ; ++i){
            for(int j = 0 ; j < supojaList.length ; j++)
                if(answerList[i] == supojaList[j][i%answerList.length] ){
                    System.out.println(supojaList[j][i%answerList.length] + ", " + i%answerList.length + ", " + answerList[i]);
                }
        }
        

    }
    
}
