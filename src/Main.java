import java.util.*;

public class Main {

    public static final String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
            "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
            "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in " +
            "voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non" +
            " proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\n" +
            "\n";

    public static void main(String[] args) {

        char[] charsArray = text.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (Character currentChar : charsArray) {
            if (!Character.isLetter(currentChar)) {
                continue;
            }
            if (!map.containsKey(currentChar)) {
                map.put(currentChar, 1);
            } else {
                int currentValue = map.get(currentChar) + 1;
                map.put(currentChar, currentValue);
            }
        }

        Comparator<Map.Entry<Character, Integer>> byValue = Map.Entry.comparingByValue();
        Map.Entry<Character, Integer> maxKey = Collections.max(map.entrySet(), byValue);
        Map.Entry<Character, Integer> minKey = Collections.min(map.entrySet(), byValue);

        System.out.println("The most commonly used letter: " + "* " + maxKey.getKey() + " * " + maxKey.getValue());
        System.out.println("The most rarely used letter: " + "* " + minKey.getKey() + " * " + minKey.getValue());
    }
}