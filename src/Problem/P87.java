package Problem;

import java.util.Arrays;

import MathUtil.PrimeUtil;

public class P87 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int limit = 50000000;
		int squareLimit = (int) Math.floor(Math.sqrt(limit));
		int cubeLimit = (int) Math.floor(Math.cbrt(limit));
		int forthPowerLimit = (int) Math.floor(Math.pow(limit, 1.0/4.0));
		System.out.println(String.format("Limits are: %d, %d, %d", squareLimit, cubeLimit, forthPowerLimit));
		
		int[] squareList = PrimeUtil.genPrimeList(squareLimit);
		int[] cubeList = PrimeUtil.genPrimeList(cubeLimit);
		int[] forthPowerList = PrimeUtil.genPrimeList(forthPowerLimit);
		System.out.println("Prime lists generated...");
		
		for(int index = 0; index < squareList.length; index++)
			squareList[index] = (int) Math.pow(squareList[index],2);
		for(int index = 0; index < cubeList.length; index++)
			cubeList[index] = (int) Math.pow(cubeList[index],3);
		for(int index = 0; index < forthPowerList.length; index++)
			forthPowerList[index] = (int) Math.pow(forthPowerList[index],4);
		System.out.println("Powered lists generated...");
		System.out.println(String.format("Items counts are: %d, %d, %d", squareList.length, cubeList.length, forthPowerList.length));
		
		boolean[] derived = new boolean[limit];
		for(int index = 0; index < limit; index++){
			derived[index] = false;
		}
		
		for(int i : squareList){
			System.out.println(String.format("Calculating %d", i));
			for(int j : cubeList){
				for(int k : forthPowerList){
					if(i + j + k <= limit)
						derived[i+j+k-1] = true;
				}
			}
		}
		
		int count = 0;
		for(int index = 0; index < limit; index++)
			if(derived[index])
				count ++;
		
		
		System.out.println("The result is " + count);
	}

}
