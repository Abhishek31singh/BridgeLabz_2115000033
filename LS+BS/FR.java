import java.io.*;

class FR {
    public void readFileLineByLine(String filename) {
        try (FileReader fr = new FileReader(filename); 
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java FR <filename>");
            return;
        }
        String filename = args[0];
        new FR().readFileLineByLine(filename);
    }
}
