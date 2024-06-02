package util;

import java.util.Random;
public class TitleGenerator {
    private final static String firstAndLastPossibleLetters = "йцукенгшщзхъфывапролджэячсмитьбюё"; //строка из возможных символов в начале и конце названия
    private final static String allPossibleLetters = firstAndLastPossibleLetters + "'-"; //строка из возможных в названии символов
    private final static Random random = new Random();

    public static String generateTitle() {
        return generateSentence();
    }

    private static String generateSentence() {
        int wordsCount = random.nextInt(3) + 1; // min 1 слово, max 3 слова
        StringBuilder sentenceBuilder = new StringBuilder();

        for (int i = 0; i < wordsCount; i++) {
            String generatedWord = generateWord();
            String preparedGeneratedWord = generatedWord.substring(0, 1).toUpperCase() + generatedWord.substring(1);
            //переделывание первой буквы предложения на Заглавную:
            if (i == 0) {
                sentenceBuilder.append(preparedGeneratedWord);
            } else {
                sentenceBuilder.append(generatedWord);
            }
            // добавляем пробелы между словами, если это не последнее слово:
            if (i < wordsCount - 1) {
                sentenceBuilder.append(" ");
            }
        }
        return sentenceBuilder.toString();
    }

    private static String generateWord() {
        int lettersCount = random.nextInt(8) + 1; //min 1 буква, max 8 букв
        StringBuilder wordBuilder = new StringBuilder();
        for (int i = 0; i < lettersCount; i++) {
            //чтобы в начале и конце слова не было спецсимволов и пробела:
            //если буква первая:
            if (i == 0) {
                int letterId = random.nextInt(firstAndLastPossibleLetters.length());
                wordBuilder.append(firstAndLastPossibleLetters.charAt(letterId));
            }
            //если буква последняя:
            else if (i == lettersCount - 1) {
                int letterId = random.nextInt(firstAndLastPossibleLetters.length());
                wordBuilder.append(firstAndLastPossibleLetters.charAt(letterId));
            } else {
                //а здесь уже для остальных индексов накидаем букв:
                int letterId = random.nextInt(allPossibleLetters.length());
                wordBuilder.append(allPossibleLetters.charAt(letterId));
            }
        }
        return wordBuilder.toString();
    }
}
