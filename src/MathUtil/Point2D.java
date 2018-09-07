package MathUtil;

public class Point2D {
	private double x, y;
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Point2D(double x, double y) {
		this.x = x; this.y = y;
	}
	
	public Vector2D genVectorTo(Point2D a){
		return new Vector2D(a.getX() - x, a.getY() - y);
	}
	
	public String toString(){
		return String.format("(%.1f,%.1f)", x, y);
	}

}
