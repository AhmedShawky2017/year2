package model;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ShapeFactory {
	
	private ArrayList<Class<?>> shapeClass = new ArrayList<Class<?>>();
	
	public void loadfirst(){
		
		try {
			shapeClass.add(ClassLoader.getSystemClassLoader().loadClass(
					"model.Circle"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			shapeClass.add(ClassLoader.getSystemClassLoader().loadClass(
					"model.Rocket"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			shapeClass.add(ClassLoader.getSystemClassLoader().loadClass(
					"model.Skull"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Shape makeShape(String shape) throws IOException{
//		System.out.println(shapeClass.size());
		if(shapeClass.size() != 3){
			loadfirst();
		}
		else{
			if(shape.equals("Circle")){
				
				try {
					return  (Shape) (shapeClass.get(0).newInstance());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(shape.equals("Rocket")){
				try {
					System.out.println();
					return (Shape) (shapeClass.get(1).newInstance());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(shape.equals("Skull")){
				try {
					return (Shape) (shapeClass.get(2).newInstance());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("NULL");
		return null ;	
	}
	
	
	
	
}
