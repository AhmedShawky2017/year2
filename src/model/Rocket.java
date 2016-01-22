package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rocket extends Shape{
	
	public Rocket() throws IOException{ 
		s = 2;
		this.image=ImageIO.read(new File("../circusOfplates/src/images/Burn-icon.png"));
	this.type="rocket";
	}
}
 