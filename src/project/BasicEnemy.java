package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class BasicEnemy extends GameObject {

	public BasicEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX=2;
		velY=3;
		
	}
	private Image player;

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,122,130);
	}
	public void tick() {
		
		x+=velX;
		y+=velY;
		
		if(x<-10 || x>Game.WIDTH-120)velX*=-1;
		if(y<50 || y>Game.HEIGHT-150)velY*=-1;
		// when the condition becomes true we reverse the sign of velocity, thereby bouncing back
	}

	
	public void render(Graphics g) {
		ImageIcon img=new ImageIcon("C:/Users/Yashas/Documents/Eclipse workspace/TOM AND JERRY/image/tom.png");
		player=img.getImage();
		g.drawImage(player,(int)x,(int)y, null);
		/*Graphics2D g2d=(Graphics2D)g;// this is to see the actual bounds
		g.setColor(Color.green);// 
		g2d.draw(getBounds());//
		
		/*g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);*/
		
		
	}

}
