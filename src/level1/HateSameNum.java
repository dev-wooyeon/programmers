package level1;

public class HateSameNum {

    /// Fields

    /// Constructor
    public HateSameNum() {
         System.out.println( getClass().getName() + " Create Default Constuctor ");

         problem();
    }

    /// Method
    public void problem() {
        
        int key = 2;
        int[] arr = {};
        switch (key) {
            case 1:
                arr = new int[]{1,1,3,3,0,1,1};
                break;
            case 2:
                arr = new int[]{4,4,4,3,3};
                break;
            default:
                break;
        }

        solution(arr);
    }

    public void solution(int[] arr){
        int[] answer = {};

        int cnt = 1;

        for(int i = 0 ; i < arr.length ; i++){
            if(i > 0) {
                if( arr[i] != arr[i-1]){
                    System.out.println( " i : " + arr[i] + ", i-1 : " +  arr[i-1]);
                    cnt++;
                    // arr[i-1];
                }
            }
        }

        // System.out.println(" CNT : " + cnt);
        answer = new int[cnt];

        int idx = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(i > 0) {
                if( arr[i] != arr[i-1]){
                    answer[idx++] = arr[i-1];
                }
            }
        }

        for(int an : answer){
            System.out.print(an + ", ");    
        }
        
    }   

}
