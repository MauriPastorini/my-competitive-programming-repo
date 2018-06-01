//NOT SOLVER: RUNTIME ERROR DUE TO MEMOIZATION(?)

package ACM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class KeepItEnergized13014 {

    static class Shop {

        long energy;
        long cost;

        public Shop(long energy, long cost) {
            this.energy = energy;
            this.cost = cost;
        }
    }

    static class Level {

        List<Shop> shops;
        long energyNeccesary;

        public Level(long energyNeccesary) {
            this.shops = new ArrayList<>();
            this.energyNeccesary = energyNeccesary;
        }
    }

    static class ItemMemo {

        long level;
        long energy;

        public ItemMemo(long level, long energy) {
            this.level = level;
            this.energy = energy;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ItemMemo other = (ItemMemo) obj;
            if (this.level != other.level) {
                return false;
            }
            if (this.energy != other.energy) {
                return false;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int numLevels = in.nextInt();
            int numShops = in.nextInt();
            if (numLevels == 0) {
                for (int i = 0; i < numShops; i++) {
                    in.nextLine();
                }
                System.out.println("-1");
                continue;
            }
            Level[] levels = new Level[numLevels + 1];
            for (int i = 1; i < levels.length; i++) {
                levels[i] = new Level(in.nextInt());
            }
            for (int i = 0; i < numShops; i++) {
                int lev = in.nextInt();
                levels[lev].shops.add(new Shop(in.nextInt(), in.nextInt()));
            }
            long min = calculateMin(levels, 1, 0, new HashMap<>());
            if (min == Integer.MAX_VALUE) {
                System.out.println("-1");
            } else {
                System.out.println(min);
            }
        }
    }

    private static long calculateMin(Level[] levels, int actualLevel, long actualEnery, HashMap<ItemMemo, Long> map) {
        if (actualEnery < 0) {
            return Integer.MAX_VALUE;
        }
        if (actualLevel >= levels.length) {
            return 0;
        }
//        ItemMemo item = new ItemMemo(actualLevel, actualEnery);
//        if (map.containsKey(item)) {
//            return map.get(item);
//        }
        long min = Integer.MAX_VALUE;
        long eneryLevel = levels[actualLevel].energyNeccesary;
        for (Shop shop : levels[actualLevel].shops) {
            long minWithBuyLevelShopAux = (long) calculateMin(levels, actualLevel + 1, shop.energy - eneryLevel, map) + (long) shop.cost;
            long minWithBuyLevelShop;
            if (minWithBuyLevelShopAux > Integer.MAX_VALUE) {
                minWithBuyLevelShop = Integer.MAX_VALUE;
            } else {
                minWithBuyLevelShop = minWithBuyLevelShopAux;
            }
            min = Long.min(min, minWithBuyLevelShop);
        }
        long withoutShopping = calculateMin(levels, actualLevel + 1, actualEnery - eneryLevel, map);
        min = Long.min(min, withoutShopping);
//        map.put(item, min);
        return min;
    }
}
