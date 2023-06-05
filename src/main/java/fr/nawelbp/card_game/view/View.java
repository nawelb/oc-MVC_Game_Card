package fr.nawelbp.card_game.view;

import java.util.Scanner;

import fr.nawelbp.card_game.controller.GameController;

public class View {
	
		GameController controller;
		Scanner keyboard = new Scanner(System.in);
		
		public void setController(GameController gameControl) {
		this.controller=gameControl;
		}
		public void promptPlayerName() {
			System.out.println("Enter Player Name : ");	
			String name=keyboard.nextLine();
			if(name.isEmpty()) {
				controller.startGame();
			}else {
				controller.addPlayer(name);
			}
		}
		public void promptForFlip() {
			System.out.println("Press enter to reveal cards.");
			keyboard.nextLine();
			controller.flipCards();
		}
		public void promptForNewGame() {
			System.out.println("Press enter to deal again");
			keyboard.nextLine();
			controller.startGame();
			
		}
		public void showPlayerName(int playerIndex, String playerName) {
			System.out.println("["+playerIndex+"]["+playerName+"]");
		}
		public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
			System.out.println("["+playerIndex+"]["+playerName+"][X][X]");			
		}
		public void showCardForPlayer(int i, String playerName, String rank, String suit) {
			System.out.println("["+i+"]["+playerName+"]["+rank+"]["+suit+"]");			
		}
		public void showWinner(String name) {
			System.out.println("Winner is "+ name + " !");			
		}

}
