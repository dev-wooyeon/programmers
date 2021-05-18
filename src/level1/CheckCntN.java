package level1;

public class CheckCntN {

    /// Fields

    /// Constructor
    public CheckCntN() {
        System.out.println(getClass().getName() + " Create Dafault Constructor ");
        problem();
    }

    public void problem() {

        solution();
    }

    public void solution() {

        String s = "pPoooyY";

        int char1Cnt = 0;
        int char2Cnt = 0;

        for (int i = 0; i < s.length(); ++i) {
            if ('p' == s.toLowerCase().charAt(i)) {
                char1Cnt++;
            }
            if ('y' == s.toLowerCase().charAt(i)) {
                char2Cnt++;
            }
        }

        System.out.println(char1Cnt + " : " + char2Cnt);
        if (char1Cnt != char2Cnt & !(char1Cnt == 0 & char2Cnt == 0)) {
            // false
        }

    }
}
