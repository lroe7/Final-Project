import java.awt.Graphics;
public interface Draw {
	//creates the draw interface that each body part will implement
	//takes Graphics and to ints as parameters
	public void draw(Graphics g, int height, int width);
}
