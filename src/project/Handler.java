package project;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import project.Game.STATE;

public class Handler { 
	// this class basically updates every Game object and renders them on screen after the refreshment takes place
	// here we will put all the game objects in a linked list
	
	LinkedList<GameObject> object=new LinkedList<GameObject>();
	public int spd=5;
	Random r=new Random();
	public void tick() // this method is called from the game class
	{
		for(int i=0;i<object.size();i++) // this will run for the number if game objects we have
		{
			GameObject tempObject = object.get(i);// this will return the game object id one by one in the linked list 
			tempObject.tick(); // here we are updating the game object say its position or color 
			// by calling the tick method of respective game objects like player, enemy
		}
	}
	public void clearEnemy()
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.tick();
			if(tempObject.getId()== ID.player)
			{
				object.clear();
				if(Game.gameState!=STATE.End){
				addObject(new Player((int)tempObject.getX(),(int)tempObject.getY(),ID.player,this));
				for(int j=0;j<200;j++)addObject(new Background(r.nextInt(1350),66+r.nextInt(1350/12*6),ID.back,this));
			}}
		}
	}
	public void render(Graphics g)// this method is called from the game class
	{
		for(int i=0;i<object.size();i++)
		{
			GameObject tempObject = object.get(i);
			tempObject.render(g);// and here we are rendering the updated game object
			// by calling the render method of respective game objects like player, enemy
		}
	}
	public void addObject(GameObject object) //to add the game object in the game object linked list
	{
		this.object.add(object);
	}
	public void remove(GameObject object)// to remove the game object from the linked list
	{
		this.object.remove(object);
		
	}
	

}
