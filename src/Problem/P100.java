package Problem;
import java.math.BigInteger;

public class P100 {
	
	public static BigInteger sqrt(BigInteger x) {
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    for(;;) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}

	public static void main(String[] args) {
		BigInteger total = new BigInteger("1000000000000	");
		BigInteger two = new BigInteger("2");
		
		while(true){
			System.out.println("Attempting " + total.toString());
			BigInteger product = total.multiply(total.subtract(BigInteger.ONE)).divide(two);
			//System.out.println("Product is: " + product.toString());
			BigInteger root = sqrt(product);
			//System.out.println("Root is: " + root.toString());
			if(product.subtract(root.multiply(root.add(BigInteger.ONE))).longValue() == (long)0)
				break;
			total = total.add(BigInteger.ONE);
			//break;
		}
		
		System.out.println("The result is " + total.toString());
	}

}
