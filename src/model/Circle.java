package model;

import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Circle extends Shape {
	
	public Circle() throws IOException {
		this.s = 1 ;
		this.image=ImageIO.read(new File("../circusOfplates/src/images/App-core-bomb-icon.png"));
		// TODO Auto-generated constructor stub
		this.type="circle";
	}
	
	
	
	}
