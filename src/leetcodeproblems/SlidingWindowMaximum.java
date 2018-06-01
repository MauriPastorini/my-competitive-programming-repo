package leetcodeproblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    //Using Dequeue 
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }

    //Using Heap
    class Item implements Comparable<Item> {

        int value;
        int pos;

        public Item(int valP, int posP) {
            this.value = valP;
            this.pos = posP;
        }

        @Override
        public int compareTo(Item o) {
            if (o.value > this.value) {
                return 1;
            }
            return -1;
        }
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return null;
        }
        if (nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Item> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            queue.add(new Item(nums[i], i));
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.peek().value;
        for (int i = k; i < nums.length; i++) {
            queue.add(new Item(nums[i], i));
            while (queue.peek().pos <= i - k) {
                queue.poll();
            }
            res[i - k + 1] = queue.peek().value;
        }
        return res;
    }
}
