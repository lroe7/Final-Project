import java.awt.Graphics;
public class Head extends BodyPart implements Draw
{
	public Head(Graphics g, int width, int height)
	{
		super(g, width, height);
	}
	@Override
	//draws the heads
	public void draw(Graphics g, int width, int height)
	{
		g.drawOval((width/4)-25, height/4, 50, 50);
	}
}
