package jpmc;

import java.util.ArrayList;
import java.util.List;

public class TitleCase {
    public static void main(String[] args) {
        String str = "dHanraj is tHe bEST";
        System.out.println("Capital title: " + titleCase(str));
    }

    private static String titleCase(String sentence) {
        String[] words = sentence.split(" ");
        List<String> result = new ArrayList<>();
        for (String word: words) {
            StringBuilder str = new StringBuilder();
            if (word.length() < 3)
                str.append(word.toLowerCase());
            else {
                str.append(word.substring(0, 1).toUpperCase());
                str.append(word.substring(1).toLowerCase());
            }
            result.add(str.toString());
        }
        return String.join(" ", result);
    }
}
