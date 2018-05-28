/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

/**
 *
 * @author Mauri-Laptop
 */
public class RectangleOverlap {

    public void test() {
//        int[] rec1 = {7, 8, 13, 15};
//        int[] rec2 = {10, 8, 12, 20};
        int[] rec1 = {0, 0, 1, 1};
        int[] rec2 = {1, 0, 2, 1};
//        int[] rec1 = {0, 0, 2, 2};
//        int[] rec2 = {1, 1, 3, 3};
        System.out.println(isRectangleOverlap(rec1, rec2));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1 == null || rec2 == null) {
            return false;
        }
        int x11 = rec1[0];
        int x12 = rec1[2];

        int x21 = rec2[0];
        int x22 = rec2[2];

        int y11 = rec1[1];
        int y12 = rec1[3];

        int y21 = rec2[1];
        int y22 = rec2[3];

        int xStartMin = 0;
        int xEndMin = 0;
        int xStartMax = 0;
        int xEndMax = 0;

        int yStartMin = 0;
        int yEndMin = 0;
        int yStartMax = 0;
        int yEndMax = 0;

        if (x11 < x21) {
            xStartMin = x11;
            xEndMin = x12;

            xStartMax = x21;
            xEndMax = x22;

            yStartMin = y11;
            yEndMin = y12;

            yStartMax = y21;
            yEndMax = y22;

        } else {
            xStartMin = x21;
            xEndMin = x22;

            xStartMax = x11;
            xEndMax = x12;
            
            yStartMin = y21;
            yEndMin = y22;

            yStartMax = y11;
            yEndMax = y12;
        }
        
        if (xStartMax < xEndMin && xEndMax > xStartMin) {
            if (yStartMax < yEndMin && yEndMax > yStartMin) {
                return true;
            }
        }
        return false;
    }
}
