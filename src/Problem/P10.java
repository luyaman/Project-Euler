package Problem;

import MathUtil.PrimeUtil;

public class P10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 2000000;
		
		int[] primes = PrimeUtil.genPrimeList(limit);
		System.out.println("Primes generated...");
		
		long result = 0;
		for(int prime: primes)
			result = result + prime;
		System.out.println("Result is " + result);
	}

}
