package model.entities;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Board{
	
	private int nbCase;
	private LinkedList<Pirate> listePirate= new LinkedList<>();
	private List<Case> cases = new LinkedList<>();
	
	public Board(int nbCase, int nbPlayer) {
		this.nbCase = nbCase;
	}
	

	public Case move(String pirate, int distance) {
                int position = getPlayer(pirate).getPosition();
                int destination =position+distance;
                if(destination<=this.nbCase){
                    getPlayer(pirate).setPosition(destination);
                }else{
                    getPlayer(pirate).setPosition(this.nbCase-(destination-this.nbCase));
                }
                return cases.get(getPlayer(pirate).getPosition());
	}
	
	public int getLocationPlayer(String pirate) {
		return getPlayer(pirate).getPosition();
	}
	
	public void addPlayer(String playerName) {
		listePirate.add(new Pirate(playerName, 5));
	}
        public Pirate getPlayer(String playerName) {
		for(Pirate p : listePirate){
                    if(p.getName().equals(playerName)){
                        return p;
                    }
                }
                return null;
	}
	public int getNbCase() {
		return nbCase;
	}
	
	public void addCase(Case box) {
		cases.add(box);
	}
	
}
