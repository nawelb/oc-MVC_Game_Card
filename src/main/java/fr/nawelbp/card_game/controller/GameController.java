package fr.nawelbp.card_game.controller;

import java.util.ArrayList;
import java.util.List;

import fr.nawelbp.card_game.game.GameEvaluator;
import fr.nawelbp.card_game.model.Deck;
import fr.nawelbp.card_game.model.Player;
import fr.nawelbp.card_game.model.PlayingCard;
import fr.nawelbp.card_game.view.View;


public class GameController {
	enum GameState{
		AddingPlayers, 
		CardsDealt, 
		WinnerRevealed;
	}
	Deck deck;
	List<Player> players;
	Player winner;
	View view;
	GameState gameState;
	GameEvaluator gameEvaluator;
	
	public GameController (Deck deck, View view, GameEvaluator evaluator) {
		super();
		this.deck = deck;
		this.view = view;
		this.players=new ArrayList<Player>();
		this.gameState=GameState.AddingPlayers;
		view.setController(this);
		this.gameEvaluator=evaluator;
	}
	
	public void run() {
		while(gameState== GameState.AddingPlayers) {
			view.promptPlayerName();
		}
		switch (gameState) {
		case CardsDealt:
			view.promptForFlip();
			break;
		case WinnerRevealed:
			view.promptForNewGame();
			break;
		}
	}
	
	public void addPlayer (String playerName) {
		if (gameState==GameState.AddingPlayers) {
			players.add(new Player(playerName));
			view.showPlayerName(players.size(), playerName);
		}
	}
	
	public void startGame() {
		if(gameState!=GameState.CardsDealt) {
			deck.shuffle();
			int playerIndex=1;
			for(Player player :players) {
				player.addCardToHand(deck.removeTopCard());
				view.showFaceDownCardForPlayer(playerIndex++,player.getName());
			}
			gameState= GameState.CardsDealt;
		}
		this.run();
	}
	
	void evaluateWinner() {
		winner=gameEvaluator.evaluateWinner(players);
	}
	public void flipCards() {
		for (Player player : players) {
			PlayingCard pc = player.getCard(0);
			int playerIndex=1;
			pc.flip();
			view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
			
		}

		evaluateWinner();
		displayWinner();
		rebuildDeck();
		gameState = GameState.WinnerRevealed;
		this.run();
	}

	

	void displayWinner() {
		view.showWinner(winner.getName());
	}

	void rebuildDeck() {
		for (Player player : players) {
			deck.returnCardToDeck(player.removeCard());
		}
	}
}
