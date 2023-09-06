package org.example.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Lv1_ClosedString {

    //On2
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] c = s.toCharArray();
        for (int i=0;i<c.length;i++) {
            int a = -1;
            for (int j=i-1;j>=0;j--) {
                if (c[i]==c[j]) {
                    a = i-j;
                    break;
                }
            }
            answer[i] = a;
        }
        return answer;
    }

    //On
    public int[] solution2(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            answer[i] = i-map.getOrDefault(c, i+1);
            map.put(c, i);
        }
        return answer;
    }

    public static void main(String[] args) {
        try {

            Lv1_ClosedString l = new Lv1_ClosedString();
            int[] result = l.solution2("banana");

            for (int r : result) {
                System.out.println(r);
            }

        } catch (Exception e) {

        }
    }
}
