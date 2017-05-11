package dyWeb;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.cglib.core.Constants;

public class ServletProcessor1 {
	public void process(Request request, Response response)
			throws ServletException, IOException {
		// String uri=request.getUri();
		// String servletName=uri.substring(uri.lastIndexOf("/")+1);
		// System.out.print(servletName);
		// URLClassLoader loader=null;
		//
		// URL[]urls =new URL[1];
		// URLStreamHandler streamHandler=null;
		//
		// File classPath=new File(Constans.WEB_ROOT);
		//
		// try {
		// String repository =(new
		// URL("file",null,classPath.getCanonicalPath()+File.separator)).toString();
		// urls[0]=new URL(null,repository,streamHandler);
		// loader=new URLClassLoader(urls);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// System.out.println(e.toString());
		// }
		//
		//
		// Class myclass=null;
		//
		// try{
		//
		// myclass=loader.loadClass(servletName);
		// }catch(ClassNotFoundException e){
		// System.out.println(e.toString());
		// }
		//
		// Servlet servlet=null;
		//
		// try {
		// servlet=(Servlet)myclass.newInstance();
		// servlet.service((ServletRequest)request,(ServletResponse)response);
		// } catch (InstantiationException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		//
		//
		// }

		String uri = request.getUri();
		String servletName = uri.substring(uri.lastIndexOf("/") + 1);
		URLClassLoader loader = null;
		try {
			// create a URLClassLoader
			URL[] urls = new URL[1];
			URLStreamHandler streamHandler = null;
			File classPath = new File(Constans.WEB_ROOT);
			String repository = (new URL("file", null,
					classPath.getCanonicalPath() + File.separator)).toString();   //error

			urls[0] = new URL(null, repository, streamHandler);
			System.out.print(urls[0].toString());
			loader = new URLClassLoader(urls);
			
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		Class myClass = null;
		try {
			myClass = loader.loadClass(servletName); // 主机 加载要写全限定名
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		Servlet servlet = null;
		try {
			servlet = (Servlet) myClass.newInstance();
			servlet.service((ServletRequest) request,
					(ServletResponse) response);
		} catch (Exception e) {
			System.out.println(e.toString());
		} catch (Throwable e) {
			System.out.println(e.toString());
		}
	}

}
