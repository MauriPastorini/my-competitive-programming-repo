package leetcodeproblems;

public class ProductOfArrayExceptSelf {

    public static void test() {
        int[] nums = {1, 2, 3, 4};
        nums = productExceptSelf(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] res = new int[nums.length];

        int countBefore = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            res[i] = prev * res[i - 1];
        }
        int aux = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int prox = nums[i + 1];
            res[i] = res[i] * prox * aux;
            aux = prox * aux;
        }
        return res;
    }

    public static int[] productExceptSelf_Withcomplexityspace(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] prevsStart = new int[nums.length];
        int[] proxEnd = new int[nums.length];

        int[] res = new int[nums.length];

        int countBefore = 1;
        prevsStart[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int prev = nums[i - 1];
            prevsStart[i] = prev * prevsStart[i - 1];
        }
        proxEnd[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int prox = nums[i + 1];
            proxEnd[i] = prox * proxEnd[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = prevsStart[i] * proxEnd[i];
        }
        return res;
    }
    static int[] res;

    public static int[] productExceptSelf_WithRecursion(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        res = nums;
        recursion(1, 0, 1);
        return res;
    }

    private static int recursion(int prev, int pos, int val) {
        if (pos >= res.length) {
            return 1;
        }
        int actual = res[pos];
        int prox = recursion(prev * val, pos + 1, actual);
        res[pos] = prev * prox * val;
        return prox * actual;
    }
}
