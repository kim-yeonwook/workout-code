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

    private static final int _1 = 1;
    private static final int _2 = 2;
    private static final int _3 = 3;

    // 스택으로 풀어야할듯
    public int solution2(int[] ingredient) {
        int answer = 0;

        Stack<Integer> lastInt = new Stack<Integer>();
        for (int in : ingredient) {
            lastInt.push(in);

            if (lastInt.size()<4) continue;

            int FourInt = lastInt.pop();
            if (FourInt==_1&&lastInt.peek()==_3) {
                int thirdInt = lastInt.pop();
                if (thirdInt==_3&&lastInt.peek()==_2){
                    int secondInt = lastInt.pop();
                    if (secondInt==_2&&lastInt.peek()==_1) {
                        lastInt.pop();
                        answer++;
                    } else {
                        lastInt.push(secondInt);
                        lastInt.push(thirdInt);
                        lastInt.push(FourInt);
                    }
                } else {
                    lastInt.push(thirdInt);
                    lastInt.push(FourInt);
                }
            } else {
                lastInt.push(FourInt);
            }
        }
        return answer;
    }

    // 다른 사람 풀이 stack사용없이 덮어씌운느 형식으로
    public int solution3(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int sp = 0;
        int answer = 0;
        for (int i : ingredient) {
            stack[sp++] = i;
            if (sp >= 4 && stack[sp - 1] == 1
                    && stack[sp - 2] == 3
                    && stack[sp - 3] == 2
                    && stack[sp - 4] == 1) {
                sp -= 4;
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        try {
            Lv1_MakeHemburger l = new Lv1_MakeHemburger();

            int[] req = new int[1000000];
            for (int i=0;i< req.length;i++) {
                req[i] = (int)(Math.random()*3)+1;
            }

            int reuslt = l.solution2(req);
//            int reuslt = l.solution2(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1});

            System.out.println(reuslt);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
