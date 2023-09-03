package org.example.programmers.lv0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lv0_NumberParseSpring_1 {

    public String solution(int age) {
        String answer = "";

        for (char c : String.valueOf(age).toCharArray()) {
            answer+=(c+=48);
        }

        return answer;
    }

    // 다른 사람 풀이 Stream 이용 collectors joining사용시 배열 이어줌
    public String solution2(int age) {
        return String.valueOf(age).chars().mapToObj(a->String.valueOf((char)(a+48))).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Lv0_NumberParseSpring_1 l = new Lv0_NumberParseSpring_1();
        String numStr = l.solution(23);
        System.out.println(numStr);

        String numStr2 = l.solution2(23);
        System.out.println(numStr2);


        int[] emergency = new int[] {7,4,2,1,5};
        int size = emergency.length;
        List<Integer> list = Arrays.stream(emergency).boxed().collect(Collectors.toList()).stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int[] answer = new int[size];
        for (int i=0; i<size; i++) {
            answer[i] = list.indexOf(emergency[i])+1;
        }

    }
}
