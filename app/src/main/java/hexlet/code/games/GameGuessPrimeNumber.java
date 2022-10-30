package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Util;

public class GameGuessPrimeNumber {
    private static final int NUMBER_OF_QUESTIONS = 3;
    private static final int UPPER_BORDER_OF_NUMBER = 50;
    private static final String GENERAL_QUESTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void play() {
        String[][] questionAndAnswerPair = Engine.createArrayForQuestionAndAnswerPairs();
        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            int number = getOddNumber();
            String question = "Question: " + number + "\nYour answer: ";
            String correctAnswer = checkIfNumberIsPrime(number) ? "yes" : "no";
            questionAndAnswerPair[i][0] = question;
            questionAndAnswerPair[i][1] = correctAnswer;
        }
        Engine.mainEngineMethod(GENERAL_QUESTION, questionAndAnswerPair);
    }
    public static int getOddNumber() {
        int number = Util.getRandomizedNumbers(1, UPPER_BORDER_OF_NUMBER);
        if (number % 2 == 0) {
            number++;
        }
        return number;
    }
    public static boolean checkIfNumberIsPrime(int number) {
        if (number < 2) {
            return false;
        }
        int dividersCount = 0;
        for (int j = number; j > 0; j--) {
            if (number % j == 0) {
                dividersCount++;
            }
        }
        return dividersCount == 2;
    }
}
