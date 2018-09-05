package Problem;

import MathUtil.PrimeUtil;

public class P71 {
	public static void main(String[] args){
		int curD = 5;
		int curN = 2;
		int n;
		
		for(int d = 6; d <= 1000000; d++){
			System.out.println(d);
			if(d%7 == 0)
				n = d/7*3-1;
			else
				n = (int)Math.floor(d*3/7);
			while(PrimeUtil.findGCF(d, n)!=1)
				n--;
			
			if((long)curN*d < (long)curD*n){
				curD = d;
				curN = n;
			}
		}
		
		System.out.println(String.format("The result is %d / %d.", curN, curD));
	}
}
