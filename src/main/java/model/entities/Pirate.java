package model.entities;

import java.util.function.Function;

public class Pirate {
        private int idPirate;
	private Integer position = 0;
	private String name;
	private Integer hp;


	public Pirate(int idPirate, String name, Integer hp) {
            this.idPirate = idPirate;
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
                if(this.hp>5){
                    this.hp = 5;
                }
                if(this.hp<0){
                    this.hp = 0;
                }
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

    public int getIdPirate() {
        return idPirate;
    }
        
        

}
