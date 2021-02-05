public class Healer extends Character {
	
	public Healer() {
		setName(super.getName());
	}
	
	public int Restore() {
		return getHealth() + 2;
	}
	
	public int getHealth() {
		return super.getHealth() + 3;
	}
	
	public int getShield() {
		return super.getShield() - 1;	
	}
	
	public String getQuote() {
		return "No wound ever goes away until it has taught us what we need to know.";
	}
}