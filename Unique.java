import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Unique {

    public static void findUniqueCharsUsingSet(char[] array) {
        Set<Character> uniqueChars = new HashSet<>();

        for (char c : array) {
            uniqueChars.add(c);
        }

        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
    }

    public static void findUniqueCharsUsingStream(char[] array) {
        // Create a Stream of characters
        Stream<Character> charStream = IntStream.range(0, array.length)
                .mapToObj(i -> array[i]);

        // Collect unique characters into a Set (HashSet is efficient for uniqueness)
        Set<Character> uniqueChars = charStream.collect(Collectors.toSet());

        // Print unique characters
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
    }

    public static void countCharsPerItemUsingArray(char[] array) {
        int[] count = new int[256]; // Initialize frequency array

        for (char c : array) {
            count[c]++; // Increment count for each character
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            if (count[i] > 0) {
                sb.append((char) i).append(" ").append(count[i]).append(", ");
            }
        }

        // Remove trailing comma and space
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }


    public static void countCharsPerItemUsingStream(char[] array) {
        Stream<Character> charStream = IntStream.range(0, array.length)
                .mapToObj(i -> array[i]);

        Map<Character, Long> charCounts = charStream.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Long> entry : charCounts.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append(", ");
        }

        // Remove trailing comma and space
        sb.setLength(sb.length() - 2);
        System.out.println(sb);
    }


    public static void main(String[] args) {
        char[] myArray = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
        findUniqueCharsUsingSet(myArray);  // Output: h e l o w d (same)
        System.out.println(" ");
        findUniqueCharsUsingStream(myArray);
        System.out.println(" ");
        countCharsPerItemUsingStream(myArray);
        System.out.println(" ");
        countCharsPerItemUsingArray(myArray);
    }
}
