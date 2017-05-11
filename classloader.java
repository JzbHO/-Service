package dyWeb;

import java.net.URL;
import java.net.URLClassLoader;

public class classloader {
	
	
	
	public static void main(String []args){
		try {  
		    System.out.println("==========test2=========");  
		    URL[] urls = new URL[] {  
		            new URL("file:/" + System.getProperty("user.dir") + "/src/dyWeb/")  
		            // new URL("file:/" + System.getProperty("user.dir") + "/urlclassloaderpath/")  
		    };  
		   // E:\newME\Project\Test\src\dyWeb\TT1.java
		    for(URL u : urls) {  
		        System.out.println(u.toString());     
		                                              
		    }  
		      
		    URLClassLoader ul = new URLClassLoader(urls);  
		  
		    Class<?> c = ul.loadClass("TT1");  
		    System.out.println(c);  
		  
		  //  c = ul.loadClass("urlclassloader.test.Test");  
		    System.out.println(c);  
		   // System.out.println("==========test2=========" + rt);  
		} catch (Exception e) {  
		    System.out.println("test2():"+e);  
		}  
	}

}
