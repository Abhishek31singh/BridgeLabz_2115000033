import java.io.IOException;
import java.util.*;

public class WordFrequency{
    public static void main(String[] args) throws IOException {
        String text = "Hello world, hello Java!";
        System.out.println(wordFrequency(text));
    }

    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        return frequencyMap;
    }
}
