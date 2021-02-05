public class Warrior extends Character {
	
	public Warrior() {
		setName(super.getName());
	}

	public int getStrength() {
		return super.getStrength()+3;
	}
	
	public int powerAttack() {
		return getStrength() + 5;
	}
	
	public int getShield() {
		return super.getShield()-1;
	}
	
	public String getQuote() {
		return "See your world through my eyes: A universe so vast as to be immeasurable - incomprehensible even to your greatest minds.";
	}
}