package MathUtil;

public class CartesianUtil {

	
	public static double crossProduct(Vector2D a, Vector2D b){

		return a.getX()*b.getY() - a.getY()*b.getX();
	}
	
	public static boolean sameSide(Point2D a, Point2D b, Point2D p1, Point2D p2){
		Vector2D v1 = a.genVectorTo(b), v2 = a.genVectorTo(p1), v3 = a.genVectorTo(p2);
		return crossProduct(v1,v2) * crossProduct(v1,v3) >= 0;
	}
	
	public static boolean inTriangle(Point2D a, Point2D b, Point2D c, Point2D p){
	return sameSide(a, b, c, p) && sameSide(a, c, b, p) && sameSide(b, c, a, p);
	}
	
	public static void main(String[] args){
		System.out.println(inTriangle(new Point2D(-175,41), new Point2D(-421,-714), new Point2D(574,-645), new Point2D(0,0)));
	}

}
