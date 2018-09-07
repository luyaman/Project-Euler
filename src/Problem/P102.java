package Problem;

import MathUtil.CartesianUtil;
import MathUtil.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P102 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Point2D origin, a, b, c;
		origin = new Point2D(0,0);
		int count = 0;
		
		String content = new Scanner(new File("./Files/P102.txt")).useDelimiter("\\Z").next();
		for(String triString : content.split("\n")){
			String[] cordinates = triString.split(",");
			a = new Point2D(Double.parseDouble(cordinates[0]), Double.parseDouble(cordinates[1]));
			b = new Point2D(Double.parseDouble(cordinates[2]), Double.parseDouble(cordinates[3]));
			c = new Point2D(Double.parseDouble(cordinates[4]), Double.parseDouble(cordinates[5]));
			System.out.println(String.format("Triangle is: %s, %s, %s", a.toString(), b.toString(), c.toString()));
			if(CartesianUtil.inTriangle(a, b, c, origin)){
				System.out.println("Origin inside triangle");
				count ++;
			}
		}
		
		System.out.println("The result is: " + count);
	}

}
