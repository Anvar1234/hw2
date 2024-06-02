package util;

import java.util.Random;
public class YearRandomizer {
    public static String getRandomYear(int leastYear, int upperYear){
        Random random = new Random();
        int randomYear = random.nextInt(leastYear, upperYear);
        return String.valueOf(randomYear);
    }
}
