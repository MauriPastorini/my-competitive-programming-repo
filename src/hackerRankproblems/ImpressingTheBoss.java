/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerRankproblems;

/**
 *
 * @author Mauri-Laptop
 */
public class ImpressingTheBoss {

    void test() {
        int[] el = {1906, 1906, 1196, 1906};
        System.out.println(canModify(el));
    }

    String canModify(int[] a) {
        if (a.length == 0) {
            return "NO";
        }
        int[] b = a.clone();
        int n = b[0];
        boolean more = false;
        for (int i = 1; i < b.length; i++) {
            if (b[i] < n) {
                int[] test1 = b.clone();
                test1[i] = n;
                boolean re1 = checkIfCan(test1);
                if (!re1) {
                    int[] test2 = b.clone();
                    test2[i - 1] = b[i];
                    if (checkIfCan(test2)) {
                        return "YES";
                    } else {
                        return "NO";
                    }
                }
            }
            n = b[i];
        }
        return "YES";
    }

    private boolean checkIfCan(int[] test2) {
        for (int i = 1; i < test2.length; i++) {
            if (test2[i] < test2[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
