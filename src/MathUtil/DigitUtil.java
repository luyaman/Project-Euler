package MathUtil;

import java.util.Arrays;
import java.util.Collections;

public class DigitUtil {
	public static int[] getDigList(int num){
		int length = (int) Math.floor(Math.log10(num)) + 1;
		int[] digList = new int[length];
		int index = 0;
		
		while (num >= 1) {
		    digList[index] = num % 10;
		    index++;
		    num = num / 10;
		}
		
		return digList;
	}
	
	public static int[] getDigList(long num){
		int length = (int) Math.floor(Math.log10(num)) + 1;
		int[] digList = new int[length];
		int index = 0;
		
		while (num >= 1) {
		    digList[index] = (int) (num % 10);
		    index++;
		    num = num / 10;
		}
		
		return digList;
	}
	
	public static int getDigPermutation(int num){
		int[] digList = getDigList(num);
		Arrays.sort(digList);
		int out = 0;
		for(int index = digList.length - 1; index >= 0; index--)
			out = out*10 + digList[index];
		return out;
	}
	
	public static long getDigPermutation(long num){
		int[] digList = getDigList(num);
		Arrays.sort(digList);
		long out = 0;
		for(int index = digList.length - 1; index >= 0; index--)
			out = out*10 + digList[index];
		return out;
	}
	
	public static void digMultiplication(int[] in, int mul){
		// multiplication starts from last digits
		int addl = 0;
		for(int index = in.length-1; index >= 1; index--){
			in[index] = in[index] * mul;
			in[index] = in[index] + addl;
			addl = 0;
			if(in[index] > 9){
				addl = (int) Math.floorDiv(in[index], 10);
				in[index] = in[index] % 10;
			}
		}in[0] = (in[0]*mul+addl)%10;
	}

}
