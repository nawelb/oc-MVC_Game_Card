package fr.nawelbp.card_game.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<PlayingCard> cards;
	
	public Hand() {
		cards=new ArrayList<PlayingCard>();
	}
	
	public void addCards(PlayingCard card) {
		cards.add(card);
	}
	
	public PlayingCard getCard(int index) {
		return cards.get(index);
	}
	
	public PlayingCard removeCard() {
		return cards.remove(0);
	}
}
