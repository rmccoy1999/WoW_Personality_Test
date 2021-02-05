
public class Tank extends Character {
	
	public Tank() {
		setName(super.getName());
	}

	public int getShield() {
		return super.getShield()+5;
	}
	
	public int getSpeed() {
		return super.getSpeed() - 2;	
	}
	public int Absorb() {
		return getShield()+3;
	}
	
	public String getQuote() {
		return "The longer you insist upon confronting me, the more angonizing you will find defeat";
	}
}
