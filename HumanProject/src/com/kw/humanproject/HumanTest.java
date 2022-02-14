package com.kw.humanproject;

public class HumanTest {
	public static void main(String[] args) {
		
		Human sbeve = new Human("Sbeve Tyler", 37);
        Human rafaelangelo = new Human("Rafaelangelo Turtle", 22);
        Human bobothy = new Human("Bobothy Jones", 45);

//        System.out.println(sbeve.getName() + " " + sbeve.getHealth());
//        System.out.println(rafaelangelo.getName() + " " + rafaelangelo.getHealth());
//        System.out.println(bobothy.getName() + " " + bobothy.getHealth());
        
//        System.out.println("The number of humans is: " + Human.getAllHumans());

        sbeve.eat(7);
//        System.out.println(sbeve.getName() + " " + sbeve.getHealth());

        bobothy.getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned().getPoisoned();
//        System.out.println(bobothy.getName() + " " + bobothy.getHealth());
        bobothy.pastaAndCreamSauce();
//        System.out.println(bobothy.getName() + " " + bobothy.getHealth());

        rafaelangelo.attack(sbeve);
//        System.out.println(sbeve.getName() + " " + sbeve.getHealth());

        System.out.println(sbeve.isWarmBlooded());
        sbeve.walks();
        sbeve.waves();
        
        Samurai mugen = new Samurai();
        mugen.movesForward();
	}

}
