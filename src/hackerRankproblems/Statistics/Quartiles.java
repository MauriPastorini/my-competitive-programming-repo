package hackerRankproblems.Statistics;

import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = in.nextInt();
        int[] nums = new int[cant];
        for (int i = 0; i < cant; i++) {
            nums[i] = in.nextInt();
        }

        Arrays.sort(nums, 0, nums.length);

        int lastPos = nums.length - 1;
        int q2 = getMedian(nums, 0, lastPos);
        int aux = 0;
        if(!isEven(0, lastPos))aux=1;
        int q1 = getMedian(nums, 0, lastPos / 2 - aux);
        int q3 = getMedian(nums, lastPos - lastPos / 2 + aux, lastPos);

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
    }

    private static int getMedian(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        boolean isEven = isEven(start, end);
        if (isEven) {
            return (nums[mid] + nums[mid + 1]) / 2;
        } else {
            return (nums[mid]);
        }
    }

    private static boolean isEven(int start, int end) {
        return (end - start) % 2 == 1;
    }
}
