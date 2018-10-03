package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class poj2418 {

    /*
     * Using TreeMap just for sorting
     */

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        int totalTree = 0;
        String line;
        while ((line = stdin.readLine()) != null) {
            totalTree = totalTree + 1;
            if (treeMap.containsKey(line)) {
                treeMap.put(line, treeMap.get(line) + 1);
            } else {
                treeMap.put(line, 1);
            }
        }

        for (String treeName : treeMap.keySet()) {
            System.out.printf("%s %.4f\n", treeName, treeMap.get(treeName) * 100.0 / totalTree);
        }

    }
}
