package ACM;

import java.util.*;
import java.io.*;

public class TimeWrap6882 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();
        for (int i = 1; i <= cases; i++) {
            int tarAngle = input.nextInt();
            String op = input.next();
            int hour = input.nextInt();
            int curAngle = 360 - hour * 30;
            double time = 0; //(in minutes)
            //minute hand moves 6 degree per minute
            //hour hand moves .5 degree per minute
            if (op.equals("after") && curAngle < tarAngle) {
                time = (tarAngle - curAngle) / 5.5;
            }
            if (op.equals("after") && curAngle >= tarAngle) {
                int aux = (360 + tarAngle - curAngle);
                time = aux / 5.5;
            }
            if (op.equals("til") && curAngle <= tarAngle) {
                time = 720 + (tarAngle - curAngle - 360) / 5.5;
            }
            if (op.equals("til") && curAngle > tarAngle) {
                time = 720 + (tarAngle - curAngle) / 5.5;
            }
            int h = (hour + ((int) (time / 60))) % 12;
            if (h <= 0) {
                h = h + 12;
            }
            int m = ((int) time) % 60;
            int s = ((int) ((time * 60) + .5)) % 60;
            System.out.println("Case " + i + ": " + h + ":" + String.format("%02d", m) + ":" + String.format("%02d", s));
        }
    }
}
