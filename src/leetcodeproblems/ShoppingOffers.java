/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author Mauri-Laptop
 */
public class ShoppingOffers {

    public void test() {
        List<Integer> price = new ArrayList<>();
        price.add(2);
        price.add(3);
        price.add(4);

        List<List<Integer>> special = new ArrayList<>();
        List<Integer> special1 = new ArrayList<>();
        special1.add(1);
        special1.add(1);
        special1.add(0);
        special1.add(4);
        List<Integer> special2 = new ArrayList<>();
        special2.add(2);
        special2.add(2);
        special2.add(1);
        special2.add(9);
        special.add(special1);
        special.add(special2);

        List<Integer> needs = new ArrayList<>();
        needs.add(1);
        needs.add(2);
        needs.add(1);

        System.out.println(shoppingOffers_MAURI(price, special, needs));
    }

    public int shoppingOffers(List< Integer> price, List< List< Integer>> special, List< Integer> needs) {
        return shopping(price, special, needs);
    }

    public int shopping(List< Integer> price, List< List< Integer>> special, List< Integer> needs) {
        int j = 0, res = dot(needs, price);
        for (List< Integer> s : special) {
            ArrayList< Integer> clone = new ArrayList<>(needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0) {
                    break;
                }
                clone.set(j, diff);
            }
            if (j == needs.size()) {
                res = Math.min(res, s.get(j) + shopping(price, special, clone));
            }
        }
        return res;
    }

    public int dot(List< Integer> a, List< Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

    /*
    La implementacion de abajo es mia y pasa las pruebas. Es un poco mas larga y no tan prolija como las propuestas arriba. Pero fue lo qe salio :)
     */
    public int shoppingOffers_MAURI(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price.size() == 0 || needs.size() == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += needs.get(i) * price.get(i);
        }
        Map<List<Integer>, Integer> map = new HashMap<>();
        return rec(price, special, total, needs, map);
    }

    private int rec(List<Integer> price, List<List<Integer>> special, int total, List<Integer> actualNeeds, Map<List<Integer>, Integer> map) {
        if (map.containsKey(actualNeeds)) {
            return map.get(actualNeeds);
        }
        int bestTotal = total;
        for (int i = 0; i < special.size(); i++) {

            Pair<List<Integer>, Integer> actualNeedsUpdateForSale = actualNeedsUpdated(special.get(i), actualNeeds, price, total);
            if (actualNeedsUpdateForSale != null) {
                int recTotal = rec(price, special, actualNeedsUpdateForSale.getValue(), actualNeedsUpdateForSale.getKey(), map);
                if (recTotal < bestTotal) {
                    bestTotal = recTotal;
                }
            }
        }
        map.put(actualNeeds, bestTotal);
        return bestTotal;
    }

    private Pair<List<Integer>, Integer> actualNeedsUpdated(List<Integer> sale, List<Integer> actualNeeds, List<Integer> prices, int total) {
        List<Integer> res = new ArrayList<>();
        int totalWithSale = total;
        for (int i = 0; i < actualNeeds.size(); i++) {
            if (sale.get(i) > actualNeeds.get(i)) {
                return null;
            } else {
                res.add(actualNeeds.get(i) - sale.get(i));
                totalWithSale = totalWithSale - sale.get(i) * prices.get(i);
            }
        }
        totalWithSale = totalWithSale + sale.get(sale.size() - 1);
        if (totalWithSale > total) {
            return null;
        } else {
            return new Pair<>(res, totalWithSale);
        }
    }
}
