package model.entities;

import java.util.function.Function;

public class Pirate {
	private Integer position;
	private String name;
	private Integer hp;


	public Pirate(String name, Integer hp) {
		this.name = name;
		this.hp = hp;
	}


	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pirate) {
			Pirate pirate = (Pirate) obj;
			return this.name.equals(pirate.name)
				&& this.getHp().equals(pirate.getHp())
				&& this.getPosition().equals(pirate.getPosition());
		}
		return false;
	}


	public void ajustHp(Function<Integer, Integer> f) {
		this.hp = f.apply(this.hp);
	}
	public void ajustPosition(Function<Integer, Integer> f) {
		this.position = f.apply(this.position);
	}


	public boolean isDead() {
		return hp <= 0;
	}


	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}

	public Integer getHp() {
		return hp;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
