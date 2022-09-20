package level1;

import java.util.Arrays;

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

        String[] n_List = String.valueOf(n).split("");
        Arrays.sort(n_List);

        StringBuilder temp = new StringBuilder();
        for (String index: n_List) {
            temp.append(index);
        }

        answer = Long.parseLong(temp.reverse().toString());

        return answer;
    }
}
