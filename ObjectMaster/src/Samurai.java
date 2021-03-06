
public class Samurai extends Human {
    private static int numSamurai = 0;
    private static int defaultHealth = 200;
    
    public static int howMany() {
        return Samurai.numSamurai;
    }
    
    public Samurai() {
        this.health = Samurai.defaultHealth;
        numSamurai += 1;
    }
    
    public void deathBlow(Human target) {
        target.health = 0;
        this.health = (this.health/2);
    }
    
    public void meditate() {
        this.health = Samurai.defaultHealth;
    }
    
    public void displayHealth() {
    	System.out.println("A Samurai is always at full health");
    	super.displayHealth();
    }
    
    
}