package weeklyChallange;

import java.util.Scanner;

public class Week1 {

    /// Fields

    /// Constructor
    public Week1(){
        problem();
    }

    /// Method
    public void problem(){

        System.out.println(" 부족한 금액 계산하기 ");

        System.out.println("￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣");
        System.out.println("1. price : 3, money : 20, count : 4");
        System.out.print("테스트 케이스를 선택 : ");


        int price = 0;
        int money = 0;
        int count = 0;
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    price = 3;
                    money = 20;
                    count = 4;
                    break;
                case 2:
                    price = 10;
                    money = 200000000;
                    count = 4;
                    break;
                default:
                    price = 3;
                    money = 20;
                    count = 4;
                    break;
            }
        }

        long result = solution(price, money, count);
        System.out.println(" result = " + result);
    }

    public long solution(int price, int money, int count){

        int answer = 0;

        for(int i = 1 ; i <= count ; ++i ) answer += price * i;
        return Long.valueOf(answer-money)>0?Long.valueOf(answer-money):0;
    }
}
