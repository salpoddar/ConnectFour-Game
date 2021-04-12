/*
 * ConnectFourPlayerInterface.java
 * 
 * Version: 4.1.1
 * 
 * Revisions: 1.1
 * 
 */

/**
 * 
 *  This is Player Interface of ConnectFour Game.
 * 
 * @author ANKITA KHADSARE
 * @author SALONI PODDAR
 *
 */
public interface ConnectFourPlayerInterface {
	int takeTurn();
    String getName();
    int getNumberOfWins();
    void addWin();
    char getGamePiece();
    void setGamePiece(char gamePiece);
    void setPlayerNumber(int num);
}