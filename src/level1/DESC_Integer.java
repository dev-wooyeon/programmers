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
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < newStr.length()-1; i++) {
            for (int j = i+1 ;j < newStr.length(); j++) {
                if (newStr.charAt(i) > newStr.charAt(j)) {
                    temp.append(newStr.charAt(i));
                    break;
                }
            }
        }
        answer = Long.parseLong(temp.toString());
        return answer;
    }
}
