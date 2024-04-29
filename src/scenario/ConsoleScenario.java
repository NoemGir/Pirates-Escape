package scenario;

import boundary.PirateGameBoundary;
import control.PirateGameControl;

/*
 *  Ici, on poura lancer l'application en mode console
 * 
 */
public class ConsoleScenario {
	
	PirateGameBoundary pirateGameBoundary = new PirateGameBoundary();
	PirateGameControl pirateGameControl = new PirateGameControl(pirateGameBoundary);
	
	PirateGameControl.startGame();
}
