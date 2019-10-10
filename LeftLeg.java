import java.awt.Graphics;

public class LeftLeg extends ArmsAndLegs implements Draw{
	public LeftLeg(Graphics g, int width, int height)
	{
		super(g, width, height);
	}
	@Override
	//draws the left leg
	public void draw(Graphics g, int width, int height)
	{
		g.drawLine(aalWidth-25, aalHeight+25, aalWidth, aalHeight);
	}
}