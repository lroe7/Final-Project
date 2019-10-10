import java.awt.Graphics;

public class RightArm extends ArmsAndLegs implements Draw{
	public RightArm(Graphics g, int width, int height)
	{
		super(g, width, height);
	}
	@Override
	//draws the right arm
	public void draw(Graphics g, int width, int height)
	{
		g.drawLine(aalWidth, aalHeight-75, aalWidth+25, aalHeight-50);
	}
}
