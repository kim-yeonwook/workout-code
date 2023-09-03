package org.example.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1_NumpadMake {

    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<>();

        for (String target : targets) {
            int result = 0;
            for (char c : target.toCharArray()) {
                int minCount = 99;

                for (String key : keymap) {
                    int keyCount = key.indexOf(c) < 0 ? 99 : key.indexOf(c)+1;
                    if (minCount>keyCount) minCount = keyCount;
                }

                if (minCount==99) {
                    result = -1;
                    break;
                } else {
                    result+=minCount;
                }
            }

            list.add(result);
        }

        return list.stream().mapToInt(a->a).toArray();
    }

    // 다른사람 풀이
    public int[] solution2(String[] keymap, String[] targets) {
        int[] minTouch = new int['Z' - 'A' + 1];
        System.out.println(minTouch.length);
        Arrays.fill(minTouch, 200);
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                minTouch[key.charAt(i) - 'A'] = Math.min(minTouch[key.charAt(i) - 'A'], i + 1);
            }
        }
        int[] answer = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int sum = 0;
            boolean canMake = true;
            for (int j = 0; j < target.length(); j++) {
                if (minTouch[target.charAt(j) - 'A'] == 200) {
                    canMake = false;
                    break;
                }
                sum += minTouch[target.charAt(j) - 'A'];
            }
            answer[i] = canMake ? sum : -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        try {
            Lv1_NumpadMake l = new Lv1_NumpadMake();
            int[] i = l.solution2(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD","AABB"});

            for(int is : i) {
                System.out.println(is);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
