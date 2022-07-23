package jpmc;

public class MinSteps {
    public static void main(String[] args) {
        String[] tools = {"saw", "hammer", "mallet","file", "saw", "ladder", "scissor"};
        System.out.println("Minimum steps: " + minSteps(tools, 6, "saw"));
    }

    private static int minSteps(String[] tools, int start, String target) {
        int minSteps = 0;
        int n = tools.length;
        int i = start;

        while (i < start + n) {
            if (target == tools[(i % n)])
                return minSteps;
            minSteps++;
            i++;
        }
        return -1;
    }
}
