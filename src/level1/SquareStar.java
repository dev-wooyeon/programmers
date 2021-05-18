package level1;

import java.util.Scanner;

public class SquareStar {

    /// Fields

    /// Contructor
    public SquareStar() {
        super();

        problem();
    }

    /// Method
    public void problem() {


        solution();

    }

    public void solution() {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("X축 입력 : ");
            int a = scan.nextInt();
            System.out.print("Y축 입력 : ");
            int b = scan.nextInt();

            StringBuffer sb = new StringBuffer();
            for (int x = 0; x < a; ++x) {
                sb.append('*');
            }

            for (int y = 0; y < b; ++y) {
                System.out.println(sb.toString());
            }
        }
    }
}
