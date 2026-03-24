import java.util.*;

public class GuessingGame
{
    //para mabasa daw sa lahat ng mga methods

    static int secretNumber;
    static String playerName;





    public static void main(String[] args)
    {
        Scanner eye = new Scanner(System.in);

        System.out.println("players name");
        playerName = eye.next();

        gameStartnameattemp(playerName);

        secretNumber = randomgen();

        getUserguess();
    }





    public static void getUserguess()
    {
        int attemps = 0;
        Scanner eye = new Scanner(System.in);

        while (attemps < 10)
        {
            int i = attemps + 1;
            System.out.println("\n--- Attempt #" + i + " ---");
            System.out.print("Enter your guess (1-100): ");
            int gues = eye.nextInt();

            if (gues> 100 || gues< 1)
            {
                System.out.println("Invalid! Please enter a number between 1 and 100.");
                // para maulit lang invalid guess
                continue;
            }

            attemps++;

            if (gues == secretNumber)
            {
                System.out.println("\nCongratulations " + playerName + "!");
                System.out.println("You guessed the number " + secretNumber + " in " + attemps + " attempts!");
                displayStats(attemps);
                return;
            }



            // para sa hint
            else
            {
                givehint(gues);
            }
        }




        // pag mali lahat
        System.out.println("\nGAME OVER!");
        System.out.println("You've used all 10 attempts.");
        System.out.println("The secret number was " + secretNumber + ".");
        displayStats(attemps);
    }





    // hint
    public static void givehint(int guess)
    {
        if (guess < secretNumber)
        {
            System.out.println("Too low! Try a higher number.");
        }
        else
        {
            System.out.println("Too high! Try a lower number.");
        }
    }







    // game start message
    public static void gameStartnameattemp(String name)
    {
        System.out.println("========================================");
        System.out.println("    WELCOME TO THE GUESSING GAME..       ");
        System.out.println("========================================");
        System.out.println("Hello, " + name);
        System.out.println("");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have 10 attempts to guess it.");
        System.out.println("I'll give you a hint after each guess.");
        System.out.println("\nLet's begin!");
        System.out.println("========================================");




    }






    // game ed stats
    public static void displayStats(int attemptsa)
    {
        String rating;

        if (attemptsa == 1)
            rating = "Perfect! daw p";
        else if (attemptsa <= 3)
            rating = "Excellent!";
        else if (attemptsa <= 6)
            rating = "Good job!";
        else if (attemptsa <= 10)
            rating = "Nice try l bozzo hahaha";
        else
            rating = "Better luck next time!..... looser ";









        System.out.println("");
        System.out.println("========================================");
        System.out.println("            GAME STATISTICS             ");
        System.out.println("========================================");
        System.out.println("Player:" + playerName);
        System.out.println("Secret Number:" + secretNumber);
        System.out.println("Attempts Used: " + attemptsa);
        System.out.println("Rating: " + rating);
        System.out.println("========================================");
        System.out.println("thanks for playing ");












    }





    // random number generator
    public static int randomgen()
    {
        Random rand = new Random();
        int randomnumber = rand.nextInt(100) + 1;
        return randomnumber;






    }
}