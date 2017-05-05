package project;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Background extends GameObject {
	public Background(float x,float y, ID id,Handler handler)
	{
		
		super(x,y,id,handler);
		
	}
	public void tick()
	{
		Random r=new Random();
		x+=0;
		y+=r.nextInt(20);
if(y>=1350/12*6)
{
	x=r.nextInt(1350);
	y=70;
	}
}
	public void render(Graphics g)
	{
		
		Random r=new Random();
		
		
		Color c=new Color(r.nextInt(90000990));
		g.setColor(c);
		g.fillOval((int)x,(int)y, 5, 5);
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}
