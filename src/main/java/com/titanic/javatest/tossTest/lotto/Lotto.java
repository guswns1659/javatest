package com.titanic.javatest.tossTest.lotto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        boolean flag = true;

        if(inputs.length != 6) {
            flag = false;
        }

        for (String each : inputs) {
            int number = Integer.parseInt(each);
            if (!(0 < number && number < 46)) {
                if (flag) {
                    flag = false;
                }
                break;
            }
        }

        for (int i = 0; i < inputs.length; i++) {
            for (int j = 0; j < inputs.length; j++) {
                if (i == j) {
                    continue;
                }
                if (inputs[i].equals(inputs[j])) {
                    if (flag) {
                        flag = false;
                    }
                    break;
                }
            }
        }

        List<Integer> realLottos = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> copyLottos = new ArrayList<>(realLottos);

        Collections.sort(realLottos);

        for (int i = 0; i < realLottos.size(); i++) {
            if (!(realLottos.get(i).equals(copyLottos.get(i)))) {
                if (flag) {
                    flag = false;
                }
                break;
            }
        }


        System.out.println(flag);
    }
}
