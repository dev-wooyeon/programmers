package java.level1;

public class GetMidStr {

    /// Fields

    /// Constructor
    public GetMidStr() {
        System.out.println(getClass().getName() + " Create Dafault Constructor ");

        problem();
    }

    /// Method
    public void problem() {

        // String s = "abcde";
        String s = "qwer";
        solution(s);
    }

    public void solution(String s) {
        String answer = "";

        if (!"".equals(s))
            answer = s.substring((s.length() - 1) / 2, (s.length() / 2) + 1);

        // if(s.length() % 2 == 0){
        // answer = s.substring((s.length()/2)-1, s.length()/2+1);
        // } else {
        // answer = s.substring(s.length() - (s.length()/2)-1, s.length() -
        // (s.length()/2));
        // }

        System.out.println(answer);
    }
}
