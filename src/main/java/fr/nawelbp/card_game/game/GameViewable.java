package fr.nawelbp.card_game.game;
import fr.nawelbp.card_game.controller.GameController;

public interface GameViewable {
	
	
	public void setController(GameController gameControl);
	public void promptPlayerName();
	public void promptForFlip();
	public void promptForNewGame();
	public void showPlayerName(int playerIndex, String playerName);
	public void showFaceDownCardForPlayer(int playerIndex, String playerName);
	public void showCardForPlayer(int i, String playerName, String rank, String suit);
	public void showWinner(String name);
	
}
