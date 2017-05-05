package project;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	
	private static final long serialVersionUID = -240840600533728354L;
	public Window(int width,int height,String title, Game game)// parameterized constructor of window class which initializes the frame
	{
		JFrame frame=new JFrame(title);
		frame.setPreferredSize(new Dimension(width,height));//sets the size of the component by constructing the Dimension(width and height)
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this is to stop the thread after we press the 'x' button
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);// to make our frame appear in center
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	

}
