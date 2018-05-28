package leetcodeproblems;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public void test() {
        List<Integer> res = splitIntoFibonacci("123456579");
        for (Integer re : res) {
            System.out.println(re);
        }
    }

    //Backtracking
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, 0);
        return ans;
    }

    public boolean helper(String s, List<Integer> ans, int idx) {
        if (idx == s.length() && ans.size() >= 3) {
            return true;
        }
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(idx) == '0' && i > idx) {
                break;
            }
            long num = Long.parseLong(s.substring(idx, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = ans.size();
            // early termination
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (helper(s, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    //Brute force
    public List<Integer> splitIntoFibonacci3(String S) {
        int N = S.length();
        for (int i = 0; i < Math.min(10, N); ++i) {
            if (S.charAt(0) == '0' && i > 0) {
                break;
            }
            long a = Long.valueOf(S.substring(0, i + 1));
            if (a >= Integer.MAX_VALUE) {
                break;
            }

            search:
            for (int j = i + 1; j < Math.min(i + 10, N); ++j) {
                if (S.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }
                long b = Long.valueOf(S.substring(i + 1, j + 1));
                if (b >= Integer.MAX_VALUE) {
                    break;
                }

                List<Integer> fib = new ArrayList();
                fib.add((int) a);
                fib.add((int) b);

                int k = j + 1;
                while (k < N) {
                    long nxt = fib.get(fib.size() - 2) + fib.get(fib.size() - 1);
                    String nxtS = String.valueOf(nxt);

                    if (nxt <= Integer.MAX_VALUE && S.substring(k).startsWith(nxtS)) {
                        k += nxtS.length();
                        fib.add((int) nxt);
                    } else {
                        continue search;
                    }
                }
                if (fib.size() >= 3) {
                    return fib;
                }
            }
        }

        return new ArrayList<Integer>();
    }

    //TLE And Wrong answer
    boolean found = false;
    List<Integer> finalRes = new ArrayList<>();

    public List<Integer> splitIntoFibonacci2(String S) {
        char[] values = S.toCharArray();

        List<Integer> lst = new ArrayList<>();
        for (char value : values) {
            lst.add(Integer.parseInt(value + ""));
        }
        found = false;
        finalRes = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        backTracking2(0, lst, res);
        return finalRes;
    }

    private void backTracking2(int pos, List<Integer> lst, List<Integer> res) {
        if (found) {
            return;
        }
        if (pos >= lst.size()) {
            if (isResCorrect(res)) {
                found = true;
                copyLst(res);
            }
            return;
        }
        int N = res.size();
        if (N > 2) {
            int first = res.get(N - 3);
            int second = res.get(N - 2);
            int finalI = res.get(N - 1);
            if (first + second < finalI) {
                return;
            }
        }
        if (lst.get(pos) != 0) {
            for (int i = 1; i < lst.size() - pos + 1; i++) {
                int val = joinLst(pos, i, lst);
                res.add(val);
                backTracking2(pos + i, lst, res);
                res.remove(res.size() - 1);
            }
        } else {
            res.add(0);
            backTracking2(pos + 1, lst, res);
            res.remove(res.size() - 1);
        }
    }

    private int joinLst(int pos, int i, List<Integer> lst) {
        int sum = 0;
        double digit = Math.pow(10, i - 1);
        for (int j = 0; j < i; j++) {
            sum += lst.get(pos + j) * digit;
            digit /= 10;
        }
        return sum;
    }

    private void copyLst(List<Integer> res) {
        for (Integer re : res) {
            int i = re;
            finalRes.add(i);
        }
    }

    private boolean isResCorrect(List<Integer> res) {
        if (res.size() < 3) {
            return false;
        }
        for (int i = 2; i < res.size(); i++) {
            int first = res.get(i - 2);
            int second = res.get(i - 1);
            int finalI = res.get(i);
            if (first + second != finalI) {
                return false;
            }
        }
        return true;
    }
}
