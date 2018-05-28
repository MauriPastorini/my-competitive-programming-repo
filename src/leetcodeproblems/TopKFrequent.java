/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/**
 *
 * @author Mauri-Laptop
 */
public class TopKFrequent {

    void test() {
        int[] nums = {1, 2, 1, 2, 1, 3};
        System.out.println(topKFrequent(nums, 2));

    }

    class Node implements Comparable<Node> {

        Integer key;
        Integer value;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if (o.value == this.value) {
                return 1;
            } else if (o.value > this.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public List<Integer> topKFrequent_my(int[] nums, int k) {
        if (nums == null) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
//                int can = map.get(nums[i]);
//                can++;
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        TreeSet<Node> elems = new TreeSet<>();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Node x = new Node((Integer) pair.getKey(), (Integer) pair.getValue());
            elems.add(x);
        }
        List<Integer> res = new ArrayList<>();
        for (Node i : elems) {
            if (k == 0) {
                break;
            }
            res.add(i.key);
            k--;
        }
        return res;
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (cnt.containsKey(nums[i])) {
                cnt.put(key, cnt.get(key) + 1);
            } else {
                cnt.put(key, 1);
            }
        }

        List<Integer>[] lists = new ArrayList[nums.length + 1];
        for (int key : cnt.keySet()) {
            int val = cnt.get(key);
            if (lists[val] == null) {
                List<Integer> n = new ArrayList<Integer>();
                n.add(key);
                lists[val] = n;
            } else {
                List<Integer> n = lists[val];
                n.add(key);
                lists[val] = n;
            }
        }

        List<Integer> res = new ArrayList<Integer>();
        for (int i = lists.length - 1; i >= 0 && res.size() < k; i--) {
            if (lists[i] != null) {
                List<Integer> l = lists[i];
                res.addAll(l);
            }
        }

        return res;
    }
}
