package model;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Pool {

	
	private static ArrayList<Shape> unused , using;
	private static Pool instance ;
	
	
	
	private Pool() throws IOException{	
		unused = new ArrayList<>();
		using  = new ArrayList<>();
		ShapeFactory shapeFactory=new ShapeFactory();
		shapeFactory.loadfirst();
		for (int i = 0; i < 30; i++) {
			unused.add(  shapeFactory.makeShape("Circle"));
			unused.add( shapeFactory.makeShape("Rocket"));
			unused.add( shapeFactory.makeShape("Skull"));
			Collections.shuffle(unused);
		}
		
		/*
		 * code for adding shapes for the first time in unused arraylist
		 */
	}
	

	
	// singlton used here to make one object of pool class 
	public static 	Pool getInstance() throws IOException{
		if(instance == null){
			instance = new Pool();
		}
		return instance ;
	}
	
	public Shape getobject(){
		if(unused.size()>0){
		using.add(unused.remove(0));
		return using.get(using.size()-1);
		}
		else{
			System.out.println("empty arrayList");
			return null;
		}
	}
	
	public void giveobject(Shape s){
		unused.add(s);
		using.remove(s);
	}
	public ArrayList<Shape> getUnusedList(){
		return unused;
		
	}
	
}
