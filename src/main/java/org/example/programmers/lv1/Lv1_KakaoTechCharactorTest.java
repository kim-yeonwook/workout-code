package org.example.programmers.lv1;

import java.util.*;
import java.util.stream.Stream;

public class Lv1_KakaoTechCharactorTest {

    public class test {
        private Indicator firstIndicator;
        private Indicator secodeIndicator;
        private Indicator thirdIndicator;
        private Indicator fourIndicator;

        public test() {
            this.firstIndicator = new Indicator("R", "T");
            this.secodeIndicator = new Indicator("C", "F");
            this.thirdIndicator = new Indicator("J", "M");
            this.fourIndicator = new Indicator("A", "N");
        }

        public void calc(String i, int c) {
            IndicateChoice choice = new IndicateChoice();
            choice.calc(i, c);
            switch (i) {
                case "RT","TR": firstIndicator.plusScore(choice.getIndicatorChoiceResult().getS(), choice.getIndicatorChoiceResult().getI());break;
                case "CF","FC": secodeIndicator.plusScore(choice.getIndicatorChoiceResult().getS(), choice.getIndicatorChoiceResult().getI());break;
                case "JM","MJ": thirdIndicator.plusScore(choice.getIndicatorChoiceResult().getS(), choice.getIndicatorChoiceResult().getI());break;
                case "AN","NA": fourIndicator.plusScore(choice.getIndicatorChoiceResult().getS(), choice.getIndicatorChoiceResult().getI());break;
            }
        }

        public String getIndicatorTypes() {
            StringBuilder sb = new StringBuilder();
            sb.append(firstIndicator.toHighIndicator());
            sb.append(secodeIndicator.toHighIndicator());
            sb.append(thirdIndicator.toHighIndicator());
            sb.append(fourIndicator.toHighIndicator());

            return sb.toString();
        }

        public class IndicateChoice {

            private IndicatorChoiceResult result;

            public void calc(String type, int choice) {
                switch (choice) {
                    case 1: this.result = new IndicatorChoiceResult(String.valueOf(type.charAt(0)), 3) ; break;
                    case 2: this.result = new IndicatorChoiceResult(String.valueOf(type.charAt(0)), 2) ; break;
                    case 3: this.result = new IndicatorChoiceResult(String.valueOf(type.charAt(0)), 1) ; break;
                    case 4: this.result = new IndicatorChoiceResult(String.valueOf(type.charAt(0)), 0) ; break;
                    case 5: this.result = new IndicatorChoiceResult(String.valueOf(type.charAt(1)), 1) ; break;
                    case 6: this.result = new IndicatorChoiceResult(String.valueOf(type.charAt(1)), 2) ; break;
                    case 7: this.result = new IndicatorChoiceResult(String.valueOf(type.charAt(1)), 3) ; break;
                }
            }

            public IndicatorChoiceResult getIndicatorChoiceResult() {
                if (result==null) this.result = new IndicatorChoiceResult("", 0);
                return this.result;
            }

            private class IndicatorChoiceResult {
                private String s;
                private int i;

                IndicatorChoiceResult(String s, int i) {
                    this.s = s;
                    this.i = i;
                }

                public String getS() {
                    return this.s;
                }
                public int getI() {
                    return this.i;
                }
            }
        }


        public class Indicator {

            private Map<String, Integer> integerMap;

            public Indicator(String type1, String type2) {
                if (this.integerMap==null) integerMap = new HashMap<>();
                integerMap.put(type1,0); integerMap.put(type2,0);
            }

            public void plusScore(String type, int score) {
                this.integerMap.put(type, integerMap.getOrDefault(type, 0) + score);
            }

            public String toHighIndicator() {
                Map.Entry<String, Integer> maxEntry = null;
                for (Map.Entry<String, Integer> entry : integerMap.entrySet()) {
                    if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                        maxEntry = entry;
                    } else if (entry.getValue().equals(maxEntry.getValue())&&entry.getKey().charAt(0)<maxEntry.getKey().charAt(0)) {
                        maxEntry = entry;
                    }
                }
                return maxEntry.getKey();
            }
        }

    }

    public String solution(String[] survey, int[] choices) {

        test t = new test();

        int size= survey.length;
        for (int index=0;index<size; index++) {
            System.out.println(survey[index]);
            System.out.println(choices[index]);
            t.calc(survey[index], choices[index]);
        }

        return t.getIndicatorTypes();
    }

    // 다른 사람 풀이
    public String solution2(String[] survey, int[] choices) {
        String answer = "";
        char [][] type = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};
        int [] score = {0, 3, 2, 1, 0, 1, 2, 3};
        HashMap<Character, Integer> point = new HashMap<Character, Integer>();

        // 점수 기록할 배열 초기화 
        for (char[] t : type) {
            point.put(t[0], 0);
            point.put(t[1], 0);
        }

        // 점수 기록 
        for (int idx = 0; idx < choices.length; idx++){
            if(choices[idx] > 4){
                point.put(survey[idx].charAt(1), point.get(survey[idx].charAt(1)) + score[choices[idx]]);
            } else {
                point.put(survey[idx].charAt(0), point.get(survey[idx].charAt(0)) + score[choices[idx]]);
            }
        }

        // 지표 별 점수 비교 후 유형 기입
        for (char[] t : type) {
            answer += (point.get(t[1]) <= point.get(t[0])) ? t[0] : t[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Lv1_KakaoTechCharactorTest l = new Lv1_KakaoTechCharactorTest();

        String s = l.solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5});
        System.out.println(s);
    }
}
