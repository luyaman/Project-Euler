package Problem;

import MathUtil.PrimeUtil;

public class P72 {
	public static void main(String[] args){
		System.out.println("Generating primes...");
		int[] primes = PrimeUtil.genPrimeList(1000000);
		System.out.println("Primes generated.");
		
		long acc = 0;
		for(int d = 2; d <= 1000000; d++){
			acc = acc + PrimeUtil.countCoprime(d, primes);
		}
		
		System.out.println("Result is: " + acc);
	}
}
