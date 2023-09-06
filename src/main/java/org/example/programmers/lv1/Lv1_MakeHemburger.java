package org.example.programmers.lv1;

import java.util.Stack;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lv1_MakeHemburger {
    
    // 문자열로 풀면 속도 이슈
    public int solution(int[] ingredient) {
        int answer = 0;

        String man = IntStream.of(ingredient).mapToObj(a-> String.valueOf(a)).collect(Collectors.joining());
        while (true) {
            int size = man.length();
            man = man.replaceFirst("1231","");
            if (size==man.length()) break;
            answer++;
        }

        return answer;
    }

    // 스택으로 풀어야할듯
    public int solution2(int[] ingredient) {
        int answer = 0;

        Stack<Integer> lastInt = new Stack<Integer>();
        int size = ingredient.length;


        return answer;
    }


    public static void main(String[] args) {
        try {
            Lv1_MakeHemburger l = new Lv1_MakeHemburger();

            int[] req = new int[1000000];
            for (int i=0;i< req.length;i++) {
                req[i] = (int)(Math.random()*3)+1;
            }

            int reuslt = l.solution(req);
//            int reuslt = l.solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1});

            System.out.println(reuslt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
