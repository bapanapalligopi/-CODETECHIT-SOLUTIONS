import java.util.*;

public class NumberGame 
{
    public static void main(String[] args) 
    {
    try (Scanner sc = new Scanner(System.in)) {
        // Create a Random object
          Random random = new Random();
        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;
        //note this number is displayed for testing purpose in real time it is not visible to the user
        System.out.println("=========this number can be hide in normal=============");
        System.out.println("Randome Number is "+randomNumber);
        System.out.println("=========this number can be hide in normal=============");
        //play game or not, choice= 1 then play else no play
        System.out.println("To play the game press 1 otherwise press 2");  
        int choice=sc.nextInt();
        int rounds=1;
        HashMap<Integer,Integer> scoreMap= new HashMap<>();
        while (choice==1) 
        {
            System.out.println("Welcome to Number Game");
            System.out.println("score can be calculated by 10-2*attempts , where 10 is 2*attempts limit");
            //limit the number of attemtps  upto 5
            int attempts=1;
            int score=0;
            while (attempts<6) 
            {
                System.out.println("Can you Guess the number in attempt "+ attempts);  
                int userNumber=sc.nextInt();
                if (randomNumber==userNumber) {
                     System.out.println("\n Your Guess is correct");
                     score+=10-2*attempts;
                     break;  
                }
                else if (userNumber<randomNumber) {
                    System.out.println("\n Your Guess is Too low");
                }
                else System.out.println("\n Your Guess is Too high");

                attempts+=1;
            }
            if (attempts>=6) 
            {
               
                System.out.println("Your attempts over. please press 1 for play again or 2 to exit the game");
                scoreMap.put(rounds, score);
                choice=sc.nextInt();
                rounds+=1;
                if (choice==1)  
                {
                    randomNumber = random.nextInt(100) + 1;
                    System.out.println("=========this number can be hide in normal=============");
                    System.out.println("Randome Number is "+randomNumber);
                    System.out.println("=========this number can be hide in normal=============");
                }
            }
            else{
                
                System.out.println("plaese press 1 for play again or 2 to exit the game");
                choice=sc.nextInt();
                scoreMap.put(rounds, score);
                rounds+=1;
                if (choice==1)  
                {
                    randomNumber = random.nextInt(100) + 1;
                    //note this number is displayed for testing purpose in real time it is not visible to the user
                   System.out.println("=========this number can be hide in normal=============");
                    System.out.println("Randome Number is "+randomNumber);
                    System.out.println("=========this number can be hide in normal=============");
                }
            }
        }
   
  System.out.println("====================Score card=====================");
   for (Integer r : scoreMap.keySet()) {
            System.out.println("Round -" + r +"   Score -" + scoreMap.get(r));
        }
    }
    System.out.println("====================Score card=====================");
    }
}
