package util;

import java.util.Random;
public class YearRandomizer {
    public static int getRandomYear(int leastYear, int upperYear){
        Random random = new Random();
        return random.nextInt(leastYear, upperYear);
    }
}
