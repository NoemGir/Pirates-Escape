package model.entities;

public class Pirate {
	
	private String name;
	private int hp = 6;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public Pirate(String name) {
		this.name = name;
	}
}
