
public class Tester {

	public static void main(String[] args) {
        Human h1 = new Human();
        Human h2 = new Human();

        Samurai s = new Samurai();
        Samurai s1 = new Samurai();
        Samurai s2 = new Samurai();
        Samurai s3 = new Samurai();
        Wizard w = new Wizard();
        Ninja n = new Ninja();
        
        n.attack(s);
        s.deathBlow(n);
        
        //w.displayHealth();
        //w.displayHealthLikeAHuman();
        
        
        //n.displayHealth();
        //s.displayHealth();
        
        System.out.println(w.intelligence);
        w.stripWizardOfIntelli();
        System.out.println("=====================");
        System.out.println(w.intelligence);
        
        
        
        //System.out.println(Samurai.howMany());
        
     
	}

}
