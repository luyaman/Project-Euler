package Problem;

import java.lang.reflect.Array;
import java.util.Arrays;

import MathUtil.DigitUtil;
import MathUtil.PrimeUtil;

public class P49 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		int[] l1 = PrimeUtil.genPrimeList(10000);
		int[] l2 = PrimeUtil.genPrimeList(1000);
		
		int[] FourDigPrimes = Arrays.copyOfRange(l1, l2.length, l1.length);
		
		for (int i = 0; i < FourDigPrimes.length; i ++){
			for(int j = i + 1; j < FourDigPrimes.length; j++){
				int lower = FourDigPrimes[i];
				int mid = FourDigPrimes[j];
				int higher = 2*mid - lower;
				if(higher> 9999)
					break;
				else{
					if((DigitUtil.getDigPermutation(lower)!=DigitUtil.getDigPermutation(mid))||(DigitUtil.getDigPermutation(lower)!=DigitUtil.getDigPermutation(higher)))
						continue;
					else if(!PrimeUtil.isPrime(higher))
						continue;
					else
						System.out.println(String.format("Prime permutations found: %d, %d, %d.", lower, mid, higher));
				}
			}
		}
		
		System.out.println("FINISH");
	}

}
