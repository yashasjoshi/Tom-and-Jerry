package project;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject { // every object in our game get the structure and functionality from this class
	// every game object we create will extend this class
	protected float x, y;
	protected ID id;// a unique id for every game object
	protected float velX, velY; //velocity in X and Y direction
	protected Handler handler;
	public GameObject(float x, float y, ID id,Handler handler)// whenever we create a game object instance like Player, it will initialize the values
	{
		this.x=x;
		this.y=y;
		this.id=id;
		this.handler=handler;
	}
	public abstract void tick(); // the subclass will implement tick and render accordingly
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); // rectangle class has methods which will return true if two rectangles intersect
	public void setX(float x)
	{this.x=x;
	}
	public void setY(float y)
	{this.y=y;
	}
	public void setId(ID id)
	{
		this.id=id;
	}
	public float getX()
	{
		return x;
	}
	public float getY()
	{
		return y;
	}
	public ID getId()
	{return id;}
	public void setVelX(float velX)
	{
		this.velX=velX;
	}
	public void setVelY(float velY)
	{
		this.velY=velY;
	}
	public float getVelX()
	{
		return velX;
	}
	public float getVelY()
	{
		return velY;
	}

}
