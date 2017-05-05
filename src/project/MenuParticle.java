package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class MenuParticle extends GameObject {
	Random r=new Random();
	
	private Color c;

	public MenuParticle(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX=(r.nextInt(7 - -7)+ -7);
		velY=(r.nextInt(7 - -7)+ -7);
		if(velX==0 || velY==0){velX=1;velY=1;}
		c=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
		
	}
	private Image player;

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,122,130);
	}
	public void tick() {
		
		x+=velX;
		y+=velY;
		
		if(x<-10 || x>Game.WIDTH-30)velX*=-1;
		if(y<60 || y>Game.HEIGHT-50)velY*=-1;
		// when the condition becomes true we reverse the sign of velocity, thereby bouncing back
	}

	
	public void render(Graphics g) {
		
		
		g.setColor(c);
		
		g.fillOval((int)x,(int) y, 25, 25);
		
		
	}

}
