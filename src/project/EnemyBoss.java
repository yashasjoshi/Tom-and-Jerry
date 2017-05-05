package project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class EnemyBoss extends GameObject {

	public EnemyBoss(float x, float y, ID id,Handler handler) {
		super(x, y, id,handler);
		velX=0;
		velY=1;
		
	}
	Random r=new Random();
	private Image player;
	private int timer=20;
	private int timer2=10;
	public Rectangle getBounds()
	{
		return new Rectangle((int)x,(int)y,122,130);
	}
	public void tick() {
		
		x+=velX;
		y+=velY;
		if(timer<=0)velY=0;
		else timer--;
		if(timer<=0) timer2--;
		if(timer2<=0)
		{
			if(velX==0)velX=3;
			if(velX>0)
				velX+=0.005f;
			else if(velX<0)
				velX-=0.005f;
			velX=Game.clamp(velX, -8, 8);
			int spawn=r.nextInt(15);
			if(spawn==0) handler.addObject(new EnemyBossBullets((int)x,(int)y+50,ID.BasicEnemy,handler));
		}
			
		if(x<-10 || x>Game.WIDTH-130)velX*=-1;
		//if(y<50 || y>Game.HEIGHT-150)velY*=-1;
		// when the condition becomes true we reverse the sign of velocity, thereby bouncing back
	}

	
	public void render(Graphics g) {
		ImageIcon img=new ImageIcon("C:/Users/Yashas/Documents/Eclipse workspace/TOM AND JERRY/image/TazIcon.png");
		player=img.getImage();
		g.drawImage(player,(int)x,(int)y, null);
		/*Graphics2D g2d=(Graphics2D)g;// this is to see the actual bounds
		g.setColor(Color.green);// 
		g2d.draw(getBounds());//
		
		/*g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);*/
		
		
	}

}
