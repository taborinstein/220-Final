
public class Line {
	private double x1, y1, x2, y2;
	
	public Line(double x1, double y1, double x2, double y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public double getAngle()
	{
		return Math.atan2(y2-y1,x2-x1);
	}
	
	public boolean isIntersecting(Line other)
	{
		double px1 = x1;
		double px2 = x2;
		double px3 = other.getX1();
		double px4 = other.getX2();
		double py1 = y1;
		double py2 = y2;
		double py3 = other.getY1();
		double py4 = other.getY2();
		double dx1 = px2-px1;
		double dx2 = px4-px3;
		double dy1 = py2-py1;
		double dy2 = py4-py3;
		double v = dy1*dx2/dy2;
		if(dy2==0)
			return (py3>=py1)==(py3<=py2);
		if(dy1/dx1==dy2/dx2)
			return false;
		double y = (-dx1*py1+v*py3-dy1*(px3-px1))/(v-dx1);
		return ((y>=py1)==(y<=py2))&&((y>=py3)==(y<=py4));
		
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}
	
	
}
