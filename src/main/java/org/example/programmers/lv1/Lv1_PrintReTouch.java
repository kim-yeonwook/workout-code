package org.example.programmers.lv1;

public class Lv1_PrintReTouch {
    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int lastPoint = 0;
        for (int s : section) {
            if (lastPoint<=s) {
                answer++;
                lastPoint=s+m;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        try {

            Lv1_PrintReTouch p = new Lv1_PrintReTouch();
            int a = p.solution(8, 4, new int[] {2,3,6});
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
