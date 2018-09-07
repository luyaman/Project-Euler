package Problem;

public class P86 {
	
	public static boolean isSquare(int num){
		int sqrt = (int) Math.floor(Math.sqrt(num));
		return num == sqrt * sqrt;
	}

	public static void main(String[] args) {
		int M = 0;
		int target = 1000000;
		int acc = 0;
		int a = 0, b = 0; // a < b
		
		while(acc <= target){
			M ++;
			// constructing all the solution (a, b, M) with a <= b <= M
			for (a = 1; a <= M; a ++){
				for(b = a; b <= M; b ++){
					if(isSquare(a*a + b*b + M*M + 2*a*b))
						acc++;
				}
			}
			System.out.println(String.format("Accumulated result fo %d is %d", M, acc));
		}
		
		System.out.println("The result is: " + M);
	}

}
