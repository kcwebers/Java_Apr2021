
public class Human {
    int strength = 3;
    int stealth = 3;
    int intelligence = 3;
    int health = 100;
    
    public void attack(Human target) {
        target.health -= this.strength;
    }
    
    public void displayHealth() {
    	System.out.println("Health = " + this.health);
    }

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getStealth() {
		return stealth;
	}

	public void setStealth(int stealth) {
		this.stealth = stealth;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
    
    
}
