package project;

import java.util.Random;

public class Spawn {
	private Handler handler;
	private HUD hud;
	int scorekeep=0;
	private Game game;
	Random r=new Random();
	public Spawn(Handler handler,HUD hud,Game game)
	{
		this.handler=handler;
		this.hud=hud;
		this.game=game;
	}
	
	public void tick()
	{
		
		scorekeep++;
		if(scorekeep>=250)
		{
			hud.setLevel(hud.getLevel()+1);
			scorekeep=0;
			}
		if(game.diff==0)
		{
		if(hud.getScore()==250)
			handler.addObject(new BasicEnemy(r.nextInt(800)+60,r.nextInt(300)+60,ID.BasicEnemy,handler));
		else if(hud.getScore()==500)
		{
			handler.addObject(new BasicEnemy(r.nextInt(100)+600,r.nextInt(100)+60,ID.BasicEnemy,handler));
			handler.addObject(new BasicEnemy(r.nextInt(200)+60,r.nextInt(100)+200,ID.BasicEnemy,handler));
		}

		else if(hud.getScore()==750)
			handler.addObject(new FastEnemy(r.nextInt(100)+60,r.nextInt(100)+60,ID.FastEnemy,handler));
		else if(hud.getScore()==1000)
			handler.addObject(new FastEnemy(r.nextInt(100)+60,r.nextInt(100)+60,ID.FastEnemy,handler));
		else if(hud.getScore()==1300)
			handler.addObject(new SmartEnemy(r.nextInt(100)+60,r.nextInt(100)+60,ID.SmartEnemy,handler));
		else if(hud.getScore()==1700)
		{handler.clearEnemy();
		handler.addObject(new EnemyBoss((1350/2)-32,60,ID.EnemyBoss,handler));
		}
		}
		else if(game.diff==1)
		{		if(hud.getScore()==250)
			handler.addObject(new HardEnemy(r.nextInt(800)+60,r.nextInt(300)+60,ID.BasicEnemy,handler));
		else if(hud.getScore()==500)
		{
			handler.addObject(new HardEnemy(r.nextInt(100)+600,r.nextInt(100)+60,ID.BasicEnemy,handler));
			handler.addObject(new HardEnemy(r.nextInt(200)+60,r.nextInt(100)+200,ID.BasicEnemy,handler));
		}

		else if(hud.getScore()==750)
			handler.addObject(new FastEnemy(r.nextInt(100)+60,r.nextInt(100)+60,ID.FastEnemy,handler));
		else if(hud.getScore()==1000)
			handler.addObject(new FastEnemy(r.nextInt(100)+60,r.nextInt(100)+60,ID.FastEnemy,handler));
		else if(hud.getScore()==1300)
			handler.addObject(new SmartEnemy(r.nextInt(100)+60,r.nextInt(100)+60,ID.SmartEnemy,handler));
		else if(hud.getScore()==1700)
		{handler.clearEnemy();
		handler.addObject(new EnemyBoss((1350/2)-32,60,ID.EnemyBoss,handler));
		}}
		
	}
	

}
