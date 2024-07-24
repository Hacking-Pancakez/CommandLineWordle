import java.util.Scanner;

class Main {
    private static final String WORD = "games";
    private static final int ATTEMPTS = 6;
    private static int currentAttempt = 0;
    private static final String[] guesses = new String[ATTEMPTS];
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String WHITE = "\u001B[37m";
    private static boolean guessCorrect = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (currentAttempt < ATTEMPTS && !guessCorrect) {
            System.out.print(WHITE + "Input: ");
            String userInput = scanner.nextLine();
            String[] processedInput = processInput(userInput);
            clearConsole();

            for (String guess : guesses) {
                if (guess != null) {
                    System.out.println(guess);
                }
            }
        }
    }

    private static String[] processInput(String userInput) {
        if (userInput.length() != WORD.length()) {
            System.out.println("Error: User input length does not match hidden word length");
            System.exit(1);
        }

        StringBuilder currentGuess = new StringBuilder();
        for (int i = 0; i < userInput.length(); i++) {
            char userChar = userInput.charAt(i);
            char wordChar = WORD.charAt(i);

            if (wordChar == userChar) {
                currentGuess.append(GREEN).append(userChar);
            } else if (WORD.indexOf(userChar) >= 0) {
                currentGuess.append(YELLOW).append(userChar);
            } else {
                currentGuess.append(RED).append(userChar);
            }
        }

        guesses[currentAttempt] = currentGuess.toString();
        currentAttempt++;

        if (WORD.equals(userInput)) {
            guessCorrect = true;
        }

        return guesses;
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
