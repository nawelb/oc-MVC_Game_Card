package fr.nawelbp.card_game.game;

import fr.nawelbp.card_game.controller.GameController;
import fr.nawelbp.card_game.model.Deck;
import fr.nawelbp.card_game.view.View;

/**
 * Hello world!
 *
 */
public class Game 
{
	
    public static void main( String[] args ){
        GameSwingView gsv=new GameSwingView();
        gsv.createAndShowGUI();
        
    	//GameController gameController = new GameController(new Deck(), new View(), new HighCardGameEvaluator());
    	GameController gameController = new GameController(new Deck(), gsv , new LowCardGameEvaluator());
        gameController.run();
    }
}
