package level1;

public class DESC_Integer {

    /// Fields

    /// Contructor
    public DESC_Integer() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        long n = 118372;

        long result = solution(n);
        System.out.print("result : " + result);

    }

    private long solution(long n) {

        long answer = 0;

        String newStr = String.valueOf(n);
        long max = 0;
        for (int i = 0; i < newStr.length(); i++) {

            System.out.println(" max : " + max + " char : " + newStr.charAt(i));
            if (max < newStr.charAt(i))
                max = newStr.charAt(i);

        }

        return answer;
    }
}
