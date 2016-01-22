//package model;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//
//	
//public class serial {
//	
//	
//	private void serialize() {
//		String URL = GUi.getURL_Saving() + ".ser";
//		try {
//			FileOutputStream fileOut = new FileOutputStream(URL);
//			ObjectOutputStream out = new ObjectOutputStream(fileOut);
//			out.writeObject(model);
//			out.close();
//			fileOut.close();
//		} catch (IOException i) {
//			i.printStackTrace();
//		}
//	}
//
//	private GameModel deserialize() {
//		GameModel gameModel = null;
//		String URL = view.getURL_Loading();
//		try {
//			FileInputStream fileIn = new FileInputStream(URL);
//			ObjectInputStream in = new ObjectInputStream(fileIn);
//			gameModel = (GameModel) in.readObject();
//			in.close();
//			fileIn.close();
//		} catch (ClassNotFoundException c) {
//			c.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return gameModel;
//	}
//
//}
