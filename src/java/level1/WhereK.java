package java.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WhereK {

    /// Fields

    /// Contructor
    public WhereK() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("테스트 케이스\n1. array[1,5,2,6,3,7,4] commands[[2,5,3], [4,4,1], [1,7,3]]");

        int[] array = new int[]{};
        int[][] commands = new int[][]{};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            if (1 == key) {
                array = new int[]{1, 5, 2, 6, 3, 7, 4};
                commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
            }
        }

        int[] results = solution(array, commands);
        for (int result : results) {
            System.out.println("result : " + result);
        }
    }


    public int[] solution(int[] array, int[][] commands) {

        // commands의 1차원 배열의 크기 만큼 답안지 길이 세팅한다.
        int[] answer = new int[commands.length];

        // ommands의 길이 만큼 도는 for
        for (int i = 0; i < commands.length; i++) {

            // 2차원 배열의 의미에 따라 start, end, k 변수 선언
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];


            // ArrayList 생성
            ArrayList<Integer> list = new ArrayList<>();
            // start와 end를 비교하는 while 조건절

            while (start <= end) {

                // 리스트에 start-1번째 인덱스를 얻어 추가한다.
                list.add(array[start - 1]);
                // 추가 후 start 증가
                start++;
                // 만약 start가 end보다 커지는 경우에 while break 처리
                if (start > end) break;
            }

            // 데이터 정렬
            Collections.sort(list);

            // 정렬된 데이터 디버깅용
            // System.out.println(list.toString());

            // 답안지 배열의 i번째 방에 리스트에서 K번째 인덱스의 값을 얻어 세팅한다.
            answer[i] = list.get(k - 1);
        }

        return answer;
    }
}
