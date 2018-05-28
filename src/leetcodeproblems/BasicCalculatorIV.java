/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauri-Laptop
 */
public class BasicCalculatorIV {

    void test() {
//        String[] evalvars = {"e", "temperature"};
//        int[] evalints = {1, 12};
//        basicCalculatorIV("e - 8 + temperature - pressure", evalvars, evalints);
        String[] evalvars = {};
        int[] evalints = {};
        basicCalculatorIV("(e + 8) * (e - 8)", evalvars, evalints);
    }

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        expression = " " + expression + " ";

        for (int i = 0; i < evalvars.length; i++) {
            String var = evalvars[i];
            int val = evalints[i];

            expression = expression.replaceAll(" " + var + " ", " " + val + " ");
        }

        resolveSubExp(expression);

        String[] factors = expression.split(" \\+ |\\ - ");

        return null;

    }

    private String resolveSubExp(String expression) {
        int cantPar = 0;
        int posPar = 0;
        StringBuilder res = new StringBuilder(expression);
        for (int i = 1; i < res.length() - 1; i++) {
            if (res.charAt(i) == '(') {
                cantPar++;
                posPar = i;
            }
            if (res.charAt(i) == ')') {
                cantPar--;
                if (cantPar == 0) {
                    res.replace(posPar + 1, i, resolveSubExp(res.substring(posPar + 1, i)));
                }
            }
//            if (res.charAt(i - 1) == ' ') {
//                res.replace(i - 1, i, "(");
//                cantPar++;
//            }
//            if (cantPar > 0 && res.charAt(i + 1) == ' ') {
//                res.replace(i + 1, i + 2, ")");
//                cantPar--;
//
//            }
        }
        String resOp = "";
        for (int i = 1; i < res.length() - 1; i++) {
            if (res.charAt(i) == '*' || res.charAt(i) == '/') {
                char op = res.charAt(i) == '*' ? '*' : '/';
                int end = res.indexOf(" ", i + 2);
                int start = res.reverse().indexOf(" ", i + 2) - res.length() + 1;
                res.reverse();
                String term1 = res.substring(start + 2, i - 2);
                String term2 = res.substring(i + 3, end - 1);

                String[] factorsTerm1 = term1.split("\\+|\\-");
                List<Character> opFact1 = getSymbols(term1);
                String[] factorsTerm2 = term2.split("\\+|\\-");
                List<Character> opFact2 = getSymbols(term2);

                for (int j = 0; j < factorsTerm1.length; j++) {
                    String f1 = factorsTerm1[j].trim();
                    Character s1 = opFact1.get(j);
                    for (int k = 0; k < factorsTerm2.length; k++) {
                        String f2 = factorsTerm2[k].trim();
                        Character s2 = opFact2.get(k);
                        Character symbol = getSymbol(s1, s2);
                        if (tryParseInt(f1) && tryParseInt(f2)) {
                            int a = Integer.parseInt(f1);
                            int b = Integer.parseInt(f2);
                            if (s1 == '-') a = -a;
                            if (s2 == '-') b = -b;
                            int resOpInt;
                            if (op == '*') {
                                resOpInt = a*b;
                            } else{
                                resOpInt = a/b;
                            }
                            resOp += resOpInt;
                            makeCorrespSumRest(resOp,resOpInt + "");
                        } else {
                            makeCorrespSumRest(resOp,symbol + f1 + op + f2);
                            resOp += resOp.isEmpty() ? f1 + op + f2 : symbol + f1 + op + f2;
                        }
                    }
                }
            }
        }
        return res.toString().replace(" ", "");
    }

    private List<Character> getSymbols(String term1) {
        List<Character> res = new ArrayList<>();
        res.add('+');
        for (char s : term1.toCharArray()) {
            if (s == '+' || s == '-') {
                res.add(s);
            }
        }
        return res;
    }

    private Character getSymbol(Character s1, Character s2) {
        if (s1 == '+') {
            return s2;
        } else {
            if (s2 == '+') {
                return s1;
            } else {
                return '+';
            }
        }
    }
    
    boolean tryParseInt(String value) {  
     try {  
         Integer.parseInt(value);  
         return true;  
      } catch (NumberFormatException e) {  
         return false;  
      }  
}

    private void makeCorrespSumRest(String resOp, String factor) {
        if (resOp.contains(factor.substring(1))) {
            if (factor.charAt(0) == '+') {
                
            }
        }
    }

}
