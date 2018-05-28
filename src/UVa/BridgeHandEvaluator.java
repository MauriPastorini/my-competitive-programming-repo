package UVa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HandSuit implements Comparable<HandSuit> {

    int cant;
    int k;
    int q;
    int j;
    int a;
    String letter;
    boolean isStopped;

    @Override
    public int compareTo(HandSuit o) {
        if (this.letter.equals("S")) {
            return -1;
        }
        if (this.letter.equals("C")) {
            return 1;
        }
        if (this.letter.equals("H")) {
            if (o.letter.equals("S")) {
                return 1;
            } else {
                return -1;
            }
        }
        if (this.letter.equals("D")) {
            if (o.letter.equals("S") || o.letter.equals("H")) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}

public class BridgeHandEvaluator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] parm = in.nextLine().split(" ");
            HandSuit s = new HandSuit();
            s.letter = "S";
            HandSuit d = new HandSuit();
            d.letter = "D";
            HandSuit c = new HandSuit();
            c.letter = "C";
            HandSuit h = new HandSuit();
            h.letter = "H";
            Map<String, HandSuit> map = new HashMap<>();
            map.put("S", s);
            map.put("H", h);
            map.put("D", d);
            map.put("C", c);
            int k = 0;
            int q = 0;
            int j = 0;
            int sum = 0;
            for (String p : parm) {
                char c1 = p.charAt(0);
                char c2 = p.charAt(1);
                HandSuit hand = map.get(c2 + "");
                hand.cant++;
                switch (c1) {
                    case 'A':
                        sum += 4;
                        hand.a++;
                        break;
                    case 'K':
                        sum += 3;
                        hand.k++;
                        break;
                    case 'Q':
                        sum += 2;
                        hand.q++;
                        break;
                    case 'J':
                        sum += 1;
                        hand.j++;
                        break;
                }
            }
            HandSuit max = new HandSuit();
            max.letter = "C";
            int cant567 = 0;
            for (HandSuit i : map.values()) {
                if (i.cant == 2) {
                    sum++;
                    cant567++;
                }
                if (i.cant == 0 || i.cant == 1) {
                    sum += 2;
                    cant567 += 2;
                }
                if (i.k == 1 && i.cant == 1) {
                    sum--;
                }
                if (i.q == 1 && i.cant <= 2) {
                    sum--;
                }
                if (i.j == 1 && i.cant <= 3) {
                    sum--;
                }
                if (i.a > 0 || (i.k > 0 && i.cant > 1) || (i.q > 0 && i.cant > 2)) {
                    i.isStopped = true;
                }
                if (max.cant <= i.cant) {
                    if (max.cant == i.cant) {
                        if (max.compareTo(i) > 0) {
                            max = i;
                        }
                    } else {
                        max = i;
                    }
                }
            }

            String status = "";
            if (sum < 14) {
                status = "PASS";
            }

            if (sum >= 14) {
                status = "BID " + max.letter;
                if (sum - cant567 >= 16) {
                    boolean noTrump = true;
                    for (HandSuit i : map.values()) {
                        noTrump &= i.isStopped;
                    }
                    if (noTrump) {
                        status = ("BID NO-TRUMP");
                    }
                }
            }
            System.out.println(status);
        }
    }
}
