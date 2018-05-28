package hackerRankproblems.Statistics;

import java.util.Arrays;
import java.util.Scanner;

public class InterquartileRange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int nAux = N;
        int[] numsAux = new int[N];
        int[] frequencies = new int[N];
        for (int i = 0; i < N; i++) {
            numsAux[i] = in.nextInt();
        }
        int totalArraySpace = 0;
        for (int i = 0; i < N; i++) {
            frequencies[i] = in.nextInt();
            totalArraySpace += frequencies[i];
        }
        int[] nums = new int[totalArraySpace];
        int pos = 0;
        for (int i = 0; i < numsAux.length; i++) {
            for (int j = 0; j < frequencies[i]; j++) {
                nums[pos++] = numsAux[i];
            }
        }
        Arrays.sort(nums,0,nums.length);
        double q1 = calculateMedian(0, nums.length / 2 - 1, nums);
        double q3;
        if (nums.length % 2 == 0) {
            q3 = calculateMedian(nums.length / 2, nums.length - 1, nums);
        } else {
            q3 = calculateMedian(nums.length / 2 + 1, nums.length - 1, nums);
        }
        System.out.println(Math.round((q3 - q1) * 10) / 10.0);

    }

    private static double calculateMedian(int start, int end, int[] nums) {
        int size = end - start + 1;
        int mid = start + size / 2;
        if (size % 2 == 0) {
            return (nums[mid] + nums[mid - 1]) / 2.0;
        } else {
            return nums[mid];
        }
    }
}
