package fibonacci;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static void main(String[] args) {
		// this number represents the quantity of numbers from the Fibonacci sequence to
		// be printed.
		printFibonacci(10);
	}

	static int i = 0;
	static Map<Integer, Integer> mapFib = new HashMap<>();

	/**
	 * Print fibonacci
	 * 
	 * @param n
	 */
	private static void printFibonacci(int n) {
		while (i < n) {
			if (i < 2) {
				mapFib.put(i, i);
			} else {
				mapFib.put(i, (mapFib.get(i - 1) + mapFib.get(i - 2)));
			}
			System.out.println(mapFib.get(i));
			printFibonacci(++i);
		}
	}

}
