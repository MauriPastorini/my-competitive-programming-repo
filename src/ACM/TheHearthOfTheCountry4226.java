package ACM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheHearthOfTheCountry4226 {

    private static void restarAdy(int nodeI, int[] suma, Node[] nodes, int k) {
        suma[nodeI] = -1;
        Node node = nodes[nodeI];
        for (Integer adyI : node.lst) {
            if (suma[adyI] != -1) {
                suma[adyI] -= node.value;
                if (suma[adyI] < k) {
                    restarAdy(adyI, suma, nodes, k);
                }
            }
        }
    }

    static class Node {

        int value;
        List<Integer> lst;

        public Node(int val) {
            value = val;
            lst = new ArrayList<>();
        }

        public void addNode(int node) {
            this.lst.add(node);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int cantNodes = in.nextInt();
            int k = in.nextInt();
            if (cantNodes == 0 && k == 0) {
                break;
            }
            Node[] nodes = new Node[cantNodes];
            for (int i = 0; i < cantNodes; i++) {
                int val = in.nextInt();
                Node node = new Node(val);
                int cantAdy = in.nextInt();
                for (int j = 0; j < cantAdy; j++) {
                    node.addNode(in.nextInt());
                }
                nodes[i] = node;
            }

            int[] suma = new int[cantNodes];
            for (int i = 0; i < nodes.length; i++) {
                Node node = nodes[i];
                suma[i] += node.value;
                for (Integer adyI : node.lst) {
                    Node ady = nodes[adyI];
                    suma[i] += ady.value;
                }
            }

            for (int i = 0; i < cantNodes; i++) {
                if (suma[i] < k && suma[i] != -1) {
                    Node node = nodes[i];
                    restarAdy(i, suma, nodes, k);
                }
            }

            int sumaTotal = 0;
            int cantNodesHearth = 0;
            for (int i = 0; i < suma.length; i++) {
                if (suma[i] >= k) {
                    sumaTotal += nodes[i].value;
                    cantNodesHearth++;
                }
            }
            System.out.println(cantNodesHearth + " " + sumaTotal);
        }
    }

}
