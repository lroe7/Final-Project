import java.awt.Graphics;

public class Body extends BodyPart implements Draw{
	public Body(Graphics g, int width, int height)
	{
		super(g, width, height);
	}
	//draws the body
	@Override
	public void draw(Graphics g, int width, int height)
	{
		g.drawLine(width/4, (height/4)+50, width/4, height/2);
	}
}
