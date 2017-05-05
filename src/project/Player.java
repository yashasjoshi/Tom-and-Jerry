package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player extends GameObject {
	
	Handler handler;
	private Image player;
	public Player(float x,float y, ID id,Handler handler)
	{
		
		super(x,y,id,handler);
		this.handler=handler;
		
	}
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,100,50);
	}
	public void tick()
	{
		
		x+=velX;
		y+=velY;
		x=Game.clamp(x, 0,Game.WIDTH-55);
		y=Game.clamp(y, 60,Game.HEIGHT-75);
		collision();
		
	}
	private void collision()
	{
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getId()== ID.BasicEnemy || tempObject.getId()==ID.FastEnemy||tempObject.getId()==ID.SmartEnemy)
				if(getBounds().intersects(tempObject.getBounds()))
				{
					HUD.Health-=1;
				
				}
		}
	}
	public void render(Graphics g)
	{
		ImageIcon img=new ImageIcon("C:/Users/Yashas/Documents/Eclipse workspace/TOM AND JERRY/image/Jerry.png");
		player=img.getImage();
		g.drawImage(player, (int)x,(int) y, null);
		/*Graphics2D g2d=(Graphics2D)g;// this is to see the actual bounds
		g.setColor(Color.green);
		g2d.draw(getBounds());
			/*g.setColor(Color.blue);
		
		g.fill3DRect(x, y, 50, 50,true);*/
		
	
	

}}
