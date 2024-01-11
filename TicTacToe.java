import java.util.*;
public class TicTacToe {

    //display the grid after every new position insertion
    public static void displayGrid(String[][] grid)
    {
        System.out.println("===========The Grid is ==============\n");
       for (String[] strings : grid)
        {
        for (String strings2 : strings) 
        {
            System.out.print(strings2+ " ");
        }
        System.out.println("\n");
       }
       System.out.println("===========The Grid is ==============");
        
    }
    //check game method return true if any one player wins the game after insertion of new pos in grid
    public static boolean checkGame(String[][] grid,String player)
    {
        //allpossibles means row wise , column wise and diagonal wise elements of grid
       ArrayList<ArrayList<String>> allpossbles= new ArrayList<>();

       //Row wise elements in grid
       for (int i= 0; i< 3; i++) 
       {
        ArrayList<String> possibles= new ArrayList<>();
        for (int j = 0; j < 3; j++) 
        {
            possibles.add(grid[i][j]);
        }
        allpossbles.add(possibles);
       }

       //column wise elements in grid
        for (int i= 0; i< 3; i++) 
       {
        ArrayList<String> possibles= new ArrayList<>();
        for (int j = 0; j < 3; j++) 
        {
            possibles.add(grid[j][i]);
        }
        allpossbles.add(possibles);
       }

       //diagonal wise elements in grid
       ArrayList<String> diagonal1= new ArrayList<>();
       diagonal1.add(grid[0][0]);
       diagonal1.add(grid[1][1]);
       diagonal1.add(grid[2][2]);
       allpossbles.add(diagonal1);
       ArrayList<String> diagonal2= new ArrayList<>();
       diagonal2.add(grid[0][2]);
       diagonal2.add(grid[1][1]);
       diagonal2.add(grid[2][0]);
       allpossbles.add(diagonal2);

       //cheking any one of posibility having a utility yo win the game 
       for (ArrayList<String> posb : allpossbles) 
       {
        //checkpossible is a method for cheking the posbility of a inner grid to win the game
        if (checkPossible(posb,player)) 
        {
            return true;
        }
       }
       return false;
    }
    
    //checkpossible is a method for cheking the posbility of a inner grid to win the game
    public static boolean checkPossible(ArrayList<String>  posb, String player)
    {
            int c=0;
            for (String string : posb) 
            {
                if (string.equals(player)) 
                {
                    c=c+1; 
                }
            }
            if (c==posb.size()) {
                return true;
            }
            else return false;
    }
    public static void main(String[] args) 
    {
        
        System.out.println("Welcome to TIC-TAC-TOE PLAYER VS PLAYER GAME \n");
        System.out.println("Play Game then press 1");
        try (Scanner sc = new Scanner(System.in)) {
            int choice=sc.nextInt();
            while (choice==1) 
            {
            //initializing grid with -
            String[][] grid = new String[3][3];
            for (String[] strings : grid) 
            {
                for (int i = 0; i < strings.length; i++) 
                {
                strings[i] = "-";
                }
            }
            //display the grid initially
            displayGrid(grid);
            ArrayList<Integer> positions= new ArrayList<>();
            int i ;
            for (i = 0; i < 9; i++) 
            {
                String ele="";
                if (i%2==0) 
                {
                     System.out.println("Player -1 ");
                     ele="X";
                }
                else
                {
                     System.out.print("Player-2   ");
                     ele="O";
                } 

                System.out.println("Enter position ");
                int pos=sc.nextInt();
                while(positions.contains(pos) || pos<=0 ||pos>=10 ) 
                {
                    System.out.println("\nposition is not valid because of following problems \n\n1.Position already filled\n\n2.position limit exceeds ");
                    pos=sc.nextInt();
                }
                positions.add(pos);
                int row=(pos-1)/3;
                int col=(pos-1)%3;
                grid[row][col]=ele;
                displayGrid(grid);
                if (checkGame(grid,ele)) 
                {
                    System.out.println("Player "+ ele+ " is the winner");
                    break;
                } 
            }
            if (i>=9) 
            {
                System.out.println("The Game is drawn");
            }
            System.out.println("Play Again. press 1");
            choice=sc.nextInt();
            }
        }
        System.out.println("Game Exit.. Thank You... "); 
    }  
}