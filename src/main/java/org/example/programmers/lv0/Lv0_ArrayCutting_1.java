package org.example.programmers.lv0;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Lv0_ArrayCutting_1 {

    public int[] solution(int[] numbers, int num1, int num2) {
        int size = num2-num1+1;
        int[] answer = new int[size];
        System.arraycopy(numbers, num1, answer, 0, size);
        return answer;
    }

    public int[] solution2(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2+1);
    }
 
    // 다른 사람 풀이 rangeClose는 끝값 포함해서 리턴 
    public int[] solution3(int[] numbers, int num1, int num2) {
        return IntStream.rangeClosed(num1, num2).map(i -> numbers[i]).toArray();
    }

    public static void main(String[] args) {
        Lv0_ArrayCutting_1 l = new Lv0_ArrayCutting_1();
        int[] array = l.solution(new int[] {1, 2, 3, 4, 5}, 1, 3);

        System.out.println("Use System Array Copy");
        for(int a : array) {
            System.out.print(a + " ");
        }

        System.out.println();

        int[] array2 = l.solution2(new int[] {1, 2, 3, 4, 5}, 1, 3);
        System.out.println("Use Arrays Range Copy");
        for(int a : array2) {
            System.out.print(a + " ");
        }
    }

}
