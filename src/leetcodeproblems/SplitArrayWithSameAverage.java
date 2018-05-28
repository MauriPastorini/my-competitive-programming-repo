package leetcodeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SplitArrayWithSameAverage {

    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] nums = {6, 8, 18, 3, 1};
//        int[] nums = {2, 0, 5, 6, 16, 12, 15, 12, 4};
//        int[] nums = {18, 0, 16, 2};
//        int[] nums = {0, 13, 13, 7, 5, 0, 10, 19, 5};
        System.out.println(splitArraySameAverage(nums));
    }

    class Item {

        int i;
        int j;

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 29 * hash + this.i;
            hash = 29 * hash + this.j;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            Item objC = (Item) obj;
            if (this.i == objC.i && this.j == objC.j) {
                return true;
            }
            return false;
        }

        public Item(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        if (A.length == 1) {
            return false;
        }
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        double limit = sum / (double) A.length;
        found = false;
        int pos = 0;
        HashMap<Double, Double> map = new HashMap<>();
        rec(map, A.length - 1, limit, limit, A);
        return found;
    }

    private void rec(HashMap<Double, Double> map, int i, double j, double limit, int[] A) {
        if (map.containsKey(1)) {

        }

    }
    //TLE
    boolean found = false;

    public boolean splitArraySameAverage2(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        if (A.length == 1) {
            return false;
        }
        int sum = 0;
        for (int num : A) {
            sum += num;
        }
        double limit = sum / (double) A.length;
        found = false;
        backTracking(0, A, limit, 0, new ArrayList<>());
        return found;
    }

    private void backTracking(int i, int[] A, double limit, int sumActual, List<Integer> set) {
        if (i >= A.length) {
            return;
        }
        double prom = 0;
        if (set.size() != 0) {
            prom = sumActual / (double) set.size();
        }
        if (prom == limit) {
            found = true;
        }
        set.add(A[i]);
        backTracking(i + 1, A, limit, sumActual + A[i], set);
        set.remove(new Integer(A[i]));
        backTracking(i + 1, A, limit, sumActual, set);
    }

}
