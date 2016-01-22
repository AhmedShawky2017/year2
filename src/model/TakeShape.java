package model;

import java.util.Observable;

public class TakeShape extends Observable{
	public  player player;
	public int RightHandHieght = 0;
	public int LeftHandHieght = 0;
	public boolean update=false;
	
	public TakeShape(player player) {
		this.player = player;

	}

	public void takeInHand(Shape shape) {

		if ((((shape.x - player.getLocationX())) < 100)
				&& (shape.x - player.getLocationX() > 0)
				&& (shape.y - (player.getLocationY() + RightHandHieght)) < 20
				&& (shape.y - (player.getLocationY() + RightHandHieght)) > 0
				&& shape.belongToPlayer==false
				&& !player.fullHandedRight()) {
			shape.belongToPlayer=true;
			shape.inHand = true;
			shape.x=player.getLocationX()+70;
			this.RightHandHieght -= 60;
			player.playerRightHand.add(shape);
			System.out.println(player.playerRightHand.size());
			

		}
		else if (((( player.getLocationX()-shape.x )) < 100)
				&& (player.getLocationX()-shape.x   > 0)
				&& ( (player.getLocationY()-shape.y  + LeftHandHieght)) < 20
				&& ((player.getLocationY()-shape.y  + LeftHandHieght)) > 0
				&& shape.belongToPlayer==false
				&& !player.fullHandedLeft()){
			shape.belongToPlayer=true;
			shape.inHand = true;
			shape.x=player.getLocationX()-50;
			this.LeftHandHieght -= 60;
			player.playerLeftHand.add(shape);
			
		}

	}
	

}
