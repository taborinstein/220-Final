
public class Line {
	private double x1, y1, x2, y2, px, py;
	
	public Line(double x1, double y1, double x2, double y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		px = 0;
		py = 0;
		//angle = a;
	}
	
	public Line(double x1, double y1, double x2, double y2, double px, double py)
	{
		this(x1,y1,x2,y2);
		this.px = px;
		this.py = py;
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
		{
			double x = (px2-px1)/(py2-py1)*(py3-py1)+px1;
			return ((py3>=py1)==(py3<=py2))&&((x>=px1)==(x<=px2))&&((x>=px3)==(x<=px4));
		}
		if(dy1/dx1==dy2/dx2)
			return false;
		double y = (-dx1*py1+v*py3-dy1*(px3-px1))/(v-dx1);
		double x = (px4-px3)/(py4-py3)*(y-py3)+px3;
			//return ((x>=px1)==(x<=px2));
		return ((y>=py1)==(y<=py2))&&((y>=py3)==(y<=py4))&&((x>=px1)==(x<=px2))&&((x>=px3)==(x<=px4));
		
	}
	
	public double getLength()
	{
		return Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
	}
	
	public void rotate(double r)
	{
		double d1 = Math.sqrt((px-x1)*(px-x1)+(py-y1)*(py-y1));
		double d2 = Math.sqrt((px-x2)*(px-x2)+(py-y2)*(py-y2));
		double theta1 = Math.atan2(y1-py,x1-px);
		double theta2 = Math.atan2(y2-py,x2-px);
		//double theta0 = Math.atan2(y2-y1,x2-x1);
		double newX1 = px+d1*Math.cos(theta1+r);
		double newY1 = py+d1*Math.sin(theta1+r);
		double newX2 = px+d2*Math.cos(theta2+r);
		double newY2 = py+d2*Math.sin(theta2+r);
		x1 = newX1;
		y1 = newY1;
		x2 = newX2;
		y2 = newY2;
		
		//System.out.println(d1+" "+d2);
//		double dx = (x2+x1)/2;
//		double dy = (y2+y1)/2;
//		
//		double d = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1))/2;
//		double targetAngle = getAngle()+r;
//		x1 = dx-d*Math.cos(targetAngle);
//		x2 = dx+d*Math.cos(targetAngle);
//		y1 = dy-d*Math.sin(targetAngle);
//		y2 = dy-d*Math.sin(targetAngle);
//		System.out.println(targetAngle+" "+r);
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
