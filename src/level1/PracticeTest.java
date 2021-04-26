package level1;

public class PracticeTest {
    
    /// Fields
    private int[] answerList;
    private int[] supojaList;

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

        int answerCase = 1;
        switch (answerCase) {
            case 1 :
                answerList = new int[]{1, 2, 3, 4, 5};
                break;
            case 2 :
                answerList = new int[]{1, 3, 2, 4, 2};
            default:
                break;
        }

        int supojaCase = 1;
        switch (supojaCase) {
            case 1 :
                supojaList = new int[]{1, 2, 3, 4, 5};
                break;
            case 2 :
                supojaList = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
                break;
            case 3 :
                supojaList = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            default:
                break;
        }

        solution(answerList, supojaList);
    }

    private void solution(int[] answerList, int[] supojaList) {

        for(int ans = 0 ; ans < answerList.length ; ans ++){

            System.out.println(answerList[ans]);

        }


    }


    
}
