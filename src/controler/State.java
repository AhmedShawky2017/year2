package controler;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import model.Shape;

public class State {
	Random random=new Random();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width=screenSize.getWidth();
	public void checkState(Shape shape){
		if(!shape.inHand && shape.y>700){
        	shape.y=0;
        	shape.x=random.nextInt((int)width-200);
        	shape.randomDelayedStart=random.nextInt(6000)+600;
		}
	}

}
