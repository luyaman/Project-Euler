package Problem;

import java.util.ArrayList;

import MathUtil.PrimeUtil;

public class P60 {
	
	private static int combineIntegers(int num1, int num2){
		String concat = Integer.toString(num1) + Integer.toString(num2);
		int combined = Integer.parseInt(concat);
		return combined;
	}
	
	private static boolean checkList(ArrayList<Integer> list, int num){
		boolean result = true;
		for(int i:list){
			if(!PrimeUtil.isPrime(combineIntegers(i, num)) || !PrimeUtil.isPrime(combineIntegers(num,i))){
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		
		ArrayList<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>();
		
		find: while(true){
			int prime = PrimeUtil.genNextPrime(primes);
			
			ArrayList<ArrayList<Integer>> newPairs = new ArrayList<ArrayList<Integer>>(pairs);
			
			for(ArrayList<Integer> curList : pairs){
				if(checkList(curList, prime)){
					ArrayList<Integer> newList = new ArrayList<>(curList);
					newList.add(prime);
					if(newList.size() == 5){
						int sum = 0;
						for(int num : newList)
							sum = sum + num;
						System.out.println("Sum is: " + sum);
						break find;
					}else
						newPairs.add(newList);
				}
			}
			
			pairs = newPairs;
			
			ArrayList<Integer> newList = new ArrayList<Integer>();
			newList.add(prime);
			pairs.add(newList);
		}
		
		System.out.println("FINISH......");

	}

}
