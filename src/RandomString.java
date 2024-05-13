import java.util.Random;

public class RandomString {
    private static final String YEUX = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String randomString(int n) {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int randomIndex = rand.nextInt(YEUX.length());
            sb.append(YEUX.charAt(randomIndex));
        }

        return sb.toString();
    }
}
