public class Taco {
    private String tortilla = "Flour";
    private String protein = "Mahi Mahi";
    String cheese = "Cheddar";
    String sauce;
    String toppings;

    public String getTortilla() {
        return tortilla;
    }
    public void setTortilla(String tortilla) {
        this.tortilla = tortilla;
    }
    public String getProtein() {
        return protein;
    }
    public void setProtein(String protein) {
        this.protein = protein;
    }






    public Taco() {
    }
    public Taco(String tortilla) {
        this.tortilla = tortilla;
    }
    public Taco(String tortilla, String protein) {
        this.tortilla = tortilla;
        this.protein = protein;
    }
    public Taco(String tortilla, String protein, String cheese) {
        this.tortilla = tortilla;
        this.protein = protein;
        this.cheese = cheese;
    }
    public Taco(String tortilla, String protein, String cheese, String sauce) {
        this.tortilla = tortilla;
        this.protein = protein;
        this.cheese = cheese;
        this.sauce = sauce;
    }
    public Taco(String tortilla, String protein, String cheese, String sauce, String toppings) {
        this.tortilla = tortilla;
        this.protein = protein;
        this.cheese = cheese;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    public void tacoIntro() {
        System.out.println("My taco: tortilla - " + this.tortilla + ", protein - " + this.protein + ", cheese - " + this.cheese + ", sauce - " + this.sauce + ", toppings - " + this.toppings);
    }
}
