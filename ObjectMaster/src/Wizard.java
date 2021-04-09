
public class Wizard extends Human {
	int intelligence = 8;
	
    public Wizard() {
        this.health = 50;
        //this.intelligence = 8;
    }

    public void heal(Human target) {
        target.health += this.intelligence;
    }

    public void fireball(Human target) {
        target.health -= (this.intelligence * 3);
    }
    
    public void stripWizardOfIntelli() {
    	this.intelligence = super.intelligence;
    }
    


    
}