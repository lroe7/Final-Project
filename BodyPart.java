import java.awt.Graphics;
public class BodyPart {
	protected int width, height;
	//creates the body part superclass that each body part will extend 
	//to make it easier to draw the body parts
	//declares and initializes the width and height instance variables
	public BodyPart(Graphics g, int width, int height)
	{
		this.width = width;
		this.height = height;
	}
}
