package algoMonster;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class RotateZerosLeft {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(7, 4, 6, 2, 0));
        System.out.println("Updated list: " + rotateLeft(numbers));
    }

    private static List<Integer> rotateLeft(ArrayList<Integer> numbers) {
        ArrayDeque<Integer> queue = new ArrayDeque<>(numbers);
        while (queue.peek() != 0)
            queue.add(queue.poll());
        List<Integer> result = new ArrayList<>(queue);
        return result;
    }
}
