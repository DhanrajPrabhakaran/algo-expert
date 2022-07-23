package algoMonster;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    public static void main(String[] args) {
        List<String> program = new ArrayList<>(List.of("push 5", "push 10", "peek", "pop", "push 15"));
        System.out.println("Stack: " + execute(program));
    }

    private static List<Integer> execute(List<String> program) {
        ArrayList stack = new ArrayList();
        for (String choice: program) {
            if (choice.equals("peek"))
                System.out.println("Peeking: " + stack.get(stack.size() - 1));
            else if (choice.equals("pop"))
                System.out.println("Removing: " + stack.remove(stack.size() - 1));
            else
                stack.add(choice.split(" ")[1]);
        }
        return stack;
    }
}
