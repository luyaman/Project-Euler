package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import MathUtil.PrimeUtil;

public class P95 {

	public static void main(String[] args) {
		int limit = 1000000;

		System.out.println("Generating primes...");
		int[] primes = PrimeUtil.genPrimeList(limit);
		System.out.println("Generated Primes.");

		ArrayList<Integer> chain = new ArrayList<Integer>();
		boolean[] visited = new boolean[limit];
		for (int index = 0; index < limit; index++)
			visited[index] = false;

		int num = 2, divisorSum = 0, temp = 0, longest = 1, longestMin = 0;
		for (num = 2; num <= limit; num++) {
			System.out.println("Processing: " + num);
			if (!visited[num - 1]) {
				visited[num - 1] = true;
				chain.clear();
				chain.add(num);
				divisorSum = PrimeUtil.sumProperDivisor(num, primes);
				// if not visited --> visit the number
				while (divisorSum <= limit && divisorSum > 0 && !visited[divisorSum - 1]) {
					visited[divisorSum - 1] = true;
					temp = divisorSum;
					chain.add(temp);
					divisorSum = PrimeUtil.sumProperDivisor(temp, primes);
				}
				// check for chain
				if (divisorSum > 0 && divisorSum <= limit && visited[divisorSum - 1]) {
					if (chain.indexOf(divisorSum) != -1) {
						int length = chain.size() - chain.indexOf(divisorSum);
						if (length > longest) {
							System.out.print("Longer chain found: ");
							length = longest;
							for (int i = chain.indexOf(divisorSum); i < chain.size(); i++){
								System.out.print(chain.get(i));
								System.out.print(" --> ");
							}System.out.println("");
							longestMin = (int) Collections.min(chain.subList(chain.indexOf(divisorSum), chain.size()-1));
							System.out.println("Min value in chain is: " + longestMin);
							
						}
					}
				}
			}
		}
	}

}
