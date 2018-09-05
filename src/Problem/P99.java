package Problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P99 {
	public static void main(String[] args) throws FileNotFoundException{
		@SuppressWarnings("resource")
		String content = new Scanner(new File("./Files/P99.txt")).useDelimiter("\\Z").next();
		String[] txtPairs = content.split("\n");
		int[] bases = new int[txtPairs.length];
		int[] powers = new int[txtPairs.length];
		
		int index = 0;
		for(String pair:txtPairs){
			String[] list = pair.split(",");
			bases[index] = Integer.parseInt(list[0]);
			powers[index] = Integer.parseInt(list[1]);
			index ++;
		}
		
		double max = 0, cur = 0;
		int line = 0;
		for(index = 0; index < bases.length; index++){
			cur = Math.log(bases[index])*powers[index];
			System.out.println(String.format("Values: %d, %d --> %f", bases[index], powers[index], cur));
			if(cur > max){
				max  = cur;
				line = index + 1;
			}
		}
		System.out.println("The result is: " + line);
	}
}
