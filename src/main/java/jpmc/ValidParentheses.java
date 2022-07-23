package jpmc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    private static final List<Character> leftBrackets = new ArrayList<>(List.of('(','[','{','<'));
    private static final List<Character> rightBrackets = new ArrayList<>(List.of(')',']','}','>'));

    public static void main(String[] args) {
        String str = "{}{{}}[]((())()";
        System.out.println("Is Valid: " + isValid(str));
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch: str.toCharArray()) {
            if (leftBrackets.contains(ch))
                stack.push(ch);
            else if (rightBrackets.contains(ch)) {
                if (stack.isEmpty())
                    return false;
                if (!(leftBrackets.indexOf(stack.pop()) == rightBrackets.indexOf(ch)))
                    return false;
            }
        }
        return stack.isEmpty();
    }

}
