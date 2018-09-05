package Problem;

import java.util.Arrays;

import MathUtil.DigitUtil;

public class P97 {
	public static void main(String[] args){
		int[] digits = new int[]{0,0,0,0,0,0,0,0,0,2};
		for (int count = 0; count < 7830457; count ++){
			DigitUtil.digMultiplication(digits, 2);
			System.out.println(String.format("%d multiplication: %s", count + 1, Arrays.toString(digits)));
		}
		DigitUtil.digMultiplication(digits, 28433);
		System.out.println("The result is; " + Arrays.toString(digits));
	}
}
