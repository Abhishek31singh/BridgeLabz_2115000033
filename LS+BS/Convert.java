import java.io.*;
import java.nio.charset.Charset;
class Convert{
    public void convertByteStreamToCharacterStream(String filename, String charsetName) {
        try (FileInputStream fis = new FileInputStream(filename);
             InputStreamReader isr = new InputStreamReader(fis, Charset.forName(charsetName));
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Solution <filename> <charset>");
            return;
        }
        String filename = args[0];
        String charset = args[1];
        new  Convert().convertByteStreamToCharacterStream(filename, charset);
    }
}
