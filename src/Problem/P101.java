package Problem;

import java.math.BigInteger;
import java.util.Arrays;

import MathUtil.PolynomialUtil;

public class P101 {
	
	public static double calTerm (double n,  double[] coeffs){
		double sum =0;
		for(int pow = 0; pow < coeffs.length; pow ++){
			sum = sum + coeffs[pow] * Math.pow(n, pow);
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] coeffs = new double[]{1,-1,1,-1,1,-1,1,-1,1,-1,1};
		//double[] coeffs = new double[]{0,0,0,1};
		double[] xs = new double[] {1,2,3,4, 5,6,7,8,9,10};
		double[] ys = new double[10];
		
		for(int i = 0; i < xs.length; i ++){
			ys[i] = calTerm(xs[i], coeffs);
		}
		
		double acc = 0;
		for(int k = 1; k < coeffs.length; k++){
			double bop = PolynomialUtil.calLagrangeInsertion(Arrays.copyOfRange(xs, 0, k), Arrays.copyOfRange(ys, 0, k), k+1);
			System.out.println(String.format("BOP prediction for first %d terms is: %f", k, bop));
			acc = acc + bop;
		}
		
		System.out.println(String.format("The result is %16.2f", acc));
	}

}
