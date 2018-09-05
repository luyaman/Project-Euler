package MathUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeUtil {

	public static boolean isPrime(int num) {
		boolean result = true;
		for (int i = 2; i <= Math.floor(Math.sqrt(num)); i++) {
			if ((num % i) == 0) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static int[] genPrimeList(int limit) {
		if (limit == 1)
			return new int[] {};
		if (limit == 2)
			return new int[] { 2 };

		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);

		for (int i = 3; i <= limit; i++) {
			boolean isPrime = true;

			for (Integer factor : primes) {
				if ((i % factor) == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime)
				primes.add(i);
		}

		int[] result = new int[primes.size()];
		for (int index = 0; index < primes.size(); index++)
			result[index] = primes.get(index);
		return result;
	}

	public static int genNextPrime(ArrayList<Integer> primeList) {
		int num = primeList.size()==1 ? primeList.get(primeList.size()-1) + 1 : primeList.get(primeList.size()-1) + 2;

		while (true) {
			boolean isPrime = true;
			for (int factor : primeList) {
				if ((num % factor) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime){
				primeList.add(num);
				return num;
			}
			else {
				if (num == 2)
					num = num + 1;
				else
					num = num + 2;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(sumProperDivisor(12, new int[]{2,3,5,7,13}));
	}
	
	public static int countCoprime(int num, int[] primes){
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for(int prime: primes){
			if(prime > num)
				break;
			else{
				if((num%prime)==0)
					primeFactors.add(prime);
			}
		}
		int result = num;
		for(int factor: primeFactors)
			result = result / factor * (factor - 1);
		return result;
	}
	
	public static int sumProperDivisor(int num, int[] primes){
		int term = 1, acc = 1, result = 1, temp = 1;
		ArrayList<Integer> primeFactors = new ArrayList<Integer>();
		for(int prime: primes){
			if(prime > num)
				break;
			else{
				term = acc = 1;
				temp = num;
				while((temp%prime)==0){
					term = term * prime;
					acc = acc + term;
					temp = temp / prime;
				}
				result = result * acc;
			}
		}
		result = result - num;
		return result;
	}
	
	public static int findGCF(int large, int small){
		if(small == 0) return large;
		if(small == 1) return 1;
		return findGCF(small, large%small);
	}

}
