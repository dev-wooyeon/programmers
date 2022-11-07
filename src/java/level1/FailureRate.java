package java.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class FailureRate {
    /// Fields

    /// Contructor
    public FailureRate() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. N:5 stages[2, 1, 2, 6, 2, 4, 3, 3]");
        System.out.println("2. N:4 stages[4, 4, 4, 4, 4]");
        System.out.print("테스트 케이스를 선택 : ");

        int n = 0;
        int[] stages = {};
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    n = 5;
                    stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
                    break;
                case 2:
                    n = 4;
                    stages = new int[]{4, 4, 4, 4, 4};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    n = 5;
                    stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
                    break;
            }
        }

        int[] results = solution2(n, stages);
        for (int result : results) {
            System.out.print(result + ", ");
        }
    }

    public int[] solution(int n, int[] stages) {

        int[] answer = new int[n];

        Double[] failures = new Double[n];

        ArrayList<Double> list = new ArrayList<Double>();
        // 스테이지 N개 만큼 도는 for문
        for (int i = 1; i < n + 1; ++i) {

            int fail = 0;
            int succ = 0;

            // 스테이지에 
            for (int stage : stages) {

                if (i <= stage) {
                    // System.out.println("[SUCC] ["+j+"]"+"["+i+"]"+"["+stages[j]+"]");
                    succ++;
                }

                if (i == stage) {
                    // System.out.println("[FAIL] ["+j+"]"+"["+i+"]"+"["+stages[j]+"]");
                    fail++;
                }

            }

            // System.out.println("stages users cnt : " + succ + ", fail cnt : " + (stages.length-succ));
            Double failure = (double) fail / (succ + fail);
            failures[i - 1] = failure;
            list.add(failure);
        }

        Collections.sort(list, Comparator.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < failures.length; j++) {
                if (list.get(i) == failures[j]) {
                    answer[i] = j + 1;
                    failures[j] = failures[j] - 1;
                }
            }
        }


        return answer;
    }

    public int[] solution2(int N, int[] stages) {

        int[] answer = new int[N];

        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        // N개의 스테이지 만큼 도는 for문
        for (int i = 1; i < N + 1; ++i) {
            int fail = 0;
            int succ = 0;
            // 도전중인 유저수의 스테이지 만큼 도는 for문
            for (int stage : stages) {
                // 유저의 스테이지가 i의 스테이지보다 작거나 같다면 성공카운트++
                if (i <= stage) succ++;
                // 유저의 스테이지가 i의 스테이지와 같다면 실패 카운트++
                if (i == stage) fail++;
            }

            double failure = 0.0;
            // 0으로 나누어 지는 경우가 없게 하기 위해 유효성 검사를 하고, 실패율을 계산한다.
            if (succ != 0 && fail != 0) {
                failure = (double) fail / (double) succ;
            }
            // 스테이지 i 번과, 실패율을 map에 담는다.
            map.put(i, failure);
        }

        // 정렬하기 위해 스테이지 N개 만큼 도는 outer i for
        for (int i = 0; i < N; i++) {
            // max값 처리를 위해 i루프 돌때마다 max:-1, idx=0 초기화
            double max = -1;
            int idx = 0;
            // map의 keySet메소드를 호출하여 존재하는 mapKey만큼 도는 inner for
            for (Integer mapKey : map.keySet()) {
                // max값과 value값을 비교후 값 세팅
                if (max < map.get(mapKey)) {
                    max = map.get(mapKey);
                    idx = mapKey;
                }
            }
            // 답안지세팅.
            answer[i] = idx;
            // 세팅한 idx제거한다.
            map.remove(idx);
        }

        return answer;
    }
}

