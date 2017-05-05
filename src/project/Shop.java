package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {

	Handler handler;
	HUD hud;
	private int B1=500;
	private int B2=500;
	private int B3=500;
	public Shop(Handler handler, HUD hud)
{
		this.handler=handler;
		this.hud=hud;
	}
public void render(Graphics g){
	
	g.setColor(Color.WHITE);
	g.setFont(new Font("arial",0,48));
	g.drawString("SHOP", Game.WIDTH/2-100, 50);
	
	//box1
	g.setFont(new Font("arial",0,25));
	g.drawString("Upgrade Health",210,310);
	g.drawString("Cost : "+B1,230,380);
	g.drawRect(200, 250, 200, 200);
	//box2
	
	g.drawString("Upgrade Speed",610,310);
	g.drawString("Cost : "+B2,630,380);
	g.drawRect(600, 250, 200, 200);
	//box3
	
	g.drawString("Refill Health",1020,310);
	g.drawString("Cost : "+B3,1030,380);
	g.drawRect(1000, 250, 200, 200);
	
	g.drawString("SCORE : "+hud.getScore(), 250, 90);
	g.drawString("Press Space to go Back ",1000, 90);
}

public void mousePressed(MouseEvent e)
{
	int mx=e.getX();
	int my=e.getY();
	
	//box1
	
	if(mx >=200 && mx<=400)
	{
		if(my>=250 && my<=450){
			if(hud.getScore()>=B1){
				hud.score(hud.getScore()-B1);
				B1+=200;
				hud.bounds+=20;
				hud.Health=(100+(hud.bounds/2));
				}
		}
	}
	
	//box2
	
		if(mx >=600 && mx<=800)
		{
			if(my>=250 && my<=450){if(hud.getScore()>=B2){
				hud.score(hud.getScore()-B2);
				B2+=200;
				handler.spd++;
				}}
		}
		//box3
		
		if(mx >=1000 && mx<=1200)
		{
			if(my>=250 && my<=450){if(hud.getScore()>=B3){
				hud.score(hud.getScore()-B3);
				hud.Health=(100+(hud.bounds/2));
				}}
		}
	}
}
