package leetcodeproblems;

import java.util.HashSet;
import java.util.Set;

public class BeautifulArrangement {

    public void test() {
        System.out.println(countArrangement(2));
    }

    int cant;

    public int countArrangement(int N) {
        cant = 0;
        Set<Integer> set = new HashSet<>();
        backtracking(1, N, set);
        return cant;
    }

    private void backtracking(int i, int N, Set<Integer> set) {
        if (i > N) {
            cant++;
        }
        for (int j = 1; j <= N; j++) {
            if (!set.contains(j) && isItemBeatuful(i, j)) {
                set.add(j);
                backtracking(i + 1, N, set);
                set.remove(j);
            }
        }
    }

    private boolean isItemBeatuful(int i, int j) {
        if (i % j == 0) {
            return true;
        }
        if (j % i == 0) {
            return true;
        }
        return false;
    }
}
