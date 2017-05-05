package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class HardEnemy extends GameObject {

	public HardEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX=8;
		velY=8;
		
	}
	private Image player;
	Random r=new Random();

	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,122,130);
	}
	public void tick() {
		
		x+=velX;
		y+=velY;
		if(velX>10)velX=4;else if(velX<-10) velX=-4;
		else if(velY>10)velY=4;else if(velY<-10) velY=-4;
		if(x<=-10 || x>=Game.WIDTH-120){if(velX<0)velX=-(r.nextInt(3)+10)*-1; else velX=(r.nextInt(3)+10)*-1;}
		if(y<=60 || y>=Game.HEIGHT-120){if(velY<0)velY=-(r.nextInt(3)+10)*-1; else velY=(r.nextInt(3)+10)*-1;}
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
