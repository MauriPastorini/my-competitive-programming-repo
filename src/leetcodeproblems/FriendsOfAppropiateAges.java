/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.Arrays;

/**
 *
 * @author Mauri-Laptop
 */
public class FriendsOfAppropiateAges {

    public void test() {
//        int[] ages = {8, 85, 24, 85, 69};
//        int[] ages = {37,58,116,68,55};
        int[] ages = {16, 17, 18};
//        int[] ages = {16, 16};
//        int[] ages = {20, 30, 100, 110, 120};
        System.out.println(numFriendRequests(ages));
    }

    public int numFriendRequests(int[] ages) {
        int[] a = new int[121];
        int res = 0;
        for (int age : ages) {
            ++a[age];
        }
        for (int i = 15; i <= 120; ++i) {
            for (int j = (int) (0.5 * i + 8); j <= i; ++j) {
                res += (i == j) ? a[j] * (a[i] - 1) : a[j] * a[i];
            }
        }
        return res;
    }

    public int numFriendRequests2(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        int cant = 0;
        Arrays.sort(ages, 0, ages.length);

        int actual = ages[0];
        int sameAge = 0;

        for (int i = 1; i <= ages.length; i++) {
            if (i == ages.length && actual > 0.5 * actual + 7) {
                cant += sameAge * (sameAge + 1) / 2;
                break;
            }
            if (ages[i] == actual && actual > 0.5 * actual + 7) {
                sameAge++;
            } else {
                cant += sameAge * (sameAge + 1) / 2;
                actual = ages[i];
                sameAge = 0;
            }
        }

        for (int i = 0; i < ages.length; i++) {
            int start = i;
            int end = ages.length - 1;

            while (start < end) {
                int mid = start + (end - start + 1) / 2;
                if (ages[i] <= ages[mid] * 0.5 + 7) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            }
            int cantFriends = start - i;
            cant += cantFriends;
        }

//        int i = 0;
//        while (i < ages.length) {
//            int j;
//            int ageB = ages[i];
//            int cantFriends = 0;
//            for (j = i + 1; j < ages.length; j++) {
//                int ageA = ages[j];
//                if (ageB <= 0.5 * ageA + 7) {
//                    break;
//                } else {
//                    cantFriends++;
//                }
//            }
//            cant += cantFriends * (cantFriends + 1) / 2;
//            if (i == j - 1) {
//                i++;
//            } else {
//                i = j - 1;
//            }
//        }
        return cant;
    }

//    public int numFriendRequests(int[] ages) {
//        int cant = 0;
//        for (int i = 0; i < ages.length; i++) {
//            for (int j = 0; j < ages.length; j++) {
//                if (i != j) {
//                    int ageA = ages[i];
//                    int ageB = ages[j];
//                    if (ageB <= 0.5 * ageA + 7 || ageB > ageA || (ageB > 100 && ageA < 100)) {
//                        continue;
//                    } else {
//                        cant++;
//                    }
//                }
//            }
//        }
//        return cant;
//    }
}
