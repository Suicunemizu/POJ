package dataStructure;

import java.util.HashMap;
import java.util.Scanner;

public class poj1330 {

    /*
     * First construct a tree, and then compute the common ancestor
     */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numTestCases = in.nextInt();

        while (numTestCases > 0) {
            numTestCases = numTestCases - 1;
            HashMap<Integer, Integer> treeMap = new HashMap<Integer, Integer>();
            int treeSize = in.nextInt();

            for (int i = 0; i < treeSize - 1; i++) {
                int parent = in.nextInt();
                int child = in.nextInt();
                treeMap.put(child, parent);
            }

            int testNode1 = in.nextInt();
            int testNode2 = in.nextInt();

            int LCA = findLCA(treeMap, testNode1, testNode2);
            System.out.println(LCA);

        }

    }


    public static int findLCA(HashMap<Integer, Integer> treeMap, int node1, int node2) {

        int depth1 = findDepth(treeMap, node1);
        int depth2 = findDepth(treeMap, node2);

        int diff = Math.abs(depth1 - depth2);

        while (diff > 0) {
            diff = diff - 1;
            if (depth1 > depth2) {
                node1 = treeMap.get(node1);
            } else {
                node2 = treeMap.get(node2);
            }
        }

        while (node1 != node2 && treeMap.containsKey(node1) && treeMap.containsKey(node2)) {
            node1 = treeMap.get(node1);
            node2 = treeMap.get(node2);
        }
        return node1;
    }

    public static int findDepth(HashMap<Integer, Integer> treeMap, int node) {
        int depth = 0;
        while (treeMap.containsKey(node)) {
            depth = depth + 1;
            node = treeMap.get(node);
        }
        return depth;
    }


}
