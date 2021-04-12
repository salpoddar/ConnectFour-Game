/*
 * ConnectFourGame.java
 * 
 * Version: 4.1.1
 * 
 * Revisions: 1.1
 * 
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * This program is to implement ConnectFour Game between two Human Player.   
 * 
 * @author ANKITA KHADSARE
 * @author SALONI PODDAR
 *
 */

public class ConnectFourGame implements ConnectFourGameInterface {

	public static ConnectFourPlayerInterface firstPlayer;
	public static ConnectFourPlayerInterface secondPlayer;
	int column=0, flag=0;
	char gameMatrix[][] = new char[6][7];
	String pattern1,pattern2;
	
/**
 * Parameterised constructor of ConnectFourGame class.
 * 
 * @param player1
 * @param player2
 */
	
	public ConnectFourGame(ConnectFourPlayerInterface player1, ConnectFourPlayerInterface player2) {
		 this.firstPlayer = player1;
		 this.secondPlayer = player2;
	}
	
	/**
	 * Method to basically get statistics for two players that is nothing 
	 * but number of wins for every respective and print it at the end of 
	 * every game that is called from Driver.
	 * 
	 */
	
	public void getStats() {
		System.out.println(firstPlayer.getName()+" (Player "+firstPlayer.takeTurn()+
					") has "+ firstPlayer.getNumberOfWins()+" wins and "+
					secondPlayer.getName()+" (Player "+secondPlayer.takeTurn()+
					") has "+ secondPlayer.getNumberOfWins()+" wins.");			
	}
	
	/**
	 * Method to implement main logic for playing game that is being called in driver.
	 * 
	 */
	
	public void playGame() {	
		Scanner sc = new Scanner(System.in);
		try {
		System.out.println(firstPlayer.getName() + " select a single char game piece");
		firstPlayer.setGamePiece(sc.next().charAt(0));
		firstPlayer.setPlayerNumber(1);
		System.out.println( secondPlayer.getName()+" select a single char game piece");
		secondPlayer.setGamePiece(sc.next().charAt(0));
		secondPlayer.setPlayerNumber(2);
		System.out.println("Welcome to Connect Four!");
		pattern1="";pattern2="";
		//Adding elements to matrix
		createGameMatrix();
		
		//Printing matrix
		printGameMatrix();
		
		//creating pattern
		createPattern();
		
		// Starting to Play
		while(flag==0) { 
			System.out.println("Player " + firstPlayer.takeTurn()+" : "+ firstPlayer.getName()+" select a column");
			column = sc.nextInt() ;
			updateMatrix(firstPlayer.getGamePiece());
			printGameMatrix();
			if(checkFirstPlayer()) {
				firstPlayer.addWin();
				System.out.println(firstPlayer.getName() + " has won the game.");
				flag=1;	
				break;
			}
			System.out.println("Player " + secondPlayer.takeTurn()+" : "+ secondPlayer.getName()+" select a column");
			column = sc.nextInt() ;
			updateMatrix(secondPlayer.getGamePiece());
			printGameMatrix();
			if(checkSecondPlayer()) {
				secondPlayer.addWin();
				System.out.println(secondPlayer.getName() + " has won the game.");
				flag=1;
				break;
			}
			
		}
		String choice="";
		System.out.println("Would you like to play again?y/n");
		choice= sc.next();
		if(choice.equalsIgnoreCase("y")) {
			flag=0;
			choice="";
			playGame();
		}	
		}
		catch(Exception e) {
			System.out.println("Invalid Input. Expected column number between 0-6");
			System.out.println(e);
		}
	}
	
	/**
	 * Method to create game matrix through 2D array.
	 * 
	 */
	
	public void createGameMatrix() {
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				gameMatrix[i][j]='.';
			}
		}
	}
	
	/**
	 * Method to print the game matrix(2D array).
	 * 
	 */
	
	public void printGameMatrix(){
		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				System.out.print(gameMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Method to create wining pattern for both the players.
	 * 
	 */
	
	public void createPattern() {
		for(int i=0;i<4;i++) {
			pattern1+=firstPlayer.getGamePiece();
			pattern2+=secondPlayer.getGamePiece();
		}
		System.out.println(pattern1);
		System.out.println(pattern2);
	}
	
	/**
	 * Method to check if wining pattern is created for first player in 
	 * game matrix horizontally/vertically/diagonally.
	 * 
	 * @return Returns True if wining pattern is found in any direction(
	 * 					horizontally/vertically/diagonally)
	 * 					False if wining pattern is not found in any direction(
	 * 					horizontally/vertically/diagonally)
	 */
	
	public boolean checkFirstPlayer() {
		if(checkHorizontal(gameMatrix,pattern1) || checkVertical(gameMatrix,pattern1) || checkDiagonalRL(gameMatrix,pattern1) || checkDiagonalLR(gameMatrix,pattern1)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method to check if wining pattern is created for second player in 
	 * game matrix horizontally/vertically/diagonally.
	 * 
	 * @return Returns True if wining pattern is found in any direction(
	 * 					horizontally/vertically/diagonally)
	 * 					False if wining pattern is not found in any direction(
	 * 					horizontally/vertically/diagonally)
	 */
	
	public boolean checkSecondPlayer() {
		if(checkHorizontal(gameMatrix,pattern2) || checkVertical(gameMatrix,pattern2) || checkDiagonalRL(gameMatrix,pattern2) || checkDiagonalLR(gameMatrix,pattern2)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Method to check if the pattern is present or not. 
	 * It uses Pattern and Matcher Class to verify the word.
	 *  
	 * @param s String in which the pattern is searched in forward direction.
	 * @param word pattern that needs to be searched.
	 * @return Returns true if pattern is found else false.
	 */
	
	public boolean isPresent(String s,String word) {
		Pattern pattern=Pattern.compile(word);
		Matcher matcher1=pattern.matcher(s);
		if(matcher1.find() ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 *  Method to search the pattern in horizontal manner in game matrix.
	 *  
	 * @param gameMatrix 2D array that stores every game character.
	 * @param word Pattern that needs to be searched.
	 * @return Returns flag value that can be true if pattern is found else false.
	 */
	
	public boolean checkHorizontal(char gameMatrix[][],String word) {
		String s="";
		int i=0,j=0;
		for(i=0;i<6;i++) {
			for(j=0;j<7;j++) {
				s+=gameMatrix[i][j];
			}
			if(isPresent(s,word)) {
				return true;
			}
			s="";
		}
		return false;
	}
	
	/**
	 *  Method to search the pattern in vertical manner in game matrix.
	 *  
	 * @param gameMatrix 2D array that stores every game character.
	 * @param word Pattern that needs to be searched.
	 * @return Returns flag value that can be true if pattern is found else false.
	 */
	
	public boolean checkVertical(char gameMatrix[][],String word) {
		String s="";
		int i=0,j=0;
		while(j<7) {
			for(i=0;i<6;i++) {
				s+=gameMatrix[i][j];
			}
			if(isPresent(s,word)) {
				return true;
			}
			s="";
			j++;
		}
		return false;
	}
	
	/**
	 *  Method to search the pattern in diagonal(top right to bottom left) 
	 *  manner in game matrix.
	 *  
	 * @param gameMatrix 2D array that stores every game character.
	 * @param word Pattern that needs to be searched.
	 * @return Returns flag value that can be true if pattern is found else false.
	 */
	public boolean checkDiagonalRL(char gameMatrix[][],String word) {
		String s="";
		//top right to bottom left
		for(int i=0;i<6*2-1;++i) {
			int k=i<7?0:i-7+1;
			for(int j=k;j<=i-k;++j) {
				int m=j;
				int n=(7-1)-(i-j);
				if(m<6 && n<7) {
					s+=gameMatrix[m][n];
				}
			}
			if(isPresent(s,word)) {
				System.out.println("Its RL");
				return true;
			}
			s="";
		}
		return false;
	}
	
	/**
	 *  Method to search the pattern in diagonal(top left  to bottom left right) 
	 *  manner in game matrix.
	 *  
	 * @param gameMatrix 2D array that stores every game character.
	 * @param word Pattern that needs to be searched.
	 * @return Returns flag value that can be true if pattern is found else false.
	 */
	
	public boolean checkDiagonalLR(char gameMatrix[][],String word) {
		String s="";
		//top left to bottom right
		for(int i=0;i<6*2-1;++i) {
			int k=i<7?0:i-7+1;
			for(int j=k;j<=i-k;++j) {
				int m=j;
				int n=i-j;
				if(m<6 && n<7) {
					s+=gameMatrix[m][n];
				}
			}
			if(isPresent(s,word)) {
				return true;
			}
			s="";
		}
		return false;
	}
	
	/**
	 * Method to update game matrix after every players move 
	 * with respective character.
	 * @param gameChar char with which the matrix needs to updated. 
	 */
	
	public void updateMatrix(char gameChar) {
		for(int i=0;i<6;i++) {
			if(gameMatrix[i][column]!='.' && i<=5) {
				if(i==0){
					System.out.println("Please choose another column");
				}
				else {
					gameMatrix[i-1][column]=gameChar;
					break;
				}
			}
			else if(gameMatrix[i][column]=='.' && i==5) {
				gameMatrix[i][column]=gameChar;					
			}
		}
	}	
}