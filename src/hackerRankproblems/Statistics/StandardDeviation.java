package hackerRankproblems.Statistics;

import java.util.Scanner;

public class StandardDeviation {

    public static void main(String[] args) {
        System.out.println(5 - 0.5);
        Scanner in = new Scanner(System.in);
        int cant = in.nextInt();
        int[] nums = new int[cant];
        for (int i = 0; i < cant; i++) {
            nums[i] = in.nextInt();
        }
        double mean = calculateMean(nums);
        double sumSquaredDistance = calculateScuaredDistanceFromMean(nums, mean);
        double standardDeviation = Math.sqrt(sumSquaredDistance / cant);
        System.out.println(Math.round(standardDeviation * 10) / 10.0);

    }

    private static double calculateMean(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum / nums.length;
    }

    private static double calculateScuaredDistanceFromMean(int[] nums, double mean) {
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            double num = nums[i];
            sum += Math.pow(num - mean, 2);
        }
        return sum;
    }

}
