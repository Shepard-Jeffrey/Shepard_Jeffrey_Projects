import java.util.Random;
import java.util.Scanner;

// This is a simple bit of code that runs multiple rounds of the Prisoner's dilenmma against an agent. 
// Allows the user to choose the strategy for the AI as well as the number of rounds, and their own choices. 

public class ShepardJeffreyJavaDemo { 

  //True : the prisoner betrayed.
  //False : the prisoner stayed silent.
  final static boolean BETRAYED = true;
  final static boolean SILENT = false;
  public static int playerYears=0, agentYears=0; 

  public static int[] CalculateYears(boolean pChoice, boolean aChoice)  { // Method for calculating the years of jailtime each player recieves. 

  // Declares empty int array
  int[] results = new int[2];

  int pYears = 0;
  int aYears = 0;

   if (pChoice == BETRAYED && aChoice == BETRAYED) { // Both Betray
        pYears = 2;
        aYears = 2;                             
    }
   else if (pChoice == BETRAYED && aChoice == SILENT) { // Only player betrays
        aYears = 3;
    }

   else if (pChoice == SILENT && aChoice == BETRAYED) { // Only CPU betrays
        pYears = 3;
    }

    else if (pChoice == SILENT && aChoice == SILENT) { // Both remain silent
        pYears = 1;
        aYears = 1;
    }

    // Assigns values to results using index

    results[0] = pYears;
    results[1] = aYears;

    return (results);
  }

  public static void main(String[] args){

    Scanner input = new Scanner(System.in);        // Needed user input, so added a scanner.
    boolean playerChoice = BETRAYED, playerLastChoice = SILENT; 
    boolean agentChoice = SILENT, agentLastChoice = SILENT;        
    int playerBetrayals=0, agentBetrayals=0; // Keeping count of number of total betrayals. 

    Random rand = new Random();

    System.out.println("Welcome to the Prisoner's Dilemma Game!");
    System.out.println("I know how to play this game many ways.");
    System.out.println("Here is a list of the strategies I know:");
    System.out.println("1. Betray at random");
    System.out.println("2. Always Betray");
    System.out.println("3. Always Silent");
    System.out.println("4. TitForTat");
    System.out.println("Enter the number for the strategy that you would like me to use:");
    int strategyChoice = input.nextInt();

    if(strategyChoice == 1){
      System.out.println("Very good. I will betray at random"); // Each strategy
    }
    if(strategyChoice == 2){
      System.out.println("Very good. I will always betray you");
    }
    if(strategyChoice == 3){
      System.out.println("Very good. I will always stay silent");
    }
    if(strategyChoice == 4){
      System.out.println("Very good. I will go TitForTat with you.");
    }

    System.out.println("How many rounds would you like to play?");

    int numRounds = input.nextInt();


    System.out.println("Very good. We will play " + numRounds + " rounds together");

    int roundCount = 0; // Needed an if statement for round end, couldn't use currentRound because it's a local variable. 

    for (int currentRound = 1; currentRound <= numRounds; currentRound++, roundCount++) {  //Code for running the rounds, incremented both currentRound and roundCount for use outside loop. 

        if(strategyChoice == 1){                // Code for each agent strategy. . 
           agentChoice = rand.nextBoolean();
     }    

         else if (strategyChoice == 2){
           agentChoice = BETRAYED;
     }    

         else if (strategyChoice == 3){
           agentChoice = SILENT;
     }    

         else if (strategyChoice == 4){
           agentChoice = playerLastChoice;
     }    

     System.out.println("Round: " + currentRound);
     System.out.println("I have made my choice. Do you betray?");
     System.out.println("Type 1 for Betray, Type 2 for Silence.");

     int userinput = input.nextInt();


     if (userinput == 1) { 
          playerChoice = BETRAYED;
     }
      else if (userinput == 2) {
          playerChoice = SILENT;
     } 

     else {
      System.out.println("You need to enter either 1, or 2."); // In case user failed to follow instructions. 
     }

    if (playerChoice == BETRAYED) {
         playerBetrayals++;
    }
                              
    if (agentChoice == BETRAYED) {
         agentBetrayals++;
    }

    int[] yearsArray = CalculateYears(playerChoice, agentChoice); // Calling calculate method. 
    
      // Increments Agentyears & Playeryears using indexes of yearsArray

    playerYears += yearsArray[0]; 
    agentYears += yearsArray[1];

    playerLastChoice = playerChoice;
    agentLastChoice  = agentChoice;

}

    // States again which strategy was used, and how much each player betrayed. 

if (roundCount == numRounds) {
    System.out.println("Player betrayed " + playerBetrayals + " times.");
    System.out.println("Agent betrayed " + agentBetrayals + " times.");

    if (strategyChoice == 1) {
      System.out.println("Agent betrayed at random.");
    }

    if(strategyChoice == 2) {
      System.out.println("Agent always betrayed you.");
    }

    if(strategyChoice == 3) {
      System.out.println("Agent always stayed silent.");
    }

    if(strategyChoice == 4) {
      System.out.println("Agent went TitForTat with you.");
    }

    System.out.println("Agent years are: " + agentYears);
    System.out.println("Player years are: " + playerYears);

// Outputs results to user


    if (playerYears > agentYears) {
          System.out.println("Agent Wins!");
        }
    else if (agentYears > playerYears) {
        System.out.println("Player Wins!");
      }
    else {
        System.out.println("It was a tie!");
      }
}

    System.out.println("Finished!");
  }
}

