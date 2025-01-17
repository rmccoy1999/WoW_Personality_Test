public class Character {
	
	private String name;
	private int speed;
	private int vertical;
	private int strength;
	private int health;
	private int shield;
	private String quote;

	//  20/50 Preassigned Points
	public Character() {
		
		name = "";
		speed = 10;
		vertical = 10;
		health = 10;
		strength = 10;
		shield = 10;
		
	}
	
	public Character(String n, int s, int v) {	
		name = n;
		speed = s;
		vertical = v;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getVertical() {
		return vertical;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getShield() {
		return shield;
	}

	public void setShield(int shield) {
		this.shield = shield;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	
	
}