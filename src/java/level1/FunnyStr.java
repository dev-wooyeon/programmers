package java.level1;

public class FunnyStr {

    /// Fields

    /// Contructor
    public FunnyStr() {
        super();

        problem();
    }

    /// Method
    public void problem() {

        System.out.println(" 이상한 문자 만들기 클래스 호출 되었습니다. ");

            /*
        문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

                제한 사항
        문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
                첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
                입출력 예
        s	return
                "try hello world"	"TrY HeLlO WoRlD"
                */

        String s = "try hello world";
        // 스캐너 사용 후 자동으로 자원 반납을 위한
        // Try-with-resources
/*        try (Scanner scan = new Scanner(System.in)) {
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    arr = new int[]{1, 2, 3, 4};
                    break;
                case 2:
                    arr = new int[]{5, 5};
                    break;
                default:
                    System.out.println("존재하지 않는 테스트 케이스 선택하여 자동으로 1번으로 처리됩니다.");
                    arr = new int[]{1, 2, 3, 4};
                    break;
            }
        }*/

        String result = solution(s);
        System.out.print(" result : " + result);

    }

    public String solution(String s) {

        StringBuffer answer = new StringBuffer();

        String[] tempStrArray = s.split(" ");
        for (int i = 0 ; i < tempStrArray.length; ++ i){
            for (int j = 0; j < tempStrArray[i].length(); ++j) {
                if(j % 2 == 0){
                    answer.append(String.valueOf(tempStrArray[i].charAt(j)).toUpperCase());
                } else {
                    answer.append(String.valueOf(tempStrArray[i].charAt(j)).toLowerCase());
                }
            }
            answer.append(" ");
        }

        return answer.toString().substring(0,answer.length()-1);
    }
}
