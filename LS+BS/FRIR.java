import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
class FRIR{
    public void compareStringConcatenation() {
        List<String> strings = new ArrayList<>();
        strings.add("hello");
        int n = 1000000;

        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(strings.get(0));
        }
        long endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append(strings.get(0));
        }
        endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        System.out.println("StringBuilder time: " + stringBuilderTime + " ns");
        System.out.println("StringBuffer time: " + stringBufferTime + " ns");
    }

    public void compareFileReading(String filename) {
        long startTime;
        long endTime;
        int wordCount;

        startTime = System.nanoTime();
        wordCount = countWordsFileReader(filename);
        endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;
        System.out.println("FileReader word count: " + wordCount);
        System.out.println("FileReader time: " + fileReaderTime + " ns");


        startTime = System.nanoTime();
        wordCount = countWordsInputStreamReader(filename);
        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;
        System.out.println("InputStreamReader word count: " + wordCount);
        System.out.println("InputStreamReader time: " + inputStreamReaderTime + " ns");
    }

    private int countWordsFileReader(String filename) {
        int count = 0;
        try (FileReader fr = new FileReader(filename);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                count += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private int countWordsInputStreamReader(String filename) {
        int count = 0;
        try (FileInputStream fis = new FileInputStream(filename);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\s+");
                count += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }


    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Solution <filename>");
            return;
        }
        String filename = args[0];

        FRIR solution = new FRIR();
        solution.compareStringConcatenation();
        solution.compareFileReading(filename);

    }
}
