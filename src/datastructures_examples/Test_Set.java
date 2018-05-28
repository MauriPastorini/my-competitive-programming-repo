package datastructures_examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test_Set {

    private void SET_OPERATIONS() {
        Set<Integer> a = new TreeSet<Integer>(Arrays.asList(new Integer[]{0, 2, 4, 5, 6, 8, 10}));
        Set<Integer> b = new TreeSet<Integer>(Arrays.asList(new Integer[]{5, 6, 7, 8, 9, 10}));

        //union
        Set<Integer> c = new TreeSet<Integer>(a);
        c.addAll(b);
        System.out.println(c);

        //intersection
        Set<Integer> d = new TreeSet<Integer>(a);
        d.retainAll(b);
        System.out.println(d);

        //difference
        Set<Integer> e = new TreeSet<Integer>(a);
        e.removeAll(b);
        System.out.println(e);

        //reverse
        List<Integer> list = new ArrayList<Integer>(a);
        java.util.Collections.reverse(list);
        System.out.println(list);
    }

    private void SET_ITERATOR() {
        Set<Integer> s = new HashSet<>(); //contains your Integers
        Set<Integer> temp = new HashSet<Integer>(); // OR tree set
        for (Integer i : s) {
            temp.add(i + 1);
        }
        s.clear();
        s.addAll(temp);
    }

}
