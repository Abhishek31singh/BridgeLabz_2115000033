import java.io.*;
class Write{
    public void readUserInputAndWriteToFile(String filename) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter(filename)) {

            String line;
            while (!(line = br.readLine()).equals("exit")) {
                fw.write(line + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Solution <filename>");
            return;
        }
        String filename = args[0];
        new Write().readUserInputAndWriteToFile(filename);
    }
}
