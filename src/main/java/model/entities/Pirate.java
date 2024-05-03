package model.entities;

public class Pirate {
	
	private String name;
	private int hp;
	
	
	public Pirate(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	
	public boolean isDead() {
		return hp <= 0;
	}
	
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

}
