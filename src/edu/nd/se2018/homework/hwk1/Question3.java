package edu.nd.se2018.homework.hwk1;


import java.util.ArrayList;
import java.util.List;

public class Question3 {

    public Question3() {
    }

    public int getMirrorCount(int[] numbers) {
        int res = 0;
        for (int i = 0; i < numbers.length; i++) {
            ArrayList tempList = new ArrayList();
            for (int j = 0; j < numbers.length - i; j++) {
                tempList.add(numbers[i + j]);
                if (isMirrow(tempList)) {
                    int tempRes = tempList.size();
                    if (tempRes > res) {
                        res = tempRes;
                    }
                }
            }
        }
        System.out.println(res);
        return res;
    }

    public boolean isMirrow(List numbers) {
        for (int i = 0; i < Math.floor(numbers.size() / 2); i++) {
            if (numbers.get(i) != numbers.get(numbers.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

