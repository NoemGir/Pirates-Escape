package model.entities;

import java.util.LinkedList;
import java.util.List;

public class Board{
	
	private int nbCase;
	private LinkedList<Pirate> listPirate = new LinkedList<>();
	private List<Case> cases = new LinkedList<>();
	
	public Board(int nbCase, int nbPlayer) {
		this.nbCase = nbCase;
	}
	

	public Case move(String pirate, int distance) {
                int position = getPlayer(pirate).getPosition();
                System.out.println("players " + pirate +" : position = " + position + " desination = " + (position + distance));
                int destination = position + distance;
                if(destination < this.nbCase){
                    getPlayer(pirate).setPosition(destination);
                }else{
                    getPlayer(pirate).setPosition(this.nbCase-(destination-this.nbCase)-2);
                }
                return cases.get(getPlayer(pirate).getPosition());
	}
	
	public int getLocationPlayer(String pirate) {
		return getPlayer(pirate).getPosition();
	}
	
	public void addPlayer(Pirate player) {
		listPirate.add(player);
	}
        public Pirate getPlayer(String playerName) {
		for(Pirate p : listPirate){
                    if(p.getName().equals(playerName)){
                        return p;
                    }
                }
                return null;
	}

    public LinkedList<Pirate> getListPirate() {
        return listPirate;
    }
        
	public int getNbCase() {
		return nbCase;
	}
	
	public void addCase(Case box) {
		cases.add(box);
	}
	
}
