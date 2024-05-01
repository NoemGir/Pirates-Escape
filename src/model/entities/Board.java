package model.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board {
	
	private int nbCase;
	private Map<String, Integer> location = new HashMap<>();
	//private List<Case> cases = new LinkedList<>();
	
	public Board(int nbCase) {
		this.nbCase = nbCase;
	}

	public Case move(String pirate, int n) {
		return null;
	}
	
	public int getPlayerCase(String pirate) {
		return location.get(pirate);
	}

	public int getNbCase() {
		return nbCase;
	}

	public Map<String, Integer> getLocation() {
		return location;
	}
	
	
}
