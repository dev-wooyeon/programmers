package level1;

import java.util.Stack;

public class CrainGame{
    
    /// Fields

    /// Constructor
    public CrainGame(){
        System.out.println(" CREATE DEFAULT CONSTRUCTOR ");

        problem();
    }

    /// Method
    public void problem(){

        /*
            [제한사항]
            board 배열은 2차원 배열로 크기는 "5 x 5" 이상 "30 x 30" 이하입니다.
            board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
            0은 빈 칸을 나타냅니다.
            1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
            moves 배열의 크기는 1 이상 1,000 이하입니다.
            moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

            [입출력 예]
            board	
            [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	
            moves
            [1,5,3,5,1,2,1,4]	
            result
            4
        */
        
        int[][] board  = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        /*
        [0][0][0][0][0]
        [0][0][1][0][3]
        [0][2][5][0][1]
        [4][2][4][4][2]
        [3][5][1][3][1]
        */
        int answer = solution(board, moves);
        System.out.println("정답 : " + answer);
        
    }

    public int solution(int[][] board, int[] moves){
        // 결과 값 Return 할 변수
        int answer = 0;
        // 전달받은 배열의 길이 체크
        int boardLen = board.length;
        int movesLen = moves.length;
        // 결과 값 처리할 bucket이름을 가진 Stack 객체 생성
        Stack<Integer> bucket = new Stack<Integer>();
        // 크레인의 움직임에 대한 OUTER FOR 
        for( int m = 0 ; m < movesLen ; ++m){
            // 배열 크기 만큼 처리 하기 위한 INNER FOR
            for( int b = 0 ; b < boardLen; ++b ){
                // 게임보드에서 크레인을 움직여 얻은 값을 getPoint 이라는 변수에 할당.
                int getPoint = board[b][moves[m]-1];
                // getPoint의 값 0 이 아닐경우
                if(getPoint != 0){
                    // bucket이 비어 있는지 확인
                    if(bucket.empty()){
                        // 비어있는 경우 얻은 값을 넣는다.
                        bucket.push(getPoint);
                    } else {
                        // bucket의 마지막 원소가 얻은 인형의 값과 같을 경우
                        if(bucket.lastElement().equals(getPoint)){
                            // 마지막 원소의 값을 빼낸 후에
                            bucket.pop(); 
                            // 같은 원소 처리 건수에 대한 카운팅 처리
                            answer += 2;
                        } else {
                            // 다를 경우에는 bucket에 넣는다.
                            bucket.push(getPoint);
                        }
                    }
                    // 처리가 완료 된 후 비워준다.
                    board[b][moves[m]-1] = 0;
                    // 비워 준 후 다음 크레인 움직임을 처리 할 수 있도록 break 처리
                    break;
                }
            }
        }
        return answer;
    }

}