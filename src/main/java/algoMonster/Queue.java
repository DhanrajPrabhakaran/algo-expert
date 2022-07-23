package algoMonster;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Queue {
    public static void main(String[] args) {
        List<String> program = new ArrayList<>(List.of("push 5", "push 10", "peek", "pop", "push 15"));
        System.out.println("Queue: " + execute(program));
    }

    private static ArrayDeque<Integer> execute(List<String> program) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (String choice: program) {
            if (choice.equals("peek")) {
                if (queue.isEmpty())
                    System.out.println("Queue is empty");
                System.out.println("Peeking: " + queue.peek());
            } else if (choice.equals("pop")) {
                if (queue.isEmpty())
                    System.out.println("Queue is empty");
                System.out.println("Popping: " + queue.poll());
            } else
                queue.add(Integer.valueOf(choice.split(" ")[1]));
        }
        return queue;
    }
}
