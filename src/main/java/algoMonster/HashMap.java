package algoMonster;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.util.*;

public class HashMap {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(List.of(8, 3, 2, 4, 4, 6 ,3, 2, 4, 5, 5, 3, 2, 8));
        System.out.println("HashMap: " + getCounter(array));
    }

    private static Map<Integer, Integer> getCounter(List<Integer> array) {
        Map<Integer, Integer> hashMap = new java.util.HashMap<>();
        for (int number: array)
            hashMap.put(number, hashMap.getOrDefault(number, 0) + 1);
        System.out.println("TreeMap: " + hashMap);
        return sortByValue(hashMap);
    }

    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> hashMap) {
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(hashMap.entrySet());
        Collections.sort(list, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));

        Map<Integer, Integer> tmp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry: list)
            tmp.put(entry.getKey(), entry.getValue());
        return tmp;
    }
}
