public class Concate {
    public static void main(String[] args) {
        String[] strings = {"Hello", " ", "World", "!"};
        StringBuffer result = new StringBuffer();

        for (String str : strings) {
            result.append(str);
        }

        System.out.println(result.toString());
    }
}
