package org.example.programmers.lv1;

/**
 *  정수 n하위 수 중 짝수인 수 저하기
 */
public class Lv1_EvenNumverPlus_1 {

    public int solution(int n) {
        int answer = 0;

        for (int i=2;i<=n;i+=2) {
            answer+=i;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lv1_EvenNumverPlus_1 l = new Lv1_EvenNumverPlus_1();
        int num_1 = l.solution(20);

        System.out.println(num_1);

    }
 }
