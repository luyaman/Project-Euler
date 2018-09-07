package MathUtil;

public class PolynomialUtil {
	
	public static double calLagrangeInsertion(double[] xs, double[] ys, double x0){
		double result = 0;
		
		for(int j = 0; j < ys.length; j++){
			double l = ys[j];
			for(double xi: xs){
				if(xi != xs[j]){
					l = l * (x0 - xi) / (xs[j] - xi);
				}
			}
			result = result + l;
		}
		return result;
	}

}
