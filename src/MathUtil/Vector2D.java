package MathUtil;

public class Vector2D {
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

	public Vector2D(double x, double y) {
		this.x = x; this.y = y;
	}
	
	public String toString(){
		return String.format("(%.1f,%.1f)", x, y);
	}


}
