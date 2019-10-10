import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
public class GamePanel extends JPanel implements KeyEventDispatcher
{
	private int height;
	private int width;
	private String guess;
	private int count;
	private Head head;
	private Body body;
	private RightArm rarm;
	private LeftArm larm;
	private RightLeg rleg;
	private LeftLeg lleg;
	private Graphics g;
	private Word words;
	private ArrayList<String> right;
	private ArrayList<String> wrong;
	private HardWord hardWords;
	private boolean level1;
	private boolean level2;
	private boolean openingScreen;
	private String word;
	private int guessCount;
	private String draw;
	//initializes the instance variables 
	public GamePanel(int height, int width)
	{
		draw = "";
		guessCount = 0;
		word = "";
		openingScreen = true;
		level1 = false;
		level2 = false;
		hardWords = new HardWord();
		wrong = new ArrayList<String>();
		right = new ArrayList<String>();
		words = new Word();
		head = new Head(g, width, height);
		body = new Body(g, width, height);
		rarm = new RightArm(g, width, height);
		larm = new LeftArm(g, width, height);
		rleg = new RightLeg(g, width, height);
		lleg = new LeftLeg(g, width, height);
		count = 0;
		this.width = width;
		this.height = height;
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(this);
		setBackground(Color.black);
	}
	//returns the height of the game
	public int getHeight()
	{
		return height;
	}
	//returns the width of the game
	public int getWidth()
	{
		return width;
	}
	//Takes graphics as a parameter and draws everything in the game
	public void paintComponent(Graphics g)
	{ 
		//sets up the opening screen to choose what level of words you want
		super.paintComponent(g);		
		if(openingScreen)
		{
			g.setColor(Color.white);
			g.setFont(new Font(g.getFont().getName(), Font.BOLD, 40));
			g.drawString("Press 1 for easy level", width/2 -250, height/3);
			g.drawString("Press 2 for hard level",  width/2 -250, height*2/3);
		}
		//draws the hangman structure and the number of lines in the word and sets the word 
		//to either the hard list or easy list depending on which level you choose
		else
		{
			if(level1)
			{
				word = words.getWord();
				openingScreen = false;
			}
			else if(level2)
			{
				word = hardWords.getWord();
				openingScreen = false;
			}
			g.setColor(Color.white);
			g.drawLine(width/2, height/8, width/2, height*2/3);
			g.drawLine(width/4, height/8, width/2, height/8);
			g.drawLine(width/4, height*2/3, width*3/4, height*2/3);
			g.drawLine(width/4, height/8, width/4, height/4);
			String wrongGuess = words.toStringWrong(wrong);
			int x = 40;
			for(int i = 0; i < words.getNumLetters(word); i++)
			{
				g.drawLine(x, height*7/8, x+35, height*7/8);
				x+= 65;
			} 
			//Creates a String called draw that contains the letters of correct guesses above the spaces
			draw = "";
			for(int i = 0; i < word.length(); i++)
			{
				boolean add = false;
				for(int j = 0; j < right.size(); j++)
				{
					if(word.substring(i, i+1).equals(right.get(j)))
					{
						add = true;
					}
				}
				if(add)
					draw+=word.substring(i, i+1) + "   ";
				else
				{
					draw+= "     ";
				}
			}
			//the boolean done tests to see if you have guessed the correct word, and if you have
			//it displays a "You Win!!!" message
			boolean done = true;
			for(int i = 0; i < word.length(); i ++)
			{
				if(draw.indexOf(word.substring(i, i+1)) == -1)
				{
					done = false;
				}
			}
			if(done && guessCount > 1)
			{
				g.setColor(Color.pink);
				g.setFont(new Font(g.getFont().getName(), Font.BOLD, 50));
				g.drawString("You Win!!!", width / 2 - 150, height / 2 - 10);
				g.drawString("Press 0 to reset", width/2 -150, height/2 +40);
			}
			//draws the body parts based on the value of count(how many incorrect letters are guessed)
			//if the guess is not in the word, the letter guessed is drawn at the top
			//if guess is in the word, the letter guessed is drawn above the space
			if(guess != null && words.correctGuess(word, guess))
			{
				g.setFont(new Font(g.getFont().getName(), Font.BOLD, 48));
				g.drawString(draw, 45, (height*7/8) -10);
				g.drawString(wrongGuess, 25,  50);
			}
			if(count == 1){
				head.draw(g, width, height);
				if(!(words.correctGuess(word,  guess))) {
					g.setFont(new Font(g.getFont().getName(), Font.BOLD, 48));
					g.drawString(wrongGuess, 25,  50);
					g.drawString(draw, 45, (height*7/8) -10);
				}
			}
			else if(count == 2) {
				body.draw(g, width, height);
				head.draw(g, width, height);
				if(!(words.correctGuess(word,  guess))) {
					g.setFont(new Font(g.getFont().getName(), Font.BOLD, 48));
					g.drawString(wrongGuess, 25, 50);
					g.drawString(draw, 45, (height*7/8) -10);
				}
			}
			else if(count == 3) {
				head.draw(g,  width, height);
				body.draw(g,  width,  height);
				rleg.draw(g,  width,  height);
				if(!(words.correctGuess(word,  guess))) {
					g.setFont(new Font(g.getFont().getName(), Font.BOLD, 48));
					g.drawString(wrongGuess, 25,  50);
					g.drawString(draw, 45, (height*7/8) -10);
				}
			}
			else if(count == 4) {
				head.draw(g,  width, height);
				body.draw(g,  width,  height);
				rleg.draw(g,  width,  height);
				lleg.draw(g,  width,  height);
				if(!(words.correctGuess(word,  guess))) {
					g.setFont(new Font(g.getFont().getName(), Font.BOLD, 48));
					g.drawString(wrongGuess, 25,  50);
					g.drawString(draw, 45, (height*7/8) -10);
				}
			}
			else if(count == 5) {
				head.draw(g,  width, height);
				body.draw(g,  width,  height);
				rleg.draw(g,  width,  height);
				lleg.draw(g,  width,  height);
				larm.draw(g,  width,  height);
				if(!(words.correctGuess(word,  guess))) {
					g.setFont(new Font(g.getFont().getName(), Font.BOLD, 48));
					g.drawString(wrongGuess, 25,  50);
					g.drawString(draw, 45, (height*7/8) -10);
				}
			}
			//draws the last arm and the eyes with the Game Over message and displays the correct word
			else if(count == 6) {
				g.setColor(Color.red);
				head.draw(g,  width, height);
				body.draw(g,  width,  height);
				rleg.draw(g,  width,  height);
				lleg.draw(g,  width,  height);
				larm.draw(g,  width,  height);
				rarm.draw(g, width, height);
				g.drawLine(135, 175, 140, 170);
				g.drawLine(135, 170, 140, 175);
				g.drawLine(165, 175, 160, 170);
				g.drawLine(165, 170, 160,  175);
				g.setFont(new Font(g.getFont().getName(), Font.BOLD, 50));
				g.drawString("GAME OVER", width / 2 - 150, height / 2 - 10);
				g.setFont(new Font(g.getFont().getName(), Font.BOLD, 30));
				g.drawString("The word is " + word, width/2 -150, height/2 +20);
				g.drawString("press 0 to reset", width/2-150, height/2 +50);
			}
		}
	}

	@Override
	//Takes the user input from the keyboard and checks to see if the word contains the letter guessed
	//If not, count is increased
	public boolean dispatchKeyEvent(KeyEvent e) {
		switch(e.getID())
		{
		case KeyEvent.KEY_TYPED:
			System.out.println(e.getKeyChar());
			System.out.println(word);
			guess = e.getKeyChar() + "";
			if(guess!= null && guess.equals("1"))
			{
				level1= true;
				level2 = false;
				openingScreen = false;
			}
			else if(guess!=null &&guess.equals("2"))
			{
				level2 = true;
				level1 = false;
				openingScreen = false;
			}
			else if(guess!=null &&guess.equals("0"))
			{
				reset();
			}
			if(guess!= null && !(guess.equals("1")) && !(guess.equals("2")) && !(guess.equals("0")) && !(words.correctGuess(word, guess)))
			{
				count++;
				wrong.add(guess);
				System.out.println(count);
				guessCount++;
			}
			else
			{
				right.add(guess);
				guessCount++;
			}
			repaint();
			break;
		default:
			break;
		}
		return true;
	}
	//Resets the game to the default settings so that when reset is called you can restart the game without closing out 
	public void reset()
	{
		draw = "";
		guessCount = 0;
		word = "";
		openingScreen = true;
		level1 = false;
		level2 = false;
		hardWords = new HardWord();
		wrong = new ArrayList<String>();
		right = new ArrayList<String>();
		words = new Word();
		head = new Head(g, width, height);
		body = new Body(g, width, height);
		rarm = new RightArm(g, width, height);
		larm = new LeftArm(g, width, height);
		rleg = new RightLeg(g, width, height);
		lleg = new LeftLeg(g, width, height);
		count = 0;		
	}
}
