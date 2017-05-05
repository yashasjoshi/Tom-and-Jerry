package project;

//import java.applet.AudioClip;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.net.URL;
import java.util.Random;
import java.applet.*;
import java.awt.*;
public class Game extends Canvas implements Runnable{ // Extends in to inherit any other class
													// Here Canvas is inherited by Game
	private static final long serialVersionUID = 7141660673071146540L;

	public static final int WIDTH = 1350, HEIGHT = WIDTH/12*6;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	public static boolean paused=false;
	public int diff=0;
	private Shop shop;
	public enum STATE
	{
		Menu,Game,Help,End,Select,Shop
	};
	public static STATE gameState=STATE.Menu;
	
	public Game(){
		handler=new Handler();
		hud=new HUD();
		shop=new Shop(handler,hud);
		menu=new Menu(this,handler,hud);
		
		//AudioPlayer.load();
		//AudioPlayer.getMusic("music").loop();
		this.addMouseListener(menu);
		this.addKeyListener(new KeyInput(handler,this));
		this.addMouseListener(shop);
		new Window(WIDTH, HEIGHT, "TOM AND JERRY", this);// this will call the window constructor which starts the run method
		Random r=new Random();
		spawner=new Spawn(handler,hud,this);
		
		if(gameState== STATE.Game)
		{
			for(int i=0;i<20;i++)handler.addObject(new Background(r.nextInt(1350),66+r.nextInt(1350/12*6),ID.back,handler));
			handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.player,handler));// here we are adding game object player to the linked list
			handler.addObject(new BasicEnemy(65,65,ID.BasicEnemy,handler));
		}else
		{
			for(int i=0;i<10;i++)handler.addObject(new MenuParticle(r.nextInt(1150)+50,66+r.nextInt(500)+50,ID.Particle,handler));
		}
		
		/*this creates a game object of type player having a id.
		 create as many game objects of type player having different id's (given in ID class),
		 in player class we can create specifications regarding	different id's.*/
		
	}
	
	public synchronized void start(){
		thread = new Thread(this);// creating thread object for this instance of game
		thread.start();
		running = true;// telling whether our thread is running
	}
	
	public synchronized void stop(){
		try{
			thread.join();// this is stopping or killing the thread
			running = false;			
		}catch(Exception e){
			e.printStackTrace();// will give the reason in our console, why did our thread stop
		}
	}
	
	public void run(){
		
		//this below code is known as a game loop, this updates the screen after every interval
		//explaining the game loop
		//we need a loop that performs 2 things: it checks whether 
		//enough time has passed 1/60 second to refresh the game,
		// and checks whether enough time has passed   1 second   to refresh the FPS counter;
		//  while running it adds the time it took to go through one iteration of the loop it self 
		//  and adds it to delta   which is simplified to 1   so once it reaches 1 delta it means enough
		//   time has passed to go forward one tick.
		
		this.requestFocus();//this is to automatically focus on game screen, without clicking.
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1){
				tick();				//calling our tick method which basically updates the coordinates of the objects
				delta--;
			}
			if(running)
				render();		// calling the render method to render the updated value of each game object
			
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				
			}
		}
		stop();
	}
	Random r=new Random();
	private void tick(){
		
		if(gameState == STATE.Game)
		{	if(!paused){
			handler.tick();// calling the tick method of handler class for all the game objects
			hud.tick();
			spawner.tick();
			if(HUD.Health<=0)
			{HUD.Health=100;
			gameState=STATE.End;
			handler.clearEnemy();
			for(int i=0;i<10;i++)handler.addObject(new MenuParticle(r.nextInt(1150)+50,66+r.nextInt(500)+50,ID.Particle,handler));
			
			}}
		}
		else if(gameState == STATE.Menu || gameState==STATE.End ||gameState == STATE.Help ||gameState == STATE.Select)
		{
			menu.tick();
			handler.tick();// calling the tick method of handler class for all the game objects
		}
		
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);  // We can change the whole background color from here
		g.fillRect(0, 60, WIDTH, HEIGHT);
		g.setColor(Color.orange);
		g.fillRect(0, 0, WIDTH, 60);
		
		if(paused)
		{
			Font fnt= new Font("arial",1,20);
			g.setFont(fnt);
			g.setColor(Color.black);
			g.drawString("PAUSED", 700, 30);}
		if(gameState== STATE.Game)
		{
			hud.render(g);// calling the render method of heads up class to refresh the health bar
			handler.render(g);// calling the render method for all the game objects
		}
		else if(gameState==STATE.Shop)
		{
			shop.render(g);
		}
		else if(gameState == STATE.Menu || gameState == STATE.Help|| gameState==STATE.End ||gameState == STATE.Select)
		{
			menu.render(g);
			handler.render(g);// calling the render method for all the game objects
		}
		
		g.dispose(); 
		bs.show();		
	}
	public static float clamp(float var,float min,float max)
	{	//if the variable tries to increase more than max then we will keep it to max and vice versa
		if(var>=max)
			return var=max;
		else if(var<=min)
			return var=min;
		else
			return var;
	}
	  
	public static void main(String args[]){
		new Game();
		
	}
}
