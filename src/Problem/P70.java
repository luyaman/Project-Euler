package Problem;

import MathUtil.DigitUtil;
import MathUtil.PrimeUtil;

public class P70 {

	private static final int coPrimeCount = 0;

	public static void main(String[] args) {
		int curN = 9999;
		int curF = 1;
		
		int[] primes = PrimeUtil.genPrimeList(1000000);
		System.out.println("Primes generated...");
		
		for(int n = 3; n < 10000000; n ++){
			System.out.println(n);
			int coPrimeNum = PrimeUtil.countCoprime(n, primes);
			if(DigitUtil.getDigPermutation(n)==DigitUtil.getDigPermutation(coPrimeNum)){
				if((long)curN*coPrimeNum > (long)n*curF){
					curN = n;
					curF = coPrimeCount;
				}
			}
		}
		
		System.out.println(String.format("Result is %d, %d", curN, curF));

	}

}
