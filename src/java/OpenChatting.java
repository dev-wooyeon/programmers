package java.level2;

import java.util.*;

public class OpenChatting {

    /// Fields

    /// Constructor
    public OpenChatting() {
        problem();
    }

    private void problem() {

        StringBuilder test_case = new StringBuilder();
        test_case.append(" 1. [\"Enter uid1234 Muzi\", \"Enter uid4567 Prodo\",\"Leave uid1234\",\"Enter uid1234 Prodo\",\"Change uid4567 Ryan\"]");

        System.out.println(" 테스트 케이스 : " + test_case);

        String[] record = new String[]{
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        String[] return_answer = solution(record);
        for (String answer : return_answer) System.out.println(answer);
    }

    private String[] solution(String[] record) {

        StringBuilder process_str = new StringBuilder();
        Map<String,String> user_map = new HashMap<>();

        for (String str : record) {

            String[] records = str.split("\\s+");
            String event = records[0];
            if ("Leave".equals(event)) {
                process_str.append(records[1]).append("님이 나갔습니다.#");
            }
            if ("Enter".equals(event)) {
                process_str.append(records[1]).append("님이 들어왔습니다.#");
                user_map.put(records[1], records[2]);
            }
            if ("Change".equals(event)) {
                user_map.put(records[1], records[2]);
            }
        }


        // System.out.println(" DEBUG : " + process_str);

        String check_str = process_str.toString();
        String[] answer = check_str.split("#");
        for(int i = 0; i < answer.length; i++){
            String key = answer[i].substring(0, answer[i].indexOf("님"));
            answer[i] = answer[i].replace(key, user_map.get(key));
        }

        // step 3. return
        return answer;
    }


    /// Method
}
