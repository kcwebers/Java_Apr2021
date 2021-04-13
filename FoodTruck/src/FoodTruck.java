public class FoodTruck {
    public static void main(String[] args) {

        System.out.println("This is the food truck!");

        Taco t = new Taco();
       // t.tacoIntro();

        Taco t2 = new Taco("Flour", "Chicken", "Mexican Blend", "Guacamole", "Salsa Verde");
       // t2.tacoIntro();

        Taco t3 = new Taco("Corn", "Beef", "Mexican Blend");
        t3.tacoIntro();
        t3.sauce = "Mole";
        t3.setProtein("Carne Asada");
        System.out.println(t3.getProtein());
        t3.tacoIntro();

        //Taco t4 = new Taco("Corn", "Pork", "Jack");
       // t4.tacoIntro();

    }
}