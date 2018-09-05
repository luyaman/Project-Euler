package Problem;

import MathUtil.PrimeUtil;

public class P95 {

	public static void main(String[] args) {
		int limit = 1000000;
		int[] post = new int[limit];
		
		for(int index = 0; index  < limit ; index ++)
			post[index] = -1;
		
		System.out.println("Generating primes...");
		int[] primes = PrimeUtil.genPrimeList(limit);
		System.out.println("Generated Primes.");
		
		for(int num = 2; num <= limit; num ++){
			int divisorSum = PrimeUtil.sumProperDivisor(num, primes);
			System.out.println(String.format("Sum of divisor for %d is %d", num, divisorSum));
			if(divisorSum <= limit)
				post[num] = divisorSum;
		}
	}

}
