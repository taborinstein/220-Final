import java.awt.Graphics2D;

public class Barrier{
	//private Line[] bounds;
	protected Line line;
	protected boolean damagesPlayer;
	protected double w;
	protected double rotVel;
	protected Sprite sprite;
	
	public Barrier(Line l, double width, double rotVel, Sprite s)
	{
		line = l;
		w = width;
		this.rotVel = rotVel;
		sprite = s;
		//bounds = new Line[4];
	}
	
	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public boolean isDamagesPlayer() {
		return damagesPlayer;
	}

	public void setDamagesPlayer(boolean damagesPlayer) {
		this.damagesPlayer = damagesPlayer;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getRotVel() {
		return rotVel;
	}

	public void setRotVel(double rotVel) {
		this.rotVel = rotVel;
	}

	public Barrier(Line l, double width, double rotVel, boolean dP,Sprite s)
	{
		this(l,width,rotVel,s);
		damagesPlayer = dP;
	}
	
	public void drawOn(Graphics2D g)
	{
		g.translate(line.getX1(),line.getY1());
		g.rotate(line.getAngle());
		//System.out.println(line.getAngle()*180/Math.PI);
		//g.fillRect((int)(-w),(int)(-w),(int)(line.getLength()+2*w),(int)(2*w));
		sprite.drawOn(g,(int)-w,(int)-w,(int)(line.getLength()+2*w),(int)(2*w));
		g.rotate(-line.getAngle());
		g.translate(-line.getX1(),-line.getY1());
		Line[] bounds = getBounds();
		g.drawLine((int)bounds[0].getX1(),(int)bounds[0].getY1(),(int)bounds[0].getX2(),(int)bounds[0].getY2());
		g.drawLine((int)bounds[1].getX1(),(int)bounds[1].getY1(),(int)bounds[1].getX2(),(int)bounds[1].getY2());
		g.drawLine((int)bounds[2].getX1(),(int)bounds[2].getY1(),(int)bounds[2].getX2(),(int)bounds[2].getY2());
		g.drawLine((int)bounds[3].getX1(),(int)bounds[3].getY1(),(int)bounds[3].getX2(),(int)bounds[3].getY2());

		

	}
	
	public void update()
	{
		line.rotate(rotVel);
	}
	
	public Line[] getBounds()
	{
		Line[] lines = new Line[4];
		double px1 = line.getX1();
		double py1 = line.getY1();
		double px2 = line.getX2();
		double py2 = line.getY2();
		double theta = line.getAngle();
		double px3 = px1 - w*Math.cos(theta+Math.PI/4);
		double py3 = py1 - w*Math.sin(theta+Math.PI/4);
		double px4 = px1 - w*Math.cos(theta-Math.PI/4);
		double py4 = py1 - w*Math.sin(theta-Math.PI/4);
		double px5 = px2 + w*Math.cos(theta+Math.PI/4);
		double py5 = py2 + w*Math.sin(theta+Math.PI/4);
		double px6 = px2 + w*Math.cos(theta-Math.PI/4);
		double py6 = py2 + w*Math.sin(theta-Math.PI/4);
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