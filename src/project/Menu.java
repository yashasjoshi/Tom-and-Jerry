package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;

import project.Game.STATE;

public class Menu extends MouseAdapter {
	private Game game;
	private Handler handler;
	private Random r=new Random();
	private Image player;
	HUD hud;
	
	public Menu(Game game,Handler handler,HUD hud)
	{
		this.hud=hud;
		this.game=game;
		this.handler=handler;
	}
	public void mousePressed(MouseEvent e)
	{
		int mx=e.getX();	// here we are storing the x position of our click
		int my=e.getY();	// here we are storing the y position of our click
		//play button
		if(game.gameState==STATE.Menu){
		if(mouseOver(mx,my,475, 180, 400, 70))
		{
			//game.gameState=STATE.Game;
			//for(int i=0;i<20;i++)handler.addObject(new Background(r.nextInt(1350),66+r.nextInt(1350/12*6),ID.back,handler));
			//handler.addObject(new Player(1350/2-32,(1350/12*6)/2-32,ID.player,handler));// here we are adding game object player to the linked list
			//handler.clearEnemy();
			//handler.addObject(new BasicEnemy(65,65,ID.BasicEnemy,handler));
			game.gameState=STATE.Select;
		}}
				
		
		if(game.gameState==STATE.Menu){
			
		if(mouseOver(mx,my,475, 270, 400, 70))
		{
			game.gameState=STATE.Help;
		}
		}
		
		

		if(game.gameState==STATE.Menu){
			
		if(mouseOver(mx,my,475, 360, 400, 70))
		{
			System.exit(1);
		}
		}
		/////////////level/////
		//play button
		if(game.gameState==STATE.Select){
			if(mouseOver(mx,my,475, 270, 400, 70))
			{
				game.gameState=STATE.Game;
				for(int i=0;i<20;i++)handler.addObject(new Background(r.nextInt(1350),66+r.nextInt(1350/12*6),ID.back,handler));
				handler.addObject(new Player(1350/2-32,(1350/12*6)/2-32,ID.player,handler));// here we are adding game object player to the linked list
				handler.clearEnemy();
				handler.addObject(new BasicEnemy(65,65,ID.BasicEnemy,handler));
				game.diff=0;
			}
					// hard button
			
			
				
			if(mouseOver(mx,my,475, 360, 400, 70))
			{
				game.gameState=STATE.Game;
				for(int i=0;i<20;i++)handler.addObject(new Background(r.nextInt(1350),66+r.nextInt(1350/12*6),ID.back,handler));
				handler.addObject(new Player(1350/2-32,(1350/12*6)/2-32,ID.player,handler));// here we are adding game object player to the linked list
				handler.clearEnemy();
				handler.addObject(new HardEnemy(65,65,ID.BasicEnemy,handler));
				game.diff=1;
			
			}
			
			
			// back button
			
				
			if(mouseOver(mx,my,475, 450, 400, 70))
			{
				game.gameState=STATE.Menu;
			
			}
		}
		/////////////level///////
		//back button
		if(game.gameState==STATE.Help)
		{
			if(mouseOver(mx,my,475, 500, 400, 70))
			{
				game.gameState=STATE.Menu;
			}
		}
		if(game.gameState==STATE.End)
		{
			if(mouseOver(mx,my,475, 500, 400, 70))
			{
				game.gameState=STATE.Menu;
				hud.score(0);
				hud.setLevel(1);
				
			}
		}
		
	}
	public void mouseReleased(MouseEvent e)
	{}
	
	
	private boolean mouseOver(int mx,int my,int x,int y,int width,int height)
	{
		if(mx > x && mx < x+width) 
		{
			if(my>y && my <y+height) 
			{return true;} else return false;
		}else return false;
	}
	
	public void tick(){}
	public void render(Graphics g)
	{
		if(game.gameState==STATE.Menu)
		{
			Font fnt= new Font("arial",1,50);
			Font fnt2= new Font("arial",1,35);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("MENU", 600, 130);
			
			g.setFont(fnt2);
			
			g.drawRect(475, 180, 400, 70);
			g.drawString("Play", 635, 225);
					
			g.drawRect(475, 270, 400, 70);
			g.drawString("Help", 635, 315);
			
			g.drawRect(475, 360, 400, 70);
			g.drawString("Quit", 635, 405);
		}else if(game.gameState==STATE.Help)
		{
			Font fnt= new Font("arial",1,50);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("HELP", 600, 130);
			Font fnt2= new Font("arial",1,35);
			g.setFont(fnt2);
			g.drawRect(475, 500, 400, 70);
			g.drawString("Back", 635, 545);
			Font fnt3= new Font("arial",1,20);
			g.setFont(fnt3);
			
			g.drawString("Press W S A D to dodge the enemies and try to ", 400, 245);
			g.drawString("surive for maximum time.", 400, 280);
			g.drawString("Look for the bulldog and boss, they are a real challenge", 400, 315);
			g.drawString("Click back and then play !!", 400, 350);
			ImageIcon img=new ImageIcon("C:/Users/DELL/Documents/Eclipse workspace/Tom and Jerry/image/wasd.png");
			player=img.getImage();
			g.drawImage(player,80,180, null);
			ImageIcon img2=new ImageIcon("C:/Users/DELL/Documents/Eclipse workspace/Tom and Jerry/image/Tom_and_Jerry.png");
			player=img2.getImage();
			g.drawImage(player,1000,250, null);
			
		}
		else if(game.gameState==STATE.End)
		{
			g.setColor(Color.white);
			Font fnt= new Font("arial",1,50);
			g.setFont(fnt);
			g.drawString("Game Over !! ", 550, 130);
			Font fnt2= new Font("arial",1,35);
			g.setFont(fnt2);
			g.drawString("Your game ended with the score "+hud.getScore(), 420, 445);
			g.drawRect(475, 500, 400, 70);
			g.drawString("Try Again", 615, 545);
			ImageIcon img3=new ImageIcon("C:/Users/DELL/Documents/Eclipse workspace/Tom and Jerry/image/tom_en_jerry.png");
			player=img3.getImage();
			g.drawImage(player,600,200, null);
		}else if(game.gameState==STATE.Select)
		{
			
			Font fnt= new Font("arial",1,50);
			Font fnt2= new Font("arial",1,35);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Difficulty", 580, 170);
			
			g.setFont(fnt2);
			
			g.drawRect(475, 450, 400, 70);
			g.drawString("Back", 635, 495);
					
			g.drawRect(475, 270, 400, 70);
			g.drawString("Normal", 635, 315);
			
			g.drawRect(475, 360, 400, 70);
			g.drawString("Hard", 635, 405);
		}
			}

}
