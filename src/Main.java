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
//            System.out.println();
        }

        Comparator<Map.Entry<Character, Integer>> byValue = Map.Entry.comparingByValue();
        Map.Entry<Character, Integer> maxKey = Collections.max(map.entrySet(), byValue);
        Map.Entry<Character, Integer> minKey = Collections.min(map.entrySet(), byValue);

        System.out.println("Самая частоиспользуемая буква: " + "* " + maxKey.getKey() + " * " + maxKey.getValue());
        System.out.println("Самая редкоиспользуемая буква: " + "* " + minKey.getKey() + " * " + minKey.getValue());
    }
}

/*
Объясните мне пожалуйста, какой метод Collection(на подобии метода Collection.max) я могу использовать,
чтобы красиво достать значение value для max не расширяя свой код?

        int max = Collections.max(map.values());
        int min = Collections.min(map.values());

        Может есть какой-то метод типа - char max = Collection.maxKey(...)
 */

