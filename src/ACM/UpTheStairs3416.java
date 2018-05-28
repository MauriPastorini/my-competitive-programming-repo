package ACM;

/* Sample solution to Up the Stairs (nwerc05)
 * By Mikael Goldmann
 *
 * Compute how many boxes can be delivered in a given time, and
 * use binary search to determine the smallest time needed to
 * deliver all boxes.
 */
import java.util.*;

public class UpTheStairs3416 {

    public static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int N = stdin.nextInt();
        while (N-- > 0) {
            solve();
        }
    }

    static void solve() throws Exception {
        int N = stdin.nextInt();
        int F = stdin.nextInt();
        int B = stdin.nextInt();
        boolean[] b = new boolean[N];
        int[] f = new int[N];
        for (int i = 0; i < N; ++i) {
            f[i] = stdin.nextInt();
            b[i] = stdin.nextInt() == 1;
        }
        long lo = 0;
        // Max time needed if one person starts at 0 with a box
        // Then first F minutes to deliver that box. Then 2F minutes for
        // each of the B boxes
        long hi = F + 2 * B * F;
        while (lo < hi - 1) {
            long m = (lo + hi) / 2;
            if (numDelivered(b, f, m, F) >= B) {
                hi = m;
            } else {
                lo = m;
            }
        }
        System.out.println(hi);
    }

    static long numDelivered(boolean[] b, int[] f, long t, int F) {
        long cnt = 0;
        int N = b.length;
        for (int i = 0; i < N; ++i) {
            long t1 = t;
            if (b[i]) {
                t1 -= (F - f[i]);
            } else {
                t1 += (F - f[i]);
            }
            cnt += t1 / (2 * F);
        }
        return cnt;
    }
}
