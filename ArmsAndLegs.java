import java.awt.Graphics;

public class ArmsAndLegs extends BodyPart {
	protected int aalWidth;
	protected int aalHeight;
	//initializes the instance variables aalWidth and aalHeight to make it easier to draw the sub-classes
	public ArmsAndLegs(Graphics g, int width, int height)
	{
		super(g, width, height);
		aalWidth = width/4;
		aalHeight = height/2;
	}
}
