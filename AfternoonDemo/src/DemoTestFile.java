import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DemoTestFile {

	public static void main(String[] args) {

		ArrayList<String> words1 = new ArrayList<String>();
		words1.add("one");
		words1.add("hello");
		words1.add("dog");
		words1.add("cow");
		words1.add("jewelry");
		
		// String[] words = {"dog", "cat", "fish"};

		Random r = new Random();
		
		// System.out.println(r.nextInt()); 
		System.out.println(r.nextInt(51)); 

	}

}
