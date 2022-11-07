package java.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Marathon {
    /// Fields
    private String[] participant;
    private String[] completion;

    /// Constructor
    public Marathon() {
        System.out.println("Create Default Constructor");

        problem();
    }

    /// Method
    public void problem() {

        /**
         * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
         * completion의 길이는 participant의 길이보다 1 작습니다.
         * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
         * 참가자 중에는 동명이인이 있을 수 있습니다.
         */

        int caseNo = 2;
        String caseSol = "Map"; // 처리할 객체 선택 List : ArrayList, Map : HashMap;
        switch (caseNo) {
            case 1:
                participant = new String[]{"leo", "kiki", "eden"};
                completion = new String[]{"eden", "kiki"};
                break;
            case 2:
                participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
                completion = new String[]{"josipa", "filipa", "marina", "nikola"};
                break;
            case 3:
                participant = new String[]{"mislav", "stanko", "mislav", "ana"};
                completion = new String[]{"stanko", "ana", "mislav"};
                break;
        }

        String answer = "";

        switch (caseSol) {
            case "List":
                answer = solutionList(participant, completion);
                break;
            case "Map":
                answer = solutionMap(participant, completion);
                break;
            default:
                break;
        }

        System.out.println(answer);
    }

    public String solutionList(String[] participant, String[] completion) {

        String answer = "";

        // 완주한 사람들 리스트화
        List<String> compList = new ArrayList<String>(Arrays.asList(completion));

        // 참가자 사람들 만큼 도는 for문
        for (String part : participant) {

            // 완주리스트에서 참가자가 포함되어 있는지 체크
            if (compList.contains(part)) {
                // 포함되어 있으면 완주리스트 에서 제거
                compList.remove(part);
            } else {
                // 포함되어 있지 않은경우 답으로 세팅
                answer = part;
            }
        }
        return answer;
    }

    public String solutionMap(String[] participant, String[] completion) {

        // ★ 중요한 기본 개념 : HashMap은 중복을 허용하지 않는다는 점을 이용한 알고리즘
        String answer = "";

        HashMap<String, Integer> hsm = new HashMap<String, Integer>();

        // 참가자 리스트를 HashMap에 저장 (단, 같인 키값 존재시 +1 처리 업데이트 처리)
        for (String part : participant) hsm.put(part, hsm.getOrDefault(part, 0) + 1);
        // 완주자 리스트를 HashMap에 저장 (단, 같은 키값 존재시 -1 처리 업데이트)
        for (String comp : completion) hsm.put(comp, hsm.get(comp) - 1);

        // 저장한 데이터 디버깅용 (프로그래머스 테스트시 주석처리 하시면 됩니다.)
        // System.out.println("Map : " + hsm.toString());

        // hsm의 키값 Iterator 객체화
        Iterator<String> keySet = hsm.keySet().iterator();
        // 가지고 있는 key 개수 만큼 동작하는 반복문
        while (keySet.hasNext()) {
            // getokeney
            String key = keySet.next();
            // 완주한 사람은 0이므로 완주하지 못한 사람을 얻을 수 있음.
            if (hsm.get(key) != 0) answer = key;
        }

        // 완주하지 못한 사람 리턴
        return answer;
    }
}
