package Problem;

import java.util.ArrayList;
import java.util.Arrays;

import IOUtil.FileUtil;

public class P79 {
	public static void main(String[] args){
		String attemptsString = FileUtil.readFile("P79.txt");
		
		int size = attemptsString.length();
		ArrayList<int[]> attempts = new ArrayList<int[]>();
		
		for(int index = 0; index < size; index = index + 3){
			String subString = attemptsString.substring(index, index+3);
			int[] subList = new int[3];
			subList[0] = Integer.parseInt(subString.substring(0,1));
			subList[1] = Integer.parseInt(subString.substring(1,2));
			subList[2] = Integer.parseInt(subString.substring(2,3));
			attempts.add(subList);
			System.out.println(Arrays.toString(subList));
		}
		
		System.out.println("Read attempts.");
		
	}
}
