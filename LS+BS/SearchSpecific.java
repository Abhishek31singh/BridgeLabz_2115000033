import java.util.*;
class SearchSpecific{
    public String findSentenceContainingWord(List<String> sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        List<String> sentences = List.of(
                "This is the first sentence.",
                "The second sentence is here.",
                "A third sentence exists.",
                "No word here."
        );
        String targetWord = "second";
        String result = new SearchSpecific().findSentenceContainingWord(sentences, targetWord);
        System.out.println("Sentence containing '" + targetWord + "': " + result);
        targetWord = "missing";
        result = new SearchSpecific().findSentenceContainingWord(sentences, targetWord);
        System.out.println("Sentence containing '" + targetWord + "': " + result);

    }
}
