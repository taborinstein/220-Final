public class Barrier{
	//private Line[] bounds;
	private Line line;
	private boolean damagesPlayer;
	private double w;
	
	public Barrier(Line l, double width)
	{
		line = l;
		w = width;
		//bounds = new Line[4];
	}
	
	public Barrier(Line l, double width, boolean dP)
	{
		this(l,width);
		damagesPlayer = dP;
	}
	
	public Line[] getBounds()
	{
		Line[] lines = new Line[4];
		double px1 = line.getX1();
		double py1 = line.getY1();
		double px2 = line.getX2();
		double py2 = line.getY2();
		double theta = line.getAngle();
		double px3 = px1 + w*Math.cos(theta+Math.PI/4);
		double py3 = py1 + w*Math.sin(theta+Math.PI/4);
		double px4 = px1 + w*Math.cos(theta-Math.PI/4);
		double py4 = py1 + w*Math.sin(theta-Math.PI/4);
		double px5 = px2 - w*Math.cos(theta+Math.PI/4);
		double py5 = py2 - w*Math.sin(theta+Math.PI/4);
		double px6 = px2 - w*Math.cos(theta-Math.PI/4);
		double py6 = py2 - w*Math.sin(theta-Math.PI/4);
		lines[0] = new Line(px3,py3,px4,py4);
		lines[1] = new Line(px4,py4,px5,py5);
		lines[2] = new Line(px5,py5,px6,py6);
		lines[3] = new Line(px6,py6,px3,py3);
		return lines;
	}
	
	public boolean isIntersecting(GameObject other)
	{
		Line[] otherLines = new Line[4];
		Line[] boundLines = getBounds();
		double x1 = other.getX();
		double y1 = other.getY();
		double x2 = x1+other.getW();
		double y2 = y1+other.getH();
		otherLines[0] = new Line(x1,y1,x2,y1);
		otherLines[1] = new Line(x2,y1,x2,y2);
		otherLines[2] = new Line(x1,y2,x2,y2);
		otherLines[3] = new Line(x1,y1,x1,y2);
		for(int q = 0; q<4; q++)
		{
			for(int p = 0; p<4; p++)
			{
				if(boundLines[q].isIntersecting(otherLines[p]))
					return true;
			}
		}
		return false;
	}
}