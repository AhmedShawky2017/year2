package controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.player;
import view.Gui;

public class SaveLoad {
	Gui gui;
	public void save(player p,String url){
		
	try
    {
       FileOutputStream fileOut =
       new FileOutputStream(url+".ser");
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(p);
       out.close();
       fileOut.close();
//       System.out.printf("Serialized data is saved in /tmp/employee.ser");
    }catch(IOException i)
    {
        i.printStackTrace();
    }
 }
	public player load(String url){
		 player e;
		try
	      {
	         FileInputStream fileIn = new FileInputStream(url+".ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e =  (player)in.readObject();
	         e.conv();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return null;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	        return null;
	      }
		return e;
	}
}

