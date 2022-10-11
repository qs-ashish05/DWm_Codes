import java.util.Random;

public class Test {
    public static void main(String[] args) {
    Random r = new Random();

    String alphabet = "ABCDE";
    //for (int i = 0; i < 50; i++) {
        System.out.println(alphabet.charAt(r.nextInt(alphabet.length())));
    //}
    }
}
