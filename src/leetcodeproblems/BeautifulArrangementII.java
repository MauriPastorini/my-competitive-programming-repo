package leetcodeproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BeautifulArrangementII {

    public void test() {
        int[] elme = constructArray(3, 2);
        System.out.println(Arrays.toString(elme));
    }

    public int[] constructArray(int n, int k) {
        return null;
    }

    //Backtracking TLE
    List<Integer> res;

    public int[] constructArray2(int n, int k) {
        List<Integer> listActual = new ArrayList<>();
        res = new ArrayList<>();
        backtracking(1, n, k, listActual);

        int[] result = new int[res.size()];
        int pos = 0;
        for (int i : res) {
            result[pos++] = i;
        }
        return result;
    }

    private void backtracking(int i, int n, int k, List<Integer> setActual) {
        if (res.size() != 0) {
            return;
        }
        if (i > n) {
            if (isBeatufilArrangement(setActual, k)) {
                res = new ArrayList<>(setActual);
                return;
            }
        }
        for (int j = 1; j <= n; j++) {
            if (!setActual.contains(j)) {
                setActual.add(j);
                backtracking(i + 1, n, k, setActual);
                setActual.remove(new Integer(j));
            }
        }
    }

    private boolean isBeatufilArrangement(List<Integer> res, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < res.size(); i++) {
            set.add(Math.abs(res.get(i - 1) - res.get(i)));
        }
        return set.size() == k;
    }
}
