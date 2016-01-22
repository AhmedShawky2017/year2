package controler;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.Shape;
import model.TakeShape;
import model.player;

public class Observer1  {
	TakeShape taken; 
	
	public Observer1(TakeShape inHand) {
		this.taken=inHand;
		
	}
	
	public void update(boolean update, Object arg1) {
		
		if(taken.player.playerLeftHand.size()>=3){
			Shape z=taken.player.playerLeftHand.get(taken.player.playerLeftHand.size()-1);
			Shape y=taken.player.playerLeftHand.get(taken.player.playerLeftHand.size()-2);
			Shape x=taken.player.playerLeftHand.get(taken.player.playerLeftHand.size()-3);
			if (z.type.equals(y.type)&& y.type.equals(x.type) ){
				for (int i = 0; i < 3; i++) {
					taken.player.playerLeftHand.remove(taken.player.playerLeftHand.size()-1);
				}
				z.y=-40;
				y.y=-40;
				x.y=-50;
				taken.update=true;
				taken.LeftHandHieght=taken.LeftHandHieght+3*60;
				taken.player.setScore(30);
				
			}
		}
		if(taken.player.playerRightHand.size()>=3){
			Shape c=taken.player.playerRightHand.get(taken.player.playerRightHand.size()-1);
			Shape b=taken.player.playerRightHand.get(taken.player.playerRightHand.size()-2);
			Shape a=taken.player.playerRightHand.get(taken.player.playerRightHand.size()-3);
			if(c.type.equals(b.type)&& b.type.equals(a.type)){
				for (int i = 0; i <3 ; i++) {
					taken.player.playerRightHand.remove(taken.player.playerRightHand.size()-1);
				}
				c.y=-40;
				b.y=-40;
				a.y=-40;
				taken.RightHandHieght=taken.RightHandHieght+3*60;
				taken.player.setScore(30);
				
			}
		}
			
	} 

}
