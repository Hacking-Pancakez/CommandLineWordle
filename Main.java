import java.util.Scanner;
class Main {
  private static String word = "games";
  private static int attempts = 6;
  static int currentAttempt = 0;
  private static String[] guess = {"", "", "", "", "", ""};
 static String yellow = "\u001B[33m";
  static String green = "\u001B[32m";
  static String white = "\u001B[37m";
  static String red = "\u001B[31m";
  static boolean guessCorrect = false;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //String[] test = inputDetermine(in.nextLine());
    for (int a = currentAttempt; a < attempts && !guessCorrect; a++){
      System.out.println( white + "Input: ");
      String[] test = inputDetermine(in.nextLine());
      clear();
      for (int i = 0; i < test.length; i++){
        System.out.println(test[i]);
      }
    }
  }

  public static String[] inputDetermine(String user){
    String[] wordArray = word.split("");
    String[] userArray = user.split("");
    if (wordArray.length != userArray.length){
      System.out.println("Error: User input length does not match hidden word length");
      System.exit(1);
    }
   // if (currentAttempt == attempts) System.exit(1);
    for (int i = 0; i < userArray.length; i++){
      if (wordArray[i].equalsIgnoreCase(userArray[i])){
        guess[currentAttempt] += green + userArray[i];
      }
      else if (word.contains(userArray[i])){
        guess[currentAttempt] += yellow + userArray[i];
      }
      else {
        guess[currentAttempt] += red + userArray[i];
      }
    }
    currentAttempt++;
    if (word == user) guessCorrect = true;
    return guess;
  }
  public static void clear(){
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }
}