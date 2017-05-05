package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
// heads up display
public class HUD {
	
	public int bounds=0;
	public static float Health=100;
	private float greenValue=255;
	private int score=0;
	private int level=1;
	public void tick()
	{
		
		Health=Game.clamp(Health, 0, 100+(bounds/2)); // the health value is getting decremented in the player value
		// and then the handler method is calling the tick and render method
		greenValue=Health*2;
		greenValue=Game.clamp(greenValue,0 , 255);// when health value turns 0 this will clamp the value to 0
		
		score++;
		
	}
	public void render(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200+bounds, 32);
		g.setColor(Color.green);
		g.setColor(new Color(100,(int)greenValue,0));
		g.fillRect(15, 15,(int)Health*2 , 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200+bounds, 32);
		g.setColor(Color.black);
		Font fnt= new Font("arial",1,20);
		g.setFont(fnt);
		g.setColor(Color.black);
		g.drawString("Score  : "+score , 500, 25);
		g.drawString(" ", 260, 30);
		g.drawString("Level   : "+level , 500, 45);
		g.drawString("Space for Shop", 1100, 35);
	}
	public void score(int score)
	{this.score=score;}
	public int getScore()
	{
		return score;
	}
	public int getLevel()
	{return level;}
	public void setLevel(int level)
	{
		this.level=level;
	}

}
