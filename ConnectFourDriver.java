/*
 * ConnectFourDriver.java
 * 
 * Version: 4.1.1
 * 
 * Revisions: 1.1
 * 
 */

/**
 * 
 *  This is the driver that executes ConnectFour Game.
 * 
 * @author ANKITA KHADSARE
 * @author SALONI PODDAR
 *
 */

public class ConnectFourDriver
{
    public static void main(String[] args)
    {
        ConnectFourPlayerInterface player1 = new HumanPlayer("Bob"); //creating player1 object of HumanPlayer Class and calling parameterized constructor.
        ConnectFourPlayerInterface player2 = new HumanPlayer(); //creating player2 object of HumanPlayer Class and calling default constructor.
        ConnectFourGameInterface game = new ConnectFourGame(player1, player2); // creating object of ConnectFourGame class.
        
        //calling methods of ConnectFourGame class.
        game.playGame();
        game.getStats();
    }
}