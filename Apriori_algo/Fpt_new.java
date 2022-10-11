import java.util.Random;

public class Fpt_new {
    public static void main(String[] args) {
        String [] id_tran = new String[5];
        Random random = new Random();

        char randomizedCharacter = (char) (random.nextInt(26) + 'a');
        randomizedCharacter = 
        System.out.println("Generated Random Character: " + randomizedCharacter);
    }
}
