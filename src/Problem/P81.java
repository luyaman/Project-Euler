package Problem;

import MathUtil.CartesianUtil;
import MathUtil.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P81 {
	public static void main(String[] args) throws FileNotFoundException {
		int size = 80;
		int arr[][] = new int[size][size];
		
		String content = new Scanner(new File("./Files/P81.txt")).useDelimiter("\\Z").next();
		int row = 0, col = 0;
		for(String rowString: content.split("\n")){
			col = 0;
			String[] nums = rowString.split(",");
			for(String num : nums){
				arr[row][col] = Integer.parseInt(num);
				col ++;
			}
			row++;
		}
		
		int min[][] = new int[size][size];
		min[size-1][size-1] = arr[size-1][size-1];
		// initiate last row
		for(col = size - 2; col >= 0; col --){
			min[size-1][col] = min[size-1][col+1] + arr[size-1][col];
		}
		
		// filling in row above
		for(row = size -2; row >=0; row --){
			min[row][size-1] = min[row+1][size-1] + arr[row][size-1];
			for(col = size - 2; col >= 0; col --){
				min[row][col] = Math.min(min[row][col+1], min[row+1][col]) + arr[row][col];
			}
		}
		
		System.out.println("Result is: " + min[0][0]);
	}

}
