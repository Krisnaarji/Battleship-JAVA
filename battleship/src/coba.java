import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class coba {
    public static String[][] battleField = new String[10][10];
    public static int pShip;
    public static int botShip;

    public static void main(String[] args) {

//create map
        battleMap();

        //place player ship
        playerShip();

        //bot place the ship
        computerShip();

// battle
        do {
            Battle();
        }while(pShip != 0 && botShip != 0);
//game over
        gameEnd();
    }

    public static void battleMap() {

        //top area
        System.out.print("*|");
        for (int i = 0; i < battleField.length; i++)
            System.out.print("\t" + i );
        System.out.print("  |*");
        System.out.println();

        //battle field area
        for(int i = 0; i < battleField.length; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < battleField[i].length; j++) {
                if (battleField[i][j] == null){
                    System.out.print("\t~");
                } else if (battleField[i][j] == "@") {
                    System.out.print("\t@");
                } else if (battleField[i][j] == "x") {
                    System.out.print("\t+");
                } else if (battleField[i][j] == "G") {
                    System.out.print("\tx");
                } else if (battleField[i][j] == "!") {
                    System.out.print("\t!");
                } else if (battleField[i][j] == "-") {
                    System.out.print("\t-");
                } else if (battleField[i][j] == "=") {
                System.out.print("\t=");
                }
            }
            System.out.print("  |" + i);
            System.out.println();
        }
        //bottom area
        System.out.print("*|");
        for (int i = 0; i < battleField.length; i++)
            System.out.print("\t" + i );
        System.out.print("  |*");
        System.out.println();

    }

    public static void playerShip() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDeploy your ships:");
        System.out.println();
        //player deploy 5 ship

        pShip = 5;
        for (int i = 1; i <= pShip; ) {
            while (true) {
                try {
                    System.out.print("Enter X coordinate for your #" + i + " ship: ");
                    int x = input.nextInt();

                    System.out.print("Enter Y coordinate for your #" + i + " ship: ");
                    int y = input.nextInt();

                    if ((x >= 0 && x < battleField.length) && (y >= 0 && y < battleField.length) && (battleField[x][y] == null)) {
                        battleField[x][y] = "@";
                        i++;

                    } else if ((x >= 0 && x < battleField.length) && (y >= 0 && y < battleField.length) && battleField[x][y] == "@") {
                        System.out.println("You can't place two or more ships on the same location");

                    } else if ((x < 0 || x >= battleField.length) || (y < 0 || y >= battleField.length)) {
                        System.out.println("you can't place ship outside " + battleField.length + " by " + battleField.length + " battle field grid");
                    }

                    break;
                } catch (InputMismatchException e) {
                    System.out.println("please enter only numbers");
                    input.nextLine();


                }

            }
        }
        battleMap();
    }




    public static void computerShip() {
        System.out.println("\nComputer Is Deploying Ships");

        Random randomNum = new Random();
        botShip = 5;
        for(int i = 1; i <= botShip;) {
            int x = randomNum.nextInt(10);
            int y = randomNum.nextInt(10);
            if (battleField[x][y] == null) {
                battleField[x][y] = "x";
                System.out.println("computer #" + i + " ship deployed");
                i++;
            }
        }
        battleMap();
    }

    public static void Battle(){




            playerTurn();

            computerTurn();

            battleMap();





        System.out.println();
        System.out.println("Your ships: " + pShip + " | Computer ships: " + botShip);
        System.out.println();
    }

    public static void playerTurn() {
        System.out.println("\nYOUR TURN");
        int x = -1, y = -1;
        while (true) {
            try {
                do {

                        Scanner input = new Scanner(System.in);

                        System.out.print("Enter X coordinate: ");
                        x = input.nextInt();
                        System.out.print("Enter Y coordinate: ");
                        y = input.nextInt();

                        if ((x >= 0 && x < battleField.length) && (y >= 0 && y < battleField.length)) //valid guess
                        {
                            if (battleField[x][y] == "x") //if computer ship is already there; computer loses ship
                            {
                                System.out.println("Boom! You sunk the ship!");
                                battleField[x][y] = "!"; //Hit mark
                                --botShip;
                            } else if (battleField[x][y] == "@") { //if the player hit their own ship; player loses ship
                                System.out.println("Oh no, you sunk your own ship :(");
                                battleField[x][y] = "G";
                                --pShip;

                            } else if (battleField[x][y] == null) { //when there is no ship; print mark
                                System.out.println("Sorry, you missed");
                                battleField[x][y] = "-";
                            }

                        } else if ((x < 0 || x >= battleField.length) || (y < 0 || y >= battleField.length)) {  //invalid guess
                            System.out.println("you can't attack outside " + battleField.length + " by " + battleField.length + " battle field grid");
                        }
                } while ((x < 0 || x >= battleField.length) || (y < 0 || y >= battleField.length));
                    //keep re-placing until valid guess within battlefield grid
                break;
            } catch (InputMismatchException e) {
                System.out.println("please enter only numbers");

            }
        }
    }



    public static void computerTurn(){
        System.out.println("\nCOMPUTER'S TURN");
        //Guess co-ordinates
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

            if ((x >= 0 && x < battleField.length) && (y >= 0 && y < battleField.length)) //valid guess
            {
                if (battleField[x][y] == "@") //if player ship is already there; player loses ship
                {
                    System.out.println("The Computer sunk one of your ships!");
                    battleField[x][y] = "G";
                    --pShip;

                }
                else if (battleField[x][y] == "x") { //if the computer hit their own ship; computer loses ship
                    System.out.println("The Computer sunk one of its own ships");
                    battleField[x][y] = "!";
                    --botShip;
                }
                else if (battleField[x][y] == null) { //when there is no ship; print mark
                    System.out.println("Computer missed");
                    battleField[x][y] = "=";
                }else if (battleField[x][y] == "-") {
                    System.out.println("you already attacked that area");

                }
            }
        }while((x < 0 || x >= battleField.length) || (y < 0 || y >= battleField.length));  //keep re-prompting till valid guess
    }

    public static void gameEnd(){

        battleMap();
        System.out.println();
        System.out.println("Your ships: " + pShip + " | Computer ships: " + botShip);
        System.out.println("------------------------------------");
        if(pShip > 0 && botShip <= 0)
            System.out.println("Hooray! You won the battle :)");
        else
            System.out.println("Sorry, you lost the battle");
        System.out.println();
    }
}




