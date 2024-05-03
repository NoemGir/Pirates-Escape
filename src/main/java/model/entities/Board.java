package model.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board{
	
	private int nbCase;
	private Map<String, Integer> location = new HashMap<>();
	private List<Case> cases = new LinkedList<>();
	
	public Board(int nbCase, int nbPlayer) {
		this.nbCase = nbCase;	
	}
	

	public Case move(String pirate, int distance) {
		int locationPirate = location.get(pirate);
		int destination = locationPirate + distance;
		
		if( destination < nbCase) {
			location.put(pirate, destination); 
		} 
		else {
			location.put(pirate, 2*(nbCase-1) - distance - locationPirate);
		}
		return cases.get(location.get(pirate));
	}
	
	public int getLocationPlayer(String pirate) {
		return location.get(pirate);
	}
	
	public void addPlayer(String playerName) {
		location.put(playerName, 0);
		
	}

	public int getNbCase() {
		return nbCase;
	}

	public Map<String, Integer> getLocation() {
		return location;
	}
	
	public void addCase(Case box) {
		cases.add(box);
	}
	
}
