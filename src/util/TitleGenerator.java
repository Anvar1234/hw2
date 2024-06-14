package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TitleGenerator {
    private final static String FIRST_AND_LAST_POSSIBLE_LETTERS = "йцукенгшщзхъфывапролджэячсмитьбюё"; //строка из возможных символов в начале и конце названия
    private final static String ALL_POSSIBLE_LETTERS = FIRST_AND_LAST_POSSIBLE_LETTERS + "'-"; //строка из всех возможных в названии символов
    private final static Random RANDOM = new Random();

    public static String generateTitle() {
        return generateSentence();
    }

    private static String generateSentence() {
        int wordsCount = RANDOM.nextInt(3) + 1; // min 1 слово, max 3 слова
        List<String> words = new ArrayList<>();

        for (int i = 0; i < wordsCount; i++) {
            String generatedWord = generateWord();

            //переделываем первую букву первого слова в предложении на Заглавную:
            if (i == 0) {
                String preparedGeneratedWord = generatedWord.substring(0, 1).toUpperCase() +
                        generatedWord.substring(1);
                words.add(preparedGeneratedWord);
                //иначе просто добавляем.
            } else {
                words.add(generatedWord);
            }
        }
        return String.join(" ", words);
    }

    private static String generateWord() {
        int lettersCount = RANDOM.nextInt(8) + 1; //min 1 буква, max 8 букв
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < lettersCount; i++) {

            //чтобы в начале и конце слова не было спецсимволов и пробела:
            //если буква первая:
            if (i == 0) {
                int letterId = RANDOM.nextInt(FIRST_AND_LAST_POSSIBLE_LETTERS.length());
                wordBuilder.append(FIRST_AND_LAST_POSSIBLE_LETTERS.charAt(letterId));
            }
            //если буква последняя:
            else if (i == lettersCount - 1) {
                int letterId = RANDOM.nextInt(FIRST_AND_LAST_POSSIBLE_LETTERS.length());
                wordBuilder.append(FIRST_AND_LAST_POSSIBLE_LETTERS.charAt(letterId));
            }
            //а здесь уже для остальных индексов накидаем букв/символов:
            else {
                int letterId = RANDOM.nextInt(ALL_POSSIBLE_LETTERS.length());
                wordBuilder.append(ALL_POSSIBLE_LETTERS.charAt(letterId));
            }
        }
        return wordBuilder.toString();
    }
}
