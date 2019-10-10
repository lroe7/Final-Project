import java.awt.Graphics;


public class LeftArm extends ArmsAndLegs implements Draw{
	public LeftArm(Graphics g, int width, int height)
	{
		super(g, width, height);
	}
	@Override
	//draws the left arm
	public void draw(Graphics g, int width, int height)
	{
		g.drawLine(aalWidth-25, aalHeight-50, aalWidth, aalHeight-75);
	}
}
