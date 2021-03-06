import com.kw.coffeeoop.abstracts.Coffee;
import com.kw.coffeeoop.classes.Americano;
import com.kw.coffeeoop.classes.IcedLatte;

public class CoffeeTester {

	public static void main(String[] args) {
		Americano order1 = new Americano("Light");
		Americano order2 = new Americano("Light");
		
		IcedLatte order4 = new IcedLatte("Medium");
		IcedLatte order5 = new IcedLatte("Dark");
		IcedLatte order6 = new IcedLatte("Medium-Light");
		
		System.out.println(order4.getCost());
		System.out.println(order5.getCost());
		System.out.println(order6.getCost());
		
		System.out.println("==========================");
		order4.setCost(5.5);
		System.out.println("==========================");
		
		System.out.println(order4.getCost());
		System.out.println(order5.getCost());
		System.out.println(order6.getCost());
		
	}
}
