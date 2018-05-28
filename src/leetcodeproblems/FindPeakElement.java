package leetcodeproblems;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            int before = mid - 1 == -1 ? Integer.MIN_VALUE : nums[mid - 1];
            int next = mid + 1 == nums.length ? Integer.MIN_VALUE : nums[mid + 1];
            if (nums[mid] > before && nums[mid] > next) {
                return mid;
            }
            if (before > next) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int[] nums2 = {3, 2, 1};
        System.out.println(findPeakElement(nums2));
    }
}
