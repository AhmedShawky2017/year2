package model;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class player implements java.io.Serializable {
	
	public transient ArrayList <Shape> playerRightHand;
	public ArrayList<Integer> pr,pl;
	public transient ArrayList <Shape> playerLeftHand;
	private transient BufferedImage pic = null;
	public byte[] imageInByte;
	public transient ByteArrayOutputStream baos ;
	private Point point ;
	private int score ;
	
	public player(String url, Point p){
		try {
			baos = new ByteArrayOutputStream();
			playerRightHand=new ArrayList();
			playerLeftHand=new ArrayList();
			pic = ImageIO.read(new File(url));
			ImageIO.write(pic, "jpg", baos );
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
			
			point = p;
			score = 0 ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void conv(){
		
			
			InputStream in = new ByteArrayInputStream(imageInByte);
			try {
				pic = ImageIO.read(in);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	public void setScore(int sc) {
		score = score + sc;
	}

	public void increamentScore() {
		score++;
	}

	public int getScore() {
		return score;
	}

	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point p) {
		point = p;
	}


	public BufferedImage getImage() {
		return pic;
	}

	public void setImage(String url) {
		try {
			pic = ImageIO.read(new File(url));
		} catch (IOException e) {
			System.out.println("Image Not Found!");
		}
	}

	public void setLocation(int x, int y) {
		point.setX(x);
		point.setY(y);
	}

	public void setLocationX(int x) {
		
		point.setX(x);
	}

	public void setLocationY(int y) {
		
		point.setY(y);

	}

	public int getLocationX() {
		return point.getX();
	}

	public int getLocationY() {
		return point.getY();
	}
	public boolean fullHandedRight(){
		//System.out.println(playerRightHand.size());
		if(this.playerRightHand.size()>=10){
			return true;
		}
		else{
			return false;
		}
		
	}
	public boolean fullHandedLeft(){
		if(this.playerLeftHand.size()>=10){
		return true;
		}
		else {
			return false;
		}
	}

}