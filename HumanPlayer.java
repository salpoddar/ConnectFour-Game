/*
 * HumanPlayer.java
 * 
 * Version: 4.1.1
 * 
 * Revisions: 1.1
 * 
 */

/**
 * 
 * This program is to set basic Human Player gaming statistics 
 * that can be used in ConnectFour Game.  
 * 
 * @author ANKITA KHADSARE
 * @author SALONI PODDAR
 *
 */

public class HumanPlayer implements ConnectFourPlayerInterface {
	char gameChar;
	String playerName;
	int win=0;
	int playerNumber;
	
	/**
	 * Parameterised Constructor of HumanPlayer Class.
	 * 
	 * @param string string sets the Player name in this constructor.
	 * 
	 */
	
	public HumanPlayer(String string) {
		// TODO Auto-generated constructor stub
		this.playerName = string;
	}
	/**
	 * Default Constructor of HumanPlayer Class.
	 * 
	 * It sets default name of Player.
	 * 
	 */
	public HumanPlayer() {
		// TODO Auto-generated constructor stub
		this.playerName = "Group12";
	}
	
	/**
	 * Method to return turn of the player.
	 */
	
	@Override
	public int takeTurn() {
		// TODO Auto-generated method stub
		return playerNumber;
	}

	@Override
	
	/**
	 * Method to get name of the Player.
	 * 
	 */
	
	public String getName() {
		// TODO Auto-generated method stub
		return playerName;
	}
	
	/**
	 * Method to get number of wins of Player.
	 * 
	 */

	@Override
	public int getNumberOfWins() {
		// TODO Auto-generated method stub
		return win;
	}
	
	/**
	 * Method to add  number of wins of that Player.
	 */

	@Override
	public void addWin() {
		// TODO Auto-generated method stub
		win+=1;
		
	}
	
	/**
	 * Method to get the game char of that Player.
	 */

	@Override
	public char getGamePiece() {
		// TODO Auto-generated method stub
		return gameChar;
	}
	
	/**
	 * Method to set the game char of that Player.
	 * 
	 */

	@Override
	public void setGamePiece(char gamePiece) {
		// TODO Auto-generated method stub
		gameChar = gamePiece;
	}
	
	/**
	 * Method to a number to Player to later take turns.
	 * 
	 */
	@Override
	public void setPlayerNumber(int num) {
		// TODO Auto-generated method stub
		playerNumber =  num;
	}

}