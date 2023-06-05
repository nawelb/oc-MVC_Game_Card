package fr.nawelbp.card_game.game;

import java.util.List;

import fr.nawelbp.card_game.model.Player;
import fr.nawelbp.card_game.model.PlayingCard;

public interface GameEvaluator {

	public Player evaluateWinner(List<Player> players);
}
