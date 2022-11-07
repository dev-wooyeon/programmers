package java.level1;

import java.util.ArrayList;
import java.util.List;

public class HateSameNum {

    /// Fields

    /// Constructor
    public HateSameNum() {
        System.out.println(getClass().getName() + " Create Default Constuctor ");

        problem();
    }

    /// Method
    public void problem() {

        int key = 1;
        int[] arr = {};
        switch (key) {
            case 1:
                arr = new int[]{1, 1, 3, 3, 0, 1, 1};
                break;
            case 2:
                arr = new int[]{4, 4, 4, 3, 3};
                break;
            default:
                break;
        }

        solution(arr);
    }

    // public void solution(int[] arr){
    //     int[] answer = {};

    //     // 중복되지 않는 숫자가 몇개가 있는지 체크
    //     int cnt = 1;

    //     // arr 길이만큼 도는 for
    //     for(int i = 1 ; i < arr.length ; i++){
    //         // arr[i] 번째 방의 값과 arr[i-1]의 값이 다를때 ( 즉, 중복되지 않을 때 )
    //         if( arr[i] != arr[i-1]){
    //             // 건수 증가
    //             cnt++;
    //         }
    //     }

    //     // 건수크기의 배열 생성
    //     answer = new int[cnt];

    //     // answer 배열의 인덱스처리할 변수 추가
    //     int idx = 0;
    //     // arr 길이만큼 도는 for
    //     for(int i = 1 ; i < arr.length ; i++){
    //         // arr[i] 번째 방의 값과 arr[i-1]의 값이 다를때 ( 즉, 중복되지 않을 때 )
    //         if( arr[i] != arr[i-1]){
    //             // answer[idx] 증가시키며 중복되지 않는 데이터 SET
    //             answer[idx++] = arr[i-1];
    //         }
    //     }
    //     // 마지막 인덱스에 배열의 가장 끝자리 처리
    //     answer[idx] = arr[arr.length-1];


    //     for(int an : answer){
    //         System.out.print(an + ", ");    
    //     }

    // }   

    public void solution(int[] arr) {

        List<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            System.out.println(answer[i]);
        }


    }

}
