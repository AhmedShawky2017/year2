package model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import controler.State;

public abstract  class Shape implements java.io.Serializable  {

	public int x =0;
	public int y=0;
//	int width=20;
	public int s ;
	int INCREMENT=6;
	public boolean draw=false;
	 public boolean inHand=false;
	public  boolean belongToPlayer=false;
	public int randomDelayedStart;
	public BufferedImage  image;
	public String type;
	Random random=new Random();
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	public Shape() throws IOException{
		
		randomDelayedStart = random.nextInt(4000)+40;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		x=random.nextInt((int)width-100);
		this.inHand=false;
		
	}
	public void move(int y) {
		// TODO Auto-generated method stub
			State state=new State();
			if (this.draw ) {
				if(!this.inHand){
                this.y += INCREMENT;
				}
                if(!this.inHand && this.y>700){
                	
                	state.checkState(this);
                	this.draw=false;
				
				}
           } 
        
	}
	public void decreaseDelay() {
		
        if (randomDelayedStart <= 0) {
        	  draw = true;
        } else {
            this.randomDelayedStart -= 1;
        }
    }
	public BufferedImage getImage(){
		return image=this.image;
		
	}
	
	public void sets(int f){
		this.s = f ;
	}
	public void drawShape(Graphics g) throws IOException {
		{
			 
			if (draw) {
	        	 
	        	 
	             g.drawImage(this.image, this.x,this.y, null);
	             
	         }
	     }
		
	}

}
	
	
	
	

