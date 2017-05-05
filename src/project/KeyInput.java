package project;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import project.Game.STATE;

public class KeyInput extends KeyAdapter {
	private Handler handler;
	Game game;
	private boolean keyDown[]=new boolean[4];
	public KeyInput(Handler handler,Game game){
		this.game=game;
		this.handler=handler;
		keyDown[0]=false;
		keyDown[1]=false;
		keyDown[2]=false;
		keyDown[3]=false;
		
	}
	public void keyPressed(KeyEvent e)
	{
		
		int key=e.getKeyCode();
		System.out.println(key);
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getId()==ID.player)
			{
				if(key==KeyEvent.VK_W){ tempObject.setVelY(-handler.spd); keyDown[0]=true;}
				if(key==KeyEvent.VK_S){ tempObject.setVelY(handler.spd);keyDown[1]=true;}
				if(key==KeyEvent.VK_A){ tempObject.setVelX(-handler.spd);keyDown[3]=true;}
				if(key==KeyEvent.VK_D){ tempObject.setVelX(handler.spd); keyDown[2]=true;}
					
					
				}
		}
		if(key==KeyEvent.VK_P)
		{
			if(game.gameState==STATE.Game){
			if(Game.paused)
			Game.paused=false;
			else
				Game.paused=true;
			}
		}
		if(key==KeyEvent.VK_ESCAPE)System.exit(0);
		if(key==KeyEvent.VK_SPACE)
		{
			if(Game.gameState==STATE.Game)
			{
				Game.gameState=STATE.Shop;
			}
			else if (Game.gameState==STATE.Shop){Game.gameState=STATE.Game;}
		}
	}
	public void keyReleased(KeyEvent e)
	{
		int key=e.getKeyCode();
		System.out.println(key);
		for(int i=0;i<handler.object.size();i++)
		{
			GameObject tempObject=handler.object.get(i);
			if(tempObject.getId()==ID.player)
			{
				if(key==KeyEvent.VK_W)keyDown[0]=false;
				if(key==KeyEvent.VK_S)keyDown[1]=false;
				if(key==KeyEvent.VK_A)keyDown[3]=false;
				if(key==KeyEvent.VK_D)keyDown[2]=false;
					
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
					
				}
				
			
	}
		
	}
}
