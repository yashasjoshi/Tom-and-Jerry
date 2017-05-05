package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class SmartEnemy extends GameObject {

	private Image player;
	private GameObject players;
	private Handler handler;
	public SmartEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		this.handler=handler;
		
		for(int i=0;i<handler.object.size();i++)
		{
			if(handler.object.get(i).getId()==ID.player)
				players=handler.object.get(i);
		}
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,122,130);
	}
	public void tick() {
		
		x+=velX;
		y+=velY;
		float diffX=x-players.getX();
		float diffY=y-players.getY();
		float distance=(float)Math.sqrt((diffX*diffX)+(diffY*diffY));
		velX=(float)((-1.0/distance)*(diffX-10))*3;
		velY=(float)((-1.0/distance)*(diffY-10))*3;
		if(x<-10 || x>Game.WIDTH)velX*=-1;
		if(y<50 || y>Game.HEIGHT)velY*=-1;
		
	}

	
	public void render(Graphics g) {
		ImageIcon img=new ImageIcon("C:/Users/Yashas/Documents/Eclipse workspace/TOM AND JERRY/image/Bulldog.png");
		player=img.getImage();
		g.drawImage(player,(int)x,(int)y, null);
		/*Graphics2D g2d=(Graphics2D)g;// this is to see the actual bounds
		g.setColor(Color.green);// 
		g2d.draw(getBounds());//
		
		/*g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);*/
		
		
	}

}
