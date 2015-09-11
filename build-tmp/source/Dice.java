import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die one;
public void setup()
{
	noLoop();
	size(600,600);
	
}
public void draw()
{
	strokeWeight(10);
	background(127);
	for(int y = 0; y < 600; y+=200)
	{
		for(int x = 0; x < 600; x+=200)
		{
			one = new Die(x,y);
			one.show();
		}
	}
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int myX, myY;
	int rolling = (int)(Math.random()*6)+1;
	Die(int x,int y)    //constructor
	{
		myX = x;
		myY = y;
	}
	public void show()
	{
		System.out.println(rolling);
		fill(255);
		rect(myX,myY,200,200);
		fill(0);
		if(rolling == 1)
		{
			ellipse(myX+100,myY+100,30,30);
		}
		if(rolling == 2)
		{
			ellipse(myX+50,myY+50,30,30);
			ellipse(myX+150,myY+150,30,30);
		}
		if(rolling == 3)
		{
			ellipse(myX+50,myY+50,30,30);
			ellipse(myX+150,myY+150,30,30);
			ellipse(myX+100,myY+100,30,30);
		}
		if(rolling == 4 || rolling == 5 || rolling ==6)
		{
			ellipse(myX+50,myY+50,30,30);
			ellipse(myX+150,myY+150,30,30);
			ellipse(myX+150,myY+50,30,30);
			ellipse(myX+50,myY+150,30,30);
			if(rolling == 5)
			{
				ellipse(myX+100,myY+100,30,30);
			}
			if(rolling == 6)
			{
				ellipse(myX+50,myY+100,30,30);
				ellipse(myX+150,myY+100,30,30);
			}
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
