package com.titanic.javatest.tossTest.sendmoney;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SendMoney {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kim = br.readLine().split(" ");
        String[] lee = br.readLine().split(" ");

        List<Integer> kims = Arrays.stream(kim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> lees = Arrays.stream(lee)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int save = 0;

        List<Integer> answers = new ArrayList<>();

        for (int i = 0; i < kim.length; i++) {
            int sub = kims.get(i) - lees.get(i);
            if (sub >= 0) {
                int answer = sub + save;
                if (answer < 0) {
                    answers.add(0);
                    save = answer;
                } else {
                    answers.add(answer);
                    save = 0;
                }
            } else {
                save += sub;
                answers.add(0);
            }
        }

        answers.forEach(System.out::println);
    }
}
