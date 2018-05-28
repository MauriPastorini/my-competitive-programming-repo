/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACM;

import java.util.Scanner;

/**
 *
 * @author Mauri-Laptop
 */
public class BlackAndWhite_6822 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext()){
            String input = in.nextLine();
            String[] values = input.split(" ");
            int costSwap = Integer.parseInt(values[0]);
            int costAdjacentSwap = costSwap - Integer.parseInt(values[1]) ;
            
            String[] elems = in.nextLine().split("");
            
            int contB = 0;
            for (int i = 0; i < elems.length; i++) {
                if (elems[i].equals("B")) {
                    contB++;
                }
            }
            
            int cost = 0;
            for (int i = contB; i >= 0 ; i--) {
                int auxPosRight = contB;
                while(auxPosRight < elems.length && !elems[auxPosRight].equals("B")){
                    auxPosRight++;
                }
                if (auxPosRight >= elems.length)break;
                
                int auxPosLeft = contB - 1;
                while(auxPosLeft >= 0 && !elems[auxPosLeft].equals("W")){
                    auxPosLeft--;
                }
                if (auxPosLeft < 0) break;
                
                cost += Math.min(costSwap, (auxPosRight - auxPosLeft)*costAdjacentSwap);
                elems[auxPosLeft] = "B";
                elems[auxPosRight] = "W";
            }
            System.out.println(cost);
            
        }
    }
}
