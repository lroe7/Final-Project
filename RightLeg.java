import java.awt.Graphics;

public class RightLeg extends ArmsAndLegs implements Draw{
	public RightLeg(Graphics g, int width, int height)
	{
		super(g, width, height);
	}
	@Override
	//draws the right leg
	public void draw(Graphics g, int width, int height)
	{
		g.drawLine(aalWidth, aalHeight, aalWidth+25, aalHeight+25);
	}
}
