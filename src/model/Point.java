package model;

public class Point implements java.io.Serializable{

	private int x,y;
	public Point(int xx, int yy){
		x=xx;
		y=yy;
	}
	
	public void setX(int xx){
		x=xx;
	}
	public void setY(int yy){
		y=yy;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
}
