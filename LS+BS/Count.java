import java.io.*;
class Count{
    public int countWordOccurrence(String filename, String targetWord) {
        int count = 0;
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Solution <filename> <word>");
            return;
        }
        String filename = args[0];
        String word = args[1];
        int count = new Count().countWordOccurrence(filename, word);
        System.out.println("The word '" + word + "' appears " + count + " times in the file.");
    }
}
