//package model;
//
//
//
//import java.io.File;
//import java.lang.reflect.Method;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLClassLoader;
//
//public class DynamicLoading {
//	
//	public void load(URL url) {
//        // use reflection to get the system method of addurl and use it so we
//        // can use the system classloader directly
//        URLClassLoader loader;
//        loader = (URLClassLoader) ClassLoader.getSystemClassLoader();
//        Method addNewURLMethod = null;
//        try {
//                addNewURLMethod = URLClassLoader.class.getDeclaredMethod("addURL",
//                                URL.class);
//                addNewURLMethod.setAccessible(true);
//        } catch (Exception e1) {
//                e1.printStackTrace();
//        }
//
//        // start dynamic class loading from here
//        try {
//                String g = url.toString();
//                String className = url.getFile();
//                className = className.substring(className.lastIndexOf("/") + 1,
//                                className.lastIndexOf("."));
//                g = g.substring(0, g.lastIndexOf("/") + 1);// get the path
//                url = new URL(g);// the final URL to load class from
//                addNewURLMethod.invoke(loader, url);
////                shapeClass.add(loader.loadClass(className));
//        } catch (Exception e) {
//                e.printStackTrace();
//        }
//}
//	 
//}
